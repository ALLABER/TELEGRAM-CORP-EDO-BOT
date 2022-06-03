package com.allaber.bot;

import lombok.Setter;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Setter
public class TelegramCorpEdoBot extends TelegramWebhookBot {
    private String name;
    private String token;
    private String webHookPath;

    public TelegramCorpEdoBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() == null) return null;

        if (update.getMessage().hasText()) {
            String chatId = String.valueOf(update.getMessage().getChat().getId());
            try {
                execute(new SendMessage(chatId, "Hello, " + update.getMessage().getText()));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }
}
