package de.endrullis.idea.postfixtemplates.language;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;

public class CptLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
	@NotNull
	@Override
	public Language getLanguage() {
		return CptLanguage.INSTANCE;
	}

	@Override
	public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
		if (settingsType == SettingsType.SPACING_SETTINGS) {
			consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS");
			consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Separator");
			consumer.showStandardOptions("SPACE_AROUND_LAMBDA_ARROW");
			consumer.renameStandardOption("SPACE_AROUND_LAMBDA_ARROW", "Mapping arrow");
		} else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
			consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
		}
	}

	@Override
	public String getCodeSample(@NotNull SettingsType settingsType) {
		return CptUtil.getDefaultJavaTemplates();
	}

	@Override
	public IndentOptionsEditor getIndentOptionsEditor() {
		return new SmartIndentOptionsEditor();
	}
}