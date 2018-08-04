package com.nick.spinosa.noredinktakehome;

import com.nick.spinosa.noredinktakehome.persistence.InMemoryQuestionStore;
import com.nick.spinosa.noredinktakehome.persistence.QuestionStore;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@SpringBootApplication
public class NoredinkTakeHomeApplication {
	private QuestionStore store = new InMemoryQuestionStore();

	public static void main(int[] args) {

//		SpringApplication app = new SpringApplication(NoredinkTakeHomeApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
		run(args);
//		SpringApplication.run(NoredinkTakeHomeApplication.class, args);
	}

	public static void run(int... args) {
		System.out.println("HELLO WORLD");
//		if(args.length > 0) {
//			System.out.println("only 1 argument accepted: Number of Questions");
//		} else {
//			System.out.println(buildQuiz(args[0]));
//		}
	}

	public String buildQuiz(int numberOfQuestions) {
		Distributor dist = new Distributor(store);

		return dist.distributeQuestions(0)
						.stream()
						.map(q -> q.getId())
						.map(id -> id.toString())
						.collect(Collectors.joining(", "));
	}
}
