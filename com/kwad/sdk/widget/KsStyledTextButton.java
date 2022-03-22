package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.utils.w;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class KsStyledTextButton extends TextView implements b {
    public KsStyledTextButton(Context context) {
        super(context);
    }

    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        w.a(cVar, getBackground());
    }
}
