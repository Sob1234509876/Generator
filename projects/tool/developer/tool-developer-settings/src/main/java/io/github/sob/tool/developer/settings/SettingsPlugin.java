package io.github.sob.tool.developer.settings;

import io.github.sob.tool.developer.settings.action.IncludeAction;
import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;
import org.jetbrains.annotations.NotNull;

public class SettingsPlugin implements Plugin<Settings> {
    public static final String DEFAULT_PROJECTS_DIRECTORY = "projects";

    @Override
    public void apply(@NotNull Settings target) {
        target.getPluginManagement()
                .repositories(repo -> {
                    repo.gradlePluginPortal();
                    repo.mavenCentral();
                    repo.mavenLocal();
                });

        target.getGradle()
                .settingsEvaluated(new IncludeAction());
    }
}
