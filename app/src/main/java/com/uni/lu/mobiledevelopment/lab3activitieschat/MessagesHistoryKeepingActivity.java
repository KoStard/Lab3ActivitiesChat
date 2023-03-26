package com.uni.lu.mobiledevelopment.lab3activitieschat;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class MessagesHistoryKeepingActivity extends AppCompatActivity {
    protected List<Message> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("messages", (Serializable) messages);
    }

    protected void addMessage(String sender, String message) {
        LinearLayout messagesContainer = findViewById(R.id.messagesContainer);
        // Use TextView to display the message
        TextView messageView = new TextView(this);
        messageView.setText(sender + ": " + message);
        messagesContainer.addView(messageView);
    }

    protected void saveMessage(String sender, String message) {
        messages.add(new Message(sender, message));
    }
}
