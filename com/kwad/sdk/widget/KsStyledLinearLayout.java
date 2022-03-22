package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.utils.w;
/* loaded from: classes7.dex */
public class KsStyledLinearLayout extends LinearLayout implements b {
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

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        w.a(cVar, getBackground());
    }
}
