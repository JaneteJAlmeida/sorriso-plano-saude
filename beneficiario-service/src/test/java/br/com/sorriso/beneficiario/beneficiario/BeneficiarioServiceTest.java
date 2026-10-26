package br.com.sorriso.beneficiario.beneficiario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class BeneficiarioServiceTest {
 @Mock BeneficiarioRepository repository;
 @InjectMocks BeneficiarioService service;
 @Test void createShouldPersistBeneficiario(){
  var request=new BeneficiarioRequest("Maria Silva","73999990000","maria@example.com");
  when(repository.save(any(Beneficiario.class))).thenAnswer(i->i.getArgument(0));
  var result=service.create(request);
  assertEquals("Maria Silva",result.getName()); verify(repository).save(any(Beneficiario.class));
 }
 @Test void findAllShouldReturnRepositoryItems(){
  when(repository.findAll()).thenReturn(List.of(new Beneficiario("Ana","111","ana@example.com")));
  assertEquals(1,service.findAll().size());
 }
 @Test void findByIdShouldThrowWhenMissing(){when(repository.findById(99L)).thenReturn(Optional.empty());assertThrows(org.springframework.web.server.ResponseStatusException.class,()->service.findById(99L));}
}
