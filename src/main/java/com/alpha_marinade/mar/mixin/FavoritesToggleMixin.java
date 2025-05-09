package com.alpha_marinade.mar.mixin;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.impl.client.gui.widget.favorites.panel.FavoritesTogglePanelButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FavoritesTogglePanelButton.class )
public class FavoritesToggleMixin {
    @Inject(method = "renderButtonText", at = @At("HEAD"), cancellable = true, remap = false)
    private void cancelPlus(GuiGraphics graphics, MultiBufferSource.BufferSource bufferSource, CallbackInfo ci){
        ci.cancel();
    }
    @Inject(method = "onClick", at = @At("HEAD"), cancellable = true, remap = false)
    private void cancelClick(CallbackInfo ci){
        ci.cancel();
    }
    @Inject(method = "queueTooltip", at = @At("HEAD"), cancellable = true, remap = false)
    private void cancelTooltip(CallbackInfo ci){
        ci.cancel();
    }
    @Inject(method = "updateArea", at = @At("HEAD"), cancellable = true, remap = false)
    private void cancelArea(Rectangle fullArea, CallbackInfoReturnable<Rectangle> cir){
        cir.setReturnValue(new Rectangle(0,0));
    }
    @Inject(method = "isAvailable", at = @At("HEAD"), cancellable = true, remap = false)
    private void cancelAvaible(int mouseX, int mouseY, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
    }
}
