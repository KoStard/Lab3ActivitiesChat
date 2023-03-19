package com.uni.lu.mobiledevelopment.lab3activitieschat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText messageEditor = findViewById(R.id.messageEditor);
        String message = messageEditor.getText().toString();
        messageEditor.setText("");
        addMessage("Me", message);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", message);
        startActivityForResult(intent, 1);
    }

    // On reply from the activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Print all the data
        System.out.println("requestCode: " + requestCode);
        System.out.println("resultCode: " + resultCode);
        System.out.println("data: " + data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra("reply");
                addMessage("Reply", reply);
            }
        }
    }

    // Add a message to the layout
    private void addMessage(String sender, String message) {
        LinearLayout messagesContainer = findViewById(R.id.messagesContainer);
        // Use TextView to display the message
        TextView messageView = new TextView(this);
        messageView.setText(sender + ": " + message);
        messagesContainer.addView(messageView);
    }
}