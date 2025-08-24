package br.com.movieflix.controller.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MovieRequest(String title, String description, LocalDate releaseDate, double rating, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
