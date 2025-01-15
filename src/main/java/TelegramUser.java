public class TelegramUser {
    private Long chatId;
    private String state = "START";
    private User user;

    public TelegramUser() {
    }

    public TelegramUser(Long chatId, String state, User user) {
        this.chatId = chatId;
        this.state = state;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TelegramUser{" +
                "chatId=" + chatId +
                ", state='" + state + '\'' +
                ", user=" + user +
                '}';
    }
}
