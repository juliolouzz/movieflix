package br.com.movieflix.config;

import br.com.movieflix.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

    @Value("${movieflix.security.secret}")
    private String secret;

    public String generateToken(User username) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(username.getEmail())
                .withClaim("userId", username.getId())
                .withClaim("name", username.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API MovieFlix")
                .sign(algorithm);

    }
}
