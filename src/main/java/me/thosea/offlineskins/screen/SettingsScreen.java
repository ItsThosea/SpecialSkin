package me.thosea.offlineskins.screen;

import me.thosea.offlineskins.OfflineSkins;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.OptionListWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

import static me.thosea.offlineskins.SkinSettings.BUTTON_MAKE_SKIN_PACK;
import static me.thosea.offlineskins.SkinSettings.BUTTON_MODEL_PARTS;
import static me.thosea.offlineskins.SkinSettings.CAPE_MODE;
import static me.thosea.offlineskins.SkinSettings.ENABLED;
import static me.thosea.offlineskins.SkinSettings.GLOBAL_MODE;
import static me.thosea.offlineskins.SkinSettings.MODEL_TYPE;
import static me.thosea.offlineskins.SkinSettings.SKIN_MODE;
import static me.thosea.offlineskins.SkinSettings.TAB_MODE;

public final class SettingsScreen extends GameOptionsScreen {
	public SettingsScreen(Screen parent) {
		super(parent, null, Text.translatable("offlineskins.settings"));
	}

	@Override
	protected void init() {
		if(OfflineSkins.ERROR != null) {
			client.setScreen(parent);
			return;
		}

		OptionListWidget list = new OptionListWidget(this.client, this.width, this.height - 64, 32, 25);

		list.addOptionEntry(ENABLED, GLOBAL_MODE);
		list.addOptionEntry(MODEL_TYPE, SKIN_MODE);
		list.addOptionEntry(BUTTON_MODEL_PARTS, CAPE_MODE);
		list.addOptionEntry(BUTTON_MAKE_SKIN_PACK, TAB_MODE);

		this.addDrawableChild(list);
		this.addSelectableChild(list);
		this.addDrawableChild(ButtonWidget.builder(ScreenTexts.DONE, (button) -> {
			this.close();
		}).dimensions(this.width / 2 - 100, this.height - 27, 200, 20).build());
	}

	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float delta) {
		super.render(context, mouseX, mouseY, delta);
		context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 16777215);
	}
	
	@Override
	public void removed() {}
}
