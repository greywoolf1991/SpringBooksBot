package com.greywoolf.springbooksbot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface WorKerCommand {
    SendMessage start(Update update);
    SendMessage sendDefaultMessage(Update update);
}
