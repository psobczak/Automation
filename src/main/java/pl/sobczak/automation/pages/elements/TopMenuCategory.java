package pl.sobczak.automation.pages.elements;

import java.util.List;

public enum TopMenuCategory {

    WHY_SPRING("Why Spring", List.of("Overview", "Microservices")),
    LEARN("Learn", List.of("Overview")),
    PROJECTS("Projects", List.of("Spring Boot")),
    TRAINING("Training", List.of()),
    SUPPORT("Support", List.of()),
    COMMUNITY("Community", List.of("Events"));

    private final String name;
    private final List<String> subCategories;

    TopMenuCategory(String name, List<String> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubCategories() {
        return subCategories;
    }
}
