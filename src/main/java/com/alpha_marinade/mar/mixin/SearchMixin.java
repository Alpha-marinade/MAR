package com.alpha_marinade.mar.mixin;

import me.shedaniel.rei.impl.client.gui.widget.search.OverlaySearchField;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OverlaySearchField.class)
public class SearchMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true, remap = false)
    public void disableSearchRender(GuiGraphics graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "mouseClicked", at = @At("HEAD"), cancellable = true, remap = false)
    public void disableMouseClick(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true, remap = false)
    public void disableKeyPress(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "charTyped", at = @At("HEAD"), cancellable = true, remap = false)
    public void disableCharTyped(char chr, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

}
