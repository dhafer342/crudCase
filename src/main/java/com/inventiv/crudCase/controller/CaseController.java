package com.inventiv.crudCase.controller;


import com.inventiv.crudCase.dto.CaseDto;
import com.inventiv.crudCase.dto.CaseToSaveDto;
import com.inventiv.crudCase.dto.CaseToUpdateDto;
import com.inventiv.crudCase.service.CaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Crud Cases")
@RestController
@RequestMapping("/cases")
public class CaseController {

    private final CaseService caseService;


    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @Operation(summary = "Find a case", description = "Find a case")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "case",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CaseDto.class))),
            @ApiResponse(responseCode = "404", description = "Case not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class)))
    })
    @GetMapping("/{title}")
    public Optional<CaseDto> getByTitle(@PathVariable String title) {
        return caseService.getByTitle(title);
    }

    @Operation(summary = "Update a case", description = "Update a case")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "case",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CaseDto.class))),
            @ApiResponse(responseCode = "404", description = "Case not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class)))
    })
    @PutMapping("/{title}")
    public CaseDto updateCase(@PathVariable String title, @RequestBody CaseToUpdateDto caseToUpdateDto) {
        return caseService.updateCase(title, caseToUpdateDto);
    }

    @Operation(summary = "Create Case", description = "Create Case")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Case",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CaseToSaveDto.class))),
            @ApiResponse(responseCode = "400", description = "Case exist",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class)))
    })
    @PostMapping
    public CaseDto createCase(@RequestBody CaseToSaveDto caseToSaveDto) {
        return caseService.createCase(caseToSaveDto);
    }

    @Operation(summary = "Delete Case", description = "Delete Case")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Case"),
            @ApiResponse(responseCode = "404", description = "Case exist",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class)))
    })
    @DeleteMapping("/{title}")
    public void deleteCase(@PathVariable String title) {
        caseService.deleteCase(title);
    }


}
