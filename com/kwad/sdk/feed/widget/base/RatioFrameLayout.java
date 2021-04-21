package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class RatioFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public float f35296a;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f35296a = 0.0f;
    }

    public float getRatio() {
        return this.f35296a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f35296a != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            com.kwad.sdk.core.d.a.a("RatioFrameLayout", "widthSize:" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f35296a), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(float f2) {
        this.f35296a = f2;
    }
}
