package es.upm.boton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonNext, buttonPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNext = findViewById(R.id.button_next);
        buttonPrevious = findViewById(R.id.button_previous);

        buttonNext.setOnClickListener(this);
        buttonPrevious.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.button_next) {
            Toast.makeText(this, "Siguiente", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.button_previous) {
            Toast.makeText(this, "Anterior", Toast.LENGTH_SHORT).show();
        }

    }
}