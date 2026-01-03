package dev.vt.core.zen.data;

public final class ProducerFactory {

    private ProducerFactory() {
    }

    public static Producer of(
            String producerId,
            String firstName,
            String lastName,
            String agencyName,
            String email,
            String phone,
            String licenseNumber,
            String status,
            String effectiveDate,
            String region,
            String subApproval
                             ) {

        return new Producer(
                producerId,
                firstName,
                lastName,
                agencyName,
                email,
                phone,
                licenseNumber,
                status,
                effectiveDate,
                region,
                subApproval);
    }
}
