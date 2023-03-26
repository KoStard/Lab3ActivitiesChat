package com.uni.lu.mobiledevelopment.lab3activitieschat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends MessagesHistoryKeepingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Print savedInstanceState
        System.out.println("savedInstanceState: " + savedInstanceState);
        if (savedInstanceState != null) {
            messages = (List<Message>) savedInstanceState.getSerializable("messages");
            for (Message message : messages) {
                addMessage(message.getSender(), message.getMessage());
            }
        }
        String message = getIntent().getStringExtra("message");
        if (message != null) {
            addMessage("Sender", message);
            saveMessage("Sender", message);
            getIntent().removeExtra("message");
        }
    }

    public void replyMessage(View view) {
        // Finish by replying with the message from the EditText
        TextView replyEditor = findViewById(R.id.replyEditor);
        String reply = replyEditor.getText().toString();
        addMessage("Me", reply);
        Intent intent = new Intent();
        intent.putExtra("reply", reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}