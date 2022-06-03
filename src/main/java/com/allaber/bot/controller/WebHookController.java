package com.allaber.bot.controller;

import com.allaber.bot.TelegramCorpEdoBot;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {

    private final TelegramCorpEdoBot telegramCorpEdoBot;

    public WebHookController(TelegramCorpEdoBot telegramCorpEdoBot) {
        this.telegramCorpEdoBot = telegramCorpEdoBot;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramCorpEdoBot.onWebhookUpdateReceived(update);
    }
}
