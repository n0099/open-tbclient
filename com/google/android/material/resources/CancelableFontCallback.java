package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    public final ApplyFont applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    /* loaded from: classes6.dex */
    public interface ApplyFont {
        void apply(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = applyFont;
    }

    private void updateIfNotCancelled(Typeface typeface) {
        if (this.cancelled) {
            return;
        }
        this.applyFont.apply(typeface);
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i2) {
        updateIfNotCancelled(this.fallbackFont);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface typeface, boolean z) {
        updateIfNotCancelled(typeface);
    }
}
