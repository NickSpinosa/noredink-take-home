package com.nick.spinosa.noredinktakehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@SpringBootApplication
public class NoredinkTakeHomeApplication {

	public static void main(String[] args) {

		SpringApplication.run(NoredinkTakeHomeApplication.class, args);
	}

	public String buildQuiz(int numberOfQuestions) {
		Distributor dist = new Distributor();

		return dist.distributeQuestions(0)
						.stream()
						.map(q -> q.getId())
						.map(id -> id.toString())
						.collect(Collectors.joining(", "));
	}
}
