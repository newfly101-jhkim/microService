package com.jhkim.microservice.controller;

import com.jhkim.microservice.model.License;
import com.jhkim.microservice.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/organization/{organizationId}/license")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
                                              @PathVariable("licenseId") String licenseId) {
        License license = licenseService.getLisence(licenseId, organizationId);

        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId,
                                                @RequestBody License request) {

        return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId,
                                                @RequestBody License request) {

        return ResponseEntity.ok(licenseService.createLicense(request, organizationId));
    }

    @DeleteMapping("/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
                                                @PathVariable("licenseId") String licenseId) {

        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
    }
}
