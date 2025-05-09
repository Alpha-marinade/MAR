package com.alpha_marinade.mar.mixin;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Button;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.impl.client.gui.ScreenOverlayImpl;
import me.shedaniel.rei.impl.client.gui.widget.ConfigButtonWidget;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ConfigButtonWidget.class)
public class SetupMixin {
    @Inject(method = "create", at = @At("HEAD"), cancellable = true, remap = false)
    private static void disableCreation(ScreenOverlayImpl overlay, CallbackInfoReturnable<Widget> cir) {
        cir.setReturnValue(Widgets.concat());
    }

}
