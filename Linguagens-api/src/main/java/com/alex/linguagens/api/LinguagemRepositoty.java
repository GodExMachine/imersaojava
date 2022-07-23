package com.alex.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepositoty extends MongoRepository<Linguagem, String> {
    
}
