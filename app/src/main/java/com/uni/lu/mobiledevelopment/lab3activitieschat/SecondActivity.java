package com.uni.lu.mobiledevelopment.lab3activitieschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Get the message from the intent
        String message = getIntent().getStringExtra("message");
        addMessage("Sender", message);
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

    private void addMessage(String sender, String message) {
        LinearLayout messagesContainer = findViewById(R.id.messagesContainer);
        // Use TextView to display the message
        TextView messageView = new TextView(this);
        messageView.setText(sender + ": " + message);
        messagesContainer.addView(messageView);
    }
}