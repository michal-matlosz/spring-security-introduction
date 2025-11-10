package pl.umk.workshop.springintroduction.controller.models;

import java.util.List;

public record DepositWithIdDto(Integer depositId, StudentDto student, List<String> items) {

}
