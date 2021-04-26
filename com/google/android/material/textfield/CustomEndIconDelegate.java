package com.google.android.material.textfield;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class CustomEndIconDelegate extends EndIconDelegate {
    public CustomEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
