package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class EntryScrollGifView extends EntryScrollView {
    public EntryScrollGifView(@NonNull Context context) {
        super(context);
    }

    public EntryScrollGifView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.entry.view.EntryScrollView
    protected float a(int i, int i2) {
        return 0.65f;
    }

    @Override // com.kwad.sdk.entry.view.EntryScrollView
    protected int getAdShowStyle() {
        return 2;
    }

    @Override // com.kwad.sdk.entry.view.EntryScrollView
    protected boolean getEnableWebp() {
        return true;
    }

    @Override // com.kwad.sdk.entry.view.EntryScrollView
    protected int getItemPlayRes() {
        return R.drawable.ksad_entrybig_play_selector;
    }

    @Override // com.kwad.sdk.entry.view.EntryScrollView
    protected float getRatio() {
        return 1.0f;
    }
}
