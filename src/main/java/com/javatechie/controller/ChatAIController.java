package com.javatechie.controller;

import com.javatechie.service.ChatAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ai")

public class ChatAIController
{
    @Autowired
    private ChatAIService chatAIService;
    @GetMapping("/prompt")
    public String askToAI(@RequestParam(value = "question") String question)
    {
        return chatAIService.askToDeepSeekAI(question);
    }

    @GetMapping("/prompt/stream")
    public Flux<String> askToAIWithStream(@RequestParam(value = "question") String question)
    {
        return chatAIService.askToDeepSeekAIWithStream(question);
    }
}
