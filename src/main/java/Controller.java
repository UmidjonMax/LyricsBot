import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class Controller extends TelegramLongPollingBot {
    List<TelegramUser> users = new ArrayList<>();
    @Override
    public void onUpdateReceived(Update update) {
        try {
            Long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("tugmani bosing");

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboardRows = new ArrayList<>();
            KeyboardRow keyboardRow = new KeyboardRow();
            KeyboardRow row2 = new KeyboardRow();
            KeyboardButton keyboardButton = new KeyboardButton();
            KeyboardButton keyboardButton2 = new KeyboardButton();
            keyboardRow.add(keyboardButton);
            keyboardRow.add(keyboardButton2);
            row2.add(keyboardButton);
            keyboardButton.setText("O'zbek tili");
            keyboardButton2.setText("Rus tili");
            keyboardRows.add(keyboardRow);
            keyboardRows.add(row2);
            replyKeyboardMarkup.setKeyboard(keyboardRows);

            message.setReplyMarkup(replyKeyboardMarkup);

            InlineKeyboardButton menuButton = new InlineKeyboardButton();
            menuButton.setText("Menu");
            menuButton.setCallbackData("menu");

            InlineKeyboardButton button2 = new InlineKeyboardButton();
            button2.setText("hey");
            button2.setCallbackData("hey");

            InlineKeyboardButton button3 = new InlineKeyboardButton();
            button3.setText("wassup");
            button3.setCallbackData("sup");

            List<InlineKeyboardButton> row = new LinkedList<>();
            row.add(menuButton);
            row.add(button2);

            List<InlineKeyboardButton> secondRow = new LinkedList<>();
            secondRow.add(button3);


            List<List<InlineKeyboardButton>> rows = new LinkedList<>();
            rows.add(row);
            rows.add(secondRow);

            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            inlineKeyboardMarkup.setKeyboard(rows);
            message.setReplyMarkup(inlineKeyboardMarkup);

            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private TelegramUser findUser(Long chatId) {
        TelegramUser currentUser = null;

        for (TelegramUser user : users) {
            if(user.getChatId().equals(chatId)) {
                currentUser = user;
            }
        }
        if (currentUser == null) {
            currentUser = new TelegramUser();
            currentUser.setChatId(chatId);
            users.add(currentUser);
        }
        return currentUser;
    }


    @Override
    public String getBotUsername() {
        return "LyricsMus_bot";
    }

    @Override
    public String getBotToken() {
        return "7728647502:AAG9JD21K8nu-VCvOpM6lgfjgrSCuOe3FCE";
    }
}
