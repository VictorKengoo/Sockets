package Navegacao;

public enum EnumEstadoConsole {

    BEM_VINDO(new EstadoConsoleBemvindo()),

    IMPRIMINDO(new Imprimindo());

    private final MaquinaEstadoConsole estadoMaquina;

    EnumEstadoConsole(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

    public MaquinaEstadoConsole getEstadoMaquina() {
        return estadoMaquina;
    }
}
