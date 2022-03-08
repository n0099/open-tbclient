package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.utils.w;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes8.dex */
public class KsStyledImageView extends ImageView implements b {
    public KsStyledImageView(Context context) {
        super(context);
    }

    public KsStyledImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsStyledImageView(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        w.a(cVar, getBackground());
    }
}
