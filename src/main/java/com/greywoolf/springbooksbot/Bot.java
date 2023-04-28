package com.greywoolf.springbooksbot;

import com.greywoolf.springbooksbot.commands.LoginCommand;
import com.greywoolf.springbooksbot.commands.WorKerCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "Spring_Eugenia_Bot";
    }

    @Override
    public String getBotToken() {
        return "5978650260:AAGhppp5MTlwX3rb1Ozugf0ocHN74R7YH-Y";
    }

    @Override
    public void onUpdateReceived(Update update) {
        KeyboardRow k = new KeyboardRow();

        k.add(new KeyboardButton("Записаться к врачу"));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Выберите действие");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Collections.singletonList(k));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<WorKerCommand> list = new ArrayList<>();
        list.add(new LoginCommand());
        for (WorKerCommand w: list){
            if (w.start(update)!=null){
                sendMessage = w.start(update);
                break;
            }
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
