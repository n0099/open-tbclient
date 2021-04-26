package com.qq.e.ads.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public final class MediaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f36079a;

    /* renamed from: b  reason: collision with root package name */
    public int f36080b;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onAttachedToWindow() {
        GDTLogger.d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT < 11 || isHardwareAccelerated()) {
            return;
        }
        GDTLogger.e("Hardware acceleration is off");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        if ((SDKStatus.getSDKVersionCode() == 11 || SDKStatus.getSDKVersionCode() == 12) && this.f36079a > 0 && this.f36080b > 0) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            int i4 = this.f36080b;
            int i5 = size * i4;
            int i6 = this.f36079a;
            if (i5 < i6 * size2 || size2 == 0) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec((size * this.f36080b) / this.f36079a, 1073741824);
                i2 = makeMeasureSpec;
            } else {
                if (i4 * size > i6 * size2 || size == 0) {
                    size = (this.f36079a * size2) / this.f36080b;
                }
                i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }

    public final void setRatio(int i2, int i3) {
        this.f36079a = i2;
        this.f36080b = i3;
    }
}
