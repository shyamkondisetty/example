package com.javabootcamp.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ExampleApplication {

//	@Autowired
//	static StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);


	}


	@Bean
	public CommandLineRunner saveDetails(StudentRepository studentRepository) {
		return (args) -> {
			// Create a student entry using jpa

			StudentModel saikumarDetails = new StudentModel();
			saikumarDetails.setName("Sai Kumar");
			saikumarDetails.setAge(25);
			studentRepository.save(saikumarDetails);


			// Get a student entry using jpa

			StudentModel saiKumarDetailsGet = studentRepository.findById(1L).get();

			System.out.println("Student Name : "+ saiKumarDetailsGet.getName());
			System.out.println("Student Age : "+ saiKumarDetailsGet.getAge());


			// Update a student using jpa
			saiKumarDetailsGet.setName("Shyam");
			studentRepository.save(saiKumarDetailsGet);

			StudentModel saiKumarDetailsAfterUpdate = studentRepository.findById(1L).get();

			System.out.println("Student Name After Update: "+ saiKumarDetailsAfterUpdate.getName());
			System.out.println("Student Age After update: "+ saiKumarDetailsAfterUpdate.getAge());

			// Delete the student details

			studentRepository.delete(saiKumarDetailsAfterUpdate);

		};
	}

}
