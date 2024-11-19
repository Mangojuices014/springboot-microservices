package net.javaguides.organizationservice.service.Imp;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.exception.ResourceNotFoundException;
import net.javaguides.organizationservice.reponsitory.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationImp implements OrganizationService {

    private OrganizationRepository organizationRepository;

    private ModelMapper mapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = mapper.map(organizationDto, Organization.class);
        Organization saveOrganization = organizationRepository.save(organization);
        return mapper.map(saveOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        try {
            Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
            return mapper.map(organization, OrganizationDto.class);
        }catch (Exception exception){
            throw new ResourceNotFoundException("Code", "organization", organizationCode);
        }

    }
}
