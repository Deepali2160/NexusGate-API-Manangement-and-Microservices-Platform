package in.nexusgate.Api_Management_Service.repository;

import in.nexusgate.Api_Management_Service.entity.ManagementUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementUserRepository extends JpaRepository<ManagementUser,Long> {

    Optional<ManagementUser> findByUsername(String username);

    Optional<ManagementUser> findByOrganizationId(Long organizationId);

    boolean existsByUsername(String username);
}
