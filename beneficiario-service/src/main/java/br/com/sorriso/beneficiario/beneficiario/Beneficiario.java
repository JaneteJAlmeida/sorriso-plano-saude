package br.com.sorriso.beneficiario.beneficiario;
import jakarta.persistence.*;

@Entity
@Table(name = "beneficiarios")
public class Beneficiario {

 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @Column(nullable=false)
 private String nome;
 private String telefone;
 @Column(unique=true)
 private String email;
 public Beneficiario() {}
 public Beneficiario(String nome,String telefone,String email){
  this.nome=nome;
  this.telefone=telefone;
  this.email=email;}

 public Long getId(){
  return id;}

 public void setId(Long id){
  this.id=id;}

 public String getName(){
  return nome;}

 public void setName(String nome){
  this.nome=nome;}

 public String getPhone(){
  return telefone;}
 public void setPhone(String telefone){
  this.telefone=telefone;}

 public String getEmail(){
  return email;}

 public void setEmail(String email){
  this.email=email;}
}
