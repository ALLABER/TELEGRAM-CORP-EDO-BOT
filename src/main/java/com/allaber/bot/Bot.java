package com.allaber.bot;

import com.allaber.bot.repository.Employee;
import com.allaber.bot.service.PdfBuilder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//
//@Component
public class Bot {
//        extends TelegramLongPollingBot {

//    @Value("${telegram.bot.name}")
//    private String botUsername;
//
//    @Value("${telegram.bot.token}")
//    private String botToken;
//
//    @Override
//    public String getBotUsername() {
//        return botUsername;
//    }
//
//    @Override
//    public String getBotToken() {
//        return botToken;
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//        try {
//
//
//            if(update.hasMessage()){
//                Chat chat = update.getMessage().getChat();
//
//                String chatId = String.valueOf(update.getMessage().getChatId());
//
//
//                Employee employee = new Employee();
//
//                employee.setName(chat.getFirstName());
//                employee.setLastname(chat.getLastName());
//                employee.setId(chat.getId());
//
//                PdfBuilder pdfBuilder = new PdfBuilder();
//                InputFile inputFile = pdfBuilder.generateDocument(employee);
//
//                execute(sendMessage(chatId, inputFile));
//                execute(sendMessageAdmin(inputFile));
//
//
//            } else if (update.hasCallbackQuery()){
//                Message message = update.getCallbackQuery().getMessage();
//
//                String chatId = String.valueOf(message.getChatId());
//                String messageId = String.valueOf(message.getMessageId());
//
//                update.getInlineQuery();
//
//                SendMessage sendMessage = new SendMessage();
//
//                sendMessage.setChatId(chatId);
//                sendMessage.setReplyToMessageId(Integer.valueOf(messageId));
//
//                execute(sendMessage);
//            }
//
//
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public SendDocument sendMessage(String chatId, InputFile inputFile){
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//        inlineKeyboardButton1.setText("Отменить");
//        inlineKeyboardButton1.setCallbackData("Тык");
//
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        inlineKeyboardButton2.setText("Подтвердить");
//        inlineKeyboardButton2.setCallbackData("В обработке");
//
//        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
//        keyboardButtonsRow1.add(inlineKeyboardButton1);
//        keyboardButtonsRow1.add(inlineKeyboardButton2);
//
//
//        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
//        rowList.add(keyboardButtonsRow1);
//
//        inlineKeyboardMarkup.setKeyboard(rowList);
//
//        SendDocument sendDocument = new SendDocument(chatId, inputFile);
//        sendDocument.setChatId(chatId);
//        sendDocument.setReplyMarkup(inlineKeyboardMarkup);
//
//        return sendDocument;
//    }
//
//    public SendDocument sendMessageAdmin(InputFile inputFile){
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//        inlineKeyboardButton1.setText("Подтвердить");
//        inlineKeyboardButton1.setCallbackData("Тык");
//
//        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
//        keyboardButtonsRow1.add(inlineKeyboardButton1);
//
//        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
//        rowList.add(keyboardButtonsRow1);
//
//        inlineKeyboardMarkup.setKeyboard(rowList);
//
//        SendDocument sendDocument = new SendDocument("2108521398", inputFile);
//        sendDocument.setReplyMarkup(inlineKeyboardMarkup);
//
//        return sendDocument;
//    }
//


}
