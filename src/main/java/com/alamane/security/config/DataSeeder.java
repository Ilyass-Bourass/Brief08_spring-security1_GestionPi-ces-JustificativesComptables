package com.alamane.security.config;

import com.alamane.security.entity.Societe;
import com.alamane.security.entity.User;
import com.alamane.security.enums.Role;
import com.alamane.security.repository.SocieteRepository;
import com.alamane.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final SocieteRepository societeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if(societeRepository.count() == 0) {
            Societe s1 = Societe.builder()
                    .raisonSociale("Alpha SARL")
                    .ice("ICE123456")
                    .telephone("0600000001")
                    .adresse("Rue Alpha, Casablanca")
                    .email("alpha@example.com")
                    .build();

            Societe s2 = Societe.builder()
                    .raisonSociale("Beta SARL")
                    .ice("ICE654321")
                    .telephone("0600000002")
                    .adresse("Rue Beta, Rabat")
                    .email("beta@example.com")
                    .build();

            societeRepository.save(s1);
            societeRepository.save(s2);
        User u1 = User.builder()
                .nomComplet("Comptable Admin")
                .email("comptable@example.com")
                .password(passwordEncoder.encode("123456"))
                .role(Role.COMPTABLE)
                .actif(true)
                .build();

        User u2 = User.builder()
                .nomComplet("User Alpha")
                .email("user.alpha@example.com")
                .password(passwordEncoder.encode("123456"))
                .role(Role.SOCIETE)
                .societe(s1)
                .actif(true)
                .build();

        User u3 = User.builder()
                .nomComplet("User Beta")
                .email("user.beta@example.com")
                .password(passwordEncoder.encode("123456"))
                .role(Role.SOCIETE)
                .societe(s2)
                .actif(true)
                .build();

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
    }
    }
}
