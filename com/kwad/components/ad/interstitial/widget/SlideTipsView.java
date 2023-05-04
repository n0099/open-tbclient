package com.kwad.components.ad.interstitial.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
/* loaded from: classes8.dex */
public class SlideTipsView extends FrameLayout {
    public SlideTipsView(@NonNull Context context) {
        this(context, null);
    }

    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    public SlideTipsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_SlideTipsView, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        FrameLayout.inflate(context, z ? com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0472 : com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0477, this);
    }
}
