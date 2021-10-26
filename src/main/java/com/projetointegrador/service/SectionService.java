package com.projetointegrador.service;

import com.projetointegrador.dto.SectionDto;
import com.projetointegrador.entity.*;
import com.projetointegrador.repository.SectionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionPersistence sectionPersistence;

    @Autowired
    private RepresentativeService representativeService;

    @Autowired
    private WarehouseService warehouseService;

    public SectionService() {

    }

    /**
     * @param sectionPersistence - é esperado um parâmetro do tipo sectionPersistence para injeção de dependência
     * @author - Grupo 5 - Tester Wesley
     */
    public SectionService(SectionPersistence sectionPersistence) {
        this.sectionPersistence = sectionPersistence;
    }

    /**
     * @param sectionDto - é esperado um objeto do tipo sectionDto
     * @return - retorna section cadastrado na lista
     * @author - Grupo 5 - Tester Wesley
     */
    public Section insert(SectionDto sectionDto) {
        Section section = convert(sectionDto);

        if (section.getRepresentative() != null && section.getWarehouse() != null) {
            return sectionPersistence.save(section);
        }

        throw new RuntimeException("Representante ou armazém não existe!");

    }

    /**
     * @param code - é esperado o parametro code da section
     * @return - retorna a section através do Id
     * @author - Grupo 5 - Tester Wesley
     */
    public Section getSectionByCode(String code) {
        Optional<Section> val;

        val = sectionPersistence.findBySectionCode(code);

        if (val.isPresent()) {
            return val.get();
        } else {
            throw new RuntimeException("Não existe um setor com esse código!");
        }
    }

    /**
     * @param code - é esperado o parametro code da section
     * @return - retorna a verificação tru ou false sobre a validade da section
     * @author - Grupo 5 - Tester Wesley
     */
    public boolean verifyValidSection(String code) {
        Optional<Section> verifyValidSection = sectionPersistence.findBySectionCode(code);
        if (verifyValidSection.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @param sectionDto - é esperado um objeto do tipo sectionDto
     * @return - retorna a section com os dados de representative e warehouse
     * @author - Grupo 5 - Tester Wesley
     */
    public Section convert(SectionDto sectionDto) {
        Section section = new Section();
        section.setSectionCode(sectionDto.getSectionCode());
        section.setSectionType(sectionDto.getSectionType());
        section.setTotalCapacity(sectionDto.getTotalCapacity());
        section.setUsedSpace(sectionDto.getUsedSpace());

        Representative r = representativeService.getByIdRepresentative(sectionDto.getRepresentativeId());
        Warehouse w = warehouseService.getByCode(sectionDto.getWarehouseCode());

        section.setRepresentative(r);
        section.setWarehouse(w);

        return section;
    }

    public Section verifyAvailableSpace(Section section, ProductSeller productSeller) {
        if (section.getUsedSpace() < section.getTotalCapacity()) {
            Double availableSpace = section.getTotalCapacity() - section.getUsedSpace();
            if (availableSpace >= productSeller.getVolume()) {
                return sectionPersistence.save(section);
            } else {
                throw new RuntimeException("O volume não cabe nesse setor");
            }
        } else {
            throw new RuntimeException("Setor sem espaço disponível");
        }
    }

//    public

    // falta fazer
}