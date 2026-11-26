package in.nexusgate.Api_Management_Service.dto.requestDto;

import in.nexusgate.Api_Management_Service.entity.OrganizationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationStatusRequest {

    @NotNull
    private OrganizationStatus status;
}
