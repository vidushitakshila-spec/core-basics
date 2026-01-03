package dev.vt.core.zen.data;

public record Producer(String producerId, String firstName, String lastName, String agencyName,
                       String email, String phone, String licenseNumber, String status, String effectiveDate,
                       String region, String subApproval) {
}
