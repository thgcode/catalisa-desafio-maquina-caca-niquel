package br.com.zup;

import java.util.Arrays;

public class TerceiroNivel extends Nivel {
    public TerceiroNivel() {
        super(Arrays.asList(Opcao.values()), Opcao.values().length);
    }
}
