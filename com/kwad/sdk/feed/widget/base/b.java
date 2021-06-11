package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public float f35588a;

    public b(@NonNull Context context) {
        this(context, null);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35588a = 0.0f;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f35588a != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            com.kwad.sdk.core.d.a.a("RatioFrameLayout", "widthSize:" + size);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f35588a), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setRatio(float f2) {
        this.f35588a = f2;
    }
}
