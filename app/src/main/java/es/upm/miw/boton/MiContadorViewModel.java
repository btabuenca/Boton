package es.upm.miw.boton;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MiContadorViewModel extends ViewModel {

    private MutableLiveData<Integer> contador;

    public MutableLiveData<Integer> getContador() {
        if (contador == null) {
            contador = new MutableLiveData<>();
            contador.setValue(0);
        }

        return contador;
    }

    public void setContador(int contador) {
        this.contador.setValue(contador);
    }
}
