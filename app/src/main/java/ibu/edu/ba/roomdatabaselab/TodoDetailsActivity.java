package ibu.edu.ba.roomdatabaselab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TodoDetailsActivity extends AppCompatActivity {
    private EditText titleInput, descriptionInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);
        titleInput = findViewById(R.id.title_input);
        descriptionInput = findViewById(R.id.description_input);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            long id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            Todo todo = AppDatabase.getInstance(this).todoDao().getTodoById(id);
            titleInput.setText(todo.getTitle());
            descriptionInput.setText(todo.getDescription());
            button.setText("Update");
            button2.setText("Delete");
        }
    }

    public void onSave(View view){
        Todo todo = new Todo(titleInput.getText().toString(),descriptionInput.getText().toString());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            titleInput = findViewById(R.id.title_input);
            descriptionInput = findViewById(R.id.description_input);
            AppDatabase.getInstance(this).todoDao().updateTodoById(titleInput.getText().toString(),
                                                                    descriptionInput.getText().toString(),
                                                                    id);
        } else {
            AppDatabase.getInstance(this).todoDao().add(todo);
        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void onCancel(View view){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            Todo todo = AppDatabase.getInstance(this).todoDao().getTodoById(id);
            AppDatabase.getInstance(this).todoDao().delete(todo);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
