package dev.vt.core.zen;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vt.core.zen.data.Employee;
import dev.vt.core.zen.data.EmployeeFactory;
import dev.vt.core.zen.data.Producer;
import dev.vt.core.zen.data.ProducerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class TestData {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Employee> getEmployees() {

        try {
            return objectMapper
                    .readValue(
                            new InputStreamReader(
                                    Objects.requireNonNull(TestData.class.getResourceAsStream("/json/employee.json")),
                                    //  getClass().getResourceAsStream("/json/employee.json"),
                                    StandardCharsets.UTF_8),
                            new TypeReference<List<Employee>>() {
                            })
                    .stream()
                    .map(e -> EmployeeFactory.of(e.id(), e.name(), e.dept(), e.salary(), e.experience()))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> getProducers() {

        try {
            List<Producer> producers =
                    objectMapper
                            .readValue(
                                    new InputStreamReader(TestData.class.getResourceAsStream("/json/producer.json")),
                                    new TypeReference<List<Producer>>() {
                                    })
                            .stream()
                            .map(
                                    p ->
                                            ProducerFactory.of(
                                                    p.producerId(),
                                                    p.firstName(),
                                                    p.lastName(),
                                                    p.agencyName(),
                                                    p.email(),
                                                    p.phone(),
                                                    p.licenseNumber(),
                                                    p.status(),
                                                    p.effectiveDate(),
                                                    p.region(),
                                                    p.subApproval()))
                            .toList();

            return producers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
