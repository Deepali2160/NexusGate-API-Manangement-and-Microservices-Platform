package in.nexusgate.Api_Management_Service.repository;


import in.nexusgate.Api_Management_Service.dto.requestDto.OrganizationRequest;
import in.nexusgate.Api_Management_Service.entity.Organization;
import in.nexusgate.Api_Management_Service.entity.OrganizationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    boolean existsByNameIgnoreCase(String name);

    boolean existsBySlugIgnoreCase(String slug);

    List<Organization> findAllByStatusNot(OrganizationStatus status);

    Optional<Organization> findByIdAndStatusNot(Long id, OrganizationStatus status);
}
