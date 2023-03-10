package com.example.webhomework3.models;

import com.example.webhomework3.enums.TypeOfPhrase;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phrase {
    private String phrase;
    private TypeOfPhrase typeOfPhrase;
}
