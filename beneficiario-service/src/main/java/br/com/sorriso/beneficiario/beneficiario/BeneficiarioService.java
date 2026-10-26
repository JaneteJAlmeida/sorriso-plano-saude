package br.com.sorriso.beneficiario.beneficiario;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class BeneficiarioService {

 private final BeneficiarioRepository repository;
 public BeneficiarioService(BeneficiarioRepository repository){
  this.repository=repository;}
 public Beneficiario create(BeneficiarioRequest r){
  return repository.save(
          new Beneficiario(r.nome(),r.telefone(),r.email()));}

 public List<Beneficiario> findAll(){
  return repository.findAll();}

 public Beneficiario findById(Long id){
  return repository.findById(id).orElseThrow(()->
          new ResponseStatusException(HttpStatus.NOT_FOUND,"Beneficiário não encontrado"));}

 public Beneficiario update(Long id,BeneficiarioRequest r){Beneficiario b=findById(id);b.setName(r.nome());b.setPhone(r.telefone());b.setEmail(r.email());
  return repository.save(b);}

 public void delete(Long id){
  if(!repository.existsById(id))
   throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Beneficiário não encontrado");repository.deleteById(id);}
}
