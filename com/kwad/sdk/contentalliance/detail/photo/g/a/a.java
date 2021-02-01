package com.kwad.sdk.contentalliance.detail.photo.g.a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class a extends FrameLayout {
    public a(@NonNull Context context) {
        super(context);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void setAlignment(int i);

    public abstract void setAuthorId(long j);
}
