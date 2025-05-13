package br.com.jujulioed.locatech.locatech.dtos;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {


}
