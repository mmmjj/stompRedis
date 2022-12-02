package com.example.mmmj.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public abstract class ChatMessageRepository extends JpaRepositoriesAutoConfiguration {
}
