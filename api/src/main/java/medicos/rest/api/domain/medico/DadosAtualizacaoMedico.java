package medicos.rest.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import medicos.rest.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {


}
