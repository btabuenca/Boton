package es.upm.miw.boton;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button boton;
    private TextView tvContador;

    MiContadorViewModel miContadorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.boton_layout);

        boton = findViewById(R.id.btPulsador);
        tvContador = findViewById(R.id.tvContador);

        // Obtener ViewModel
        miContadorViewModel = ViewModelProviders.of(this).get(MiContadorViewModel.class);

        // Crear el Observer que actualizará la UI
        final Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer numero) {
                // A este método se llamará cuando cambié el valor el entero observable
                // En ese momento, actualiza el textView con eon nuevo valor del singleton
                tvContador.setText(
                        String.format(Locale.getDefault(), "%d", numero)
                );
            }
        };

        // Asocia el observador del tvContador
        miContadorViewModel.getContador().observe(this, integerObserver);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor = 1 + miContadorViewModel.getContador().getValue();
                miContadorViewModel.setContador(valor);
                // tvContador.setText(String.format(Locale.getDefault(), "%d", valor));
                Log.i("MiW", "tvContador = " + valor);
            }
        });
    }
}
