package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) { /* Erro de comissão e desempenho, pois a variável valor nunca muda, fazendo um looping infinito causando um grande problema de desempenho*/
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) { /* Erro de comissão e desempenho, pois a variável valor nunca muda, fazendo um looping infinito causando um grande problema de desempenho*/
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) { /* Erro de comissão e desempenho, pois a variável valor nunca muda, fazendo um looping infinito causando um grande problema de desempenho*/
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) { /* Erro de comissão e desempenho, pois a variável valor nunca muda, fazendo um looping infinito causando um grande problema de desempenho*/
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) { /* Erro de comissão e desempenho, pois a variável valor nunca muda, fazendo um looping infinito causando um grande problema de desempenho*/
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) { /* Erro de comissão e desempenho, pois a variável valor nunca muda, fazendo um looping infinito causando um grande problema de desempenho*/
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) { /*Erro de inicialização e de Dados, o array papeisMoeda, possui tamanho 6,o indice i utilizado começa com 6, ou seja, ele tentará acessar posições fora do array*/
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) { /*Erro de comissão e de controle, a variável ret será sempre null, logo a verificação de ret!= null, nunca ocorrerá, fazendo com que o desvio condicional seja utilizado de forma incorreta*/
                if (troco.papeisMoeda[i] != null) { 
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() { /*Erro de comissão, pois o método remove não está realizando nenhuma alteração, ou seja, não está executando uma lógica de remoção de fato*/
            next();
        }
    }
}
