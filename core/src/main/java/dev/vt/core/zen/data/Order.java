package dev.vt.core.zen.data;

public record Order(
        String orderId,
        Customer customer,
        Address shippingAddress
) {

    public record Customer(
            String id,
            String name,
            Contact contact
    ) {
    }

    public record Contact(
            String email,
            String phone
    ) {
    }

    public record Address(
            String line1,
            String city,
            String zip
    ) {
    }
}
