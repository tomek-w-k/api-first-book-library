package com.app.apifirstbooklibrary;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;


public class ArchUnitApplicationTests {

    private JavaClasses importedClasses;


    @BeforeEach
    public void setup() {
        importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.app.apifirstbooklibrary");
    }

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        noClasses()
                .that().resideInAnyPackage("com.app.apifirstbooklibrary.repository..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("com.app.apifirstbooklibrary.controller..")
                .because("Services and repositories should not depend on web layer")
                .check(importedClasses);
    }
}
