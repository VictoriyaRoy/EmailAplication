package com.example.user.emailaplication;

class EmailItem {
    private String autor;
    private String subject;
    private String content;
    private String date;

    public EmailItem(String autor, String subject, String content, String date) {
        this.autor = autor;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    public String getAutor() {
        return autor;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}