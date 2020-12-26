package tn.isi.soa.blog;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tn.isi.soa.blog");

        noClasses()
            .that()
                .resideInAnyPackage("tn.isi.soa.blog.service..")
            .or()
                .resideInAnyPackage("tn.isi.soa.blog.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..tn.isi.soa.blog.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
