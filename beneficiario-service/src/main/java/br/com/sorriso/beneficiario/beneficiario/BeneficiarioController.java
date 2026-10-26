package br.com.sorriso.beneficiario.beneficiario;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiarioController {

 private final BeneficiarioService service;

 public BeneficiarioController(BeneficiarioService service) {
  this.service = service;
 }

 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Beneficiario create(
         @Valid @RequestBody BeneficiarioRequest request) {
  return service.create(request);
 }

 @GetMapping
 public List<Beneficiario> findAll() {
  return service.findAll();
 }

 @GetMapping("/{id}")
 public Beneficiario findById(@PathVariable("id") Long id) {
  return service.findById(id);
 }

 @PutMapping("/{id}")
 public Beneficiario update(
         @PathVariable("id") Long id,
         @Valid @RequestBody BeneficiarioRequest request) {
  return service.update(id, request);
 }

 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void delete(@PathVariable("id") Long id) {
  service.delete(id);
 }
}