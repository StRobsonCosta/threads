package br.com.alura.adopetstore.email;

import br.com.alura.adopetstore.dto.RelatorioEstoque;
import br.com.alura.adopetstore.dto.RelatorioFaturamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailRelatorioGerado {

    @Autowired
    private EnviadorEmail enviador;

    public void enviar(RelatorioEstoque estoque, RelatorioFaturamento faturamento) {
        this.enviador.enviarEmail(
                "Relatórios gerados",
                "admin@email.com",
                """
                        Olá!
                        
                        Seus relatórios foram gerados com sucesso e seguem abaixo:
                        
                        %s
                        
                        %S
                        """.formatted(estoque, faturamento)
        );
    }
}
