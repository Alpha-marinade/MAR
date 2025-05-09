package com.alpha_marinade.mar.mixin;


import dev.architectury.utils.value.IntValue;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Button;
import me.shedaniel.rei.api.client.gui.widgets.DelegateWidget;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.impl.client.gui.ScreenOverlayImpl;
import me.shedaniel.rei.impl.client.gui.widget.TabContainerWidget;
import me.shedaniel.rei.impl.client.gui.widget.entrylist.EntryListStackEntry;
import me.shedaniel.rei.impl.client.gui.widget.entrylist.PaginatedEntryListWidget;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collections;
import java.util.List;

@Mixin(PaginatedEntryListWidget.class)
public abstract class TabConteinerMixin {
    @Shadow private List<Widget> additionalWidgets;
    @Shadow private Button leftButton;
    @Shadow private Button rightButton;
    @Shadow private List<Object> stacks;
    @Shadow private List<EntryListStackEntry> entries;


    @Inject(method = "init", at = @At("HEAD"), cancellable = true, remap = false)
    private void disableInit(ScreenOverlayImpl overlay, CallbackInfo ci) {
        this.additionalWidgets = Collections.emptyList();
        this.leftButton = null;
        this.rightButton = null;
        ci.cancel();
    }


    @Inject(method = "setStacks", at = @At("HEAD"), cancellable = true, remap = false)
    private void disableStacks(List<Object> stacks, CallbackInfo ci) {
        this.stacks = Collections.emptyList();
        this.entries = Collections.emptyList();
        ci.cancel();
    }


    @Inject(method = "updateEntries", at = @At("HEAD"), cancellable = true, remap = false)
    private void disableUpdateEntries(int entrySize, boolean zoomed, CallbackInfo ci) {
        this.entries = Collections.emptyList();
        ci.cancel();
    }

    @Inject(method = "renderEntries", at = @At("HEAD"), cancellable = true, remap = false)
    private void disableRender(boolean fastEntryRendering, GuiGraphics graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();
    }


    @Inject(method = "mouseScrolled", at = @At("HEAD"), cancellable = true)
    private void disableScroll(double mouseX, double mouseY, double amount, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}


