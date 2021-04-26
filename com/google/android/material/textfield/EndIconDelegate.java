package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
/* loaded from: classes6.dex */
public abstract class EndIconDelegate {
    public Context context;
    public CheckableImageButton endIconView;
    public TextInputLayout textInputLayout;

    public EndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int i2) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean z) {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }
}
