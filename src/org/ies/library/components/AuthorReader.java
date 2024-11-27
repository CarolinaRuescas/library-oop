package org.ies.library.components;

import org.ies.library.model.Author;

import java.util.Scanner;

public class AuthorReader {
    private final Scanner scanner;

    public AuthorReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Author read(){
        System.out.println("Introduce los siguientes datos sobre el autor:");
        System.out.println("Introduce el NIF:");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String name = scanner.nextLine();
        System.out.println("Introduce el apellido");
        String surname = scanner.nextLine();


        return new Author (
                nif,
                name,
                surname
        );
    }
}
