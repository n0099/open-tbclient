package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.m.j;
/* loaded from: classes10.dex */
public class KsStyledLinearLayout extends LinearLayout implements e {
    public KsStyledLinearLayout(Context context) {
        super(context);
    }

    public KsStyledLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsStyledLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        j.a(fVar, getBackground());
    }
}
