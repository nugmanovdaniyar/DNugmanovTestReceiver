package ru.nugmanov.DNugmanovTestReceiver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.nugmanov.DNugmanovTestReceiver.service.impl.MessageServiceImp;

import java.util.Map;

/**
 * Контроллер главной страницы
 *
 * @author NugmanovDT, 05.11.2020
 */
@Controller
@RequestMapping("/")
public class MainPageController {
    private final MessageServiceImp messageService;

    public MainPageController(MessageServiceImp messageService) {
        this.messageService = messageService;
    }

    /**
     * Возвращает главную страницу с письмами
     */
    @GetMapping()
    public String getMessages(Map<String, Object> model) {
        model.put("messages", messageService.findAllByOrderByDate());
        return "main";
    }
}
