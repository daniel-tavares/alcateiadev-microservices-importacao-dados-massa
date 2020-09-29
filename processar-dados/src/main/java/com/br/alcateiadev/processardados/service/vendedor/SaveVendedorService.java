package com.br.alcateiadev.processardados.service.vendedor;

import com.br.alcateiadev.processardados.domain.Vendedor;
import com.br.alcateiadev.processardados.gateway.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaveVendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Transactional
    public void execute(Vendedor vendedor) {
        Vendedor vendedorDb = vendedorRepository.getByCpf(vendedor.getCpf());

        if (vendedorDb == null) {
            vendedorRepository.save(vendedor);
        } else {
            vendedorDb.setNome(vendedor.getNome());
            vendedorDb.setCpf(vendedor.getCpf());
            vendedorDb.setMeta(vendedor.getMeta());
            vendedorRepository.save(vendedorDb);
        }
    }
}
