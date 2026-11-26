package in.nexusgate.Api_Management_Service.controller;

import in.nexusgate.Api_Management_Service.dto.requestDto.OrganizationRequest;
import in.nexusgate.Api_Management_Service.dto.requestDto.OrganizationStatusRequest;
import in.nexusgate.Api_Management_Service.dto.requestDto.TenantAdminRequest;
import in.nexusgate.Api_Management_Service.dto.responseDto.OrganizationResponse;
import in.nexusgate.Api_Management_Service.dto.responseDto.TenantAdminResponse;
import in.nexusgate.Api_Management_Service.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platform/organizations")
public class PlatformOrganizationController {

    private final OrganizationService organizationService;

    public PlatformOrganizationController(OrganizationService organizationService)
    {
        this.organizationService = organizationService;
    }


    //CRUD OPERATIONS ON ORGANISATION AND TENANT ADMIN


    //CREATE

    @PostMapping
    public ResponseEntity<OrganizationResponse> create(
            @Valid @RequestBody OrganizationRequest request
    )
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(organizationService.create(request));
    }

    //REAL ALL

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> findAll()
    {
        return ResponseEntity.ok(organizationService.findAll());
    }


    //READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(organizationService.findById(id));
    }


    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(@PathVariable Long id, @Valid @RequestBody OrganizationRequest organizationRequest)
    {
        return  ResponseEntity.ok(organizationService.update(id,organizationRequest));
    }

    //PATCH
    @PatchMapping("{id}/status")
    public ResponseEntity<OrganizationResponse> changeStatus(@PathVariable Long id,@Valid @RequestBody OrganizationStatusRequest request)
    {
        return ResponseEntity.ok(organizationService.changeStatus(id,request));
    }

    //DELETE (SOFT DELETE)

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }


    //CRUD OPERATIONS --> TENANT ADMINS

    //CREATE
    @PostMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<TenantAdminResponse> createTenantAdmin(@PathVariable Long organizationId,
                                                                 @Valid @RequestBody TenantAdminRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationService.createTenantAdmin(organizationId, request));
    }

    @GetMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<TenantAdminResponse> getTenantAdmin(@PathVariable Long organizationId) {
        return ResponseEntity.ok(organizationService.getTenantAdmin(organizationId));
    }

    @PutMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<TenantAdminResponse> updateTenantAdmin(@PathVariable Long organizationId,
                                                                 @Valid @RequestBody TenantAdminRequest request) {
        return ResponseEntity.ok(organizationService.updateTenantAdmin(organizationId, request));
    }

    @DeleteMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<Void> deleteTenantAdmin(@PathVariable Long organizationId) {
        organizationService.deleteTenantAdmin(organizationId);
        return ResponseEntity.noContent().build();
    }

}
