package com.allaber.bot.config;

import com.allaber.bot.TelegramCorpEdoBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Setter
@Getter
@Configuration
@ConfigurationProperties
public class BotConfig {
    private String name;
    private String token;
    private String webHookPath;

    @Bean
    public TelegramCorpEdoBot TelegramCorpEdoBot() {
        DefaultBotOptions options = new DefaultBotOptions();

        TelegramCorpEdoBot telegramCorpEdoBot = new TelegramCorpEdoBot(options);
        telegramCorpEdoBot.setName(name);
        telegramCorpEdoBot.setToken(token);
        telegramCorpEdoBot.setWebHookPath(webHookPath);

        return telegramCorpEdoBot;
    }
}
