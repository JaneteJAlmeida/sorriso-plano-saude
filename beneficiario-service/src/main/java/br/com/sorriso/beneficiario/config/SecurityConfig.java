package br.com.sorriso.beneficiario.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@SuppressWarnings("deprecation")
public class SecurityConfig {

 @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  return http.csrf(csrf->csrf.disable())
          .authorizeHttpRequests(a->a
                  .requestMatchers("/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**","/h2-console/**")
                  .permitAll()
                  .anyRequest()
                  .authenticated()).httpBasic(Customizer
                  .withDefaults()).headers(h->h.frameOptions(f->f.sameOrigin()))
                  .build();
 }
 @Bean UserDetailsService users(){
  return new InMemoryUserDetailsManager(User.withUsername("sorriso")
          .password("sorriso123").roles("USER").build());}

 @Bean PasswordEncoder passwordEncoder(){
  return NoOpPasswordEncoder.getInstance();}
}
