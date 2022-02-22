package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes4.dex */
public class a extends TextureView {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f56423b;

    public a(Context context) {
        super(context);
    }

    public void a(int i2, int i3) {
        if (this.f56423b == i2 || this.a == i3) {
            return;
        }
        this.f56423b = i2;
        this.a = i3;
        requestLayout();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i3 = i2;
            i2 = i3;
        }
        int defaultSize = TextureView.getDefaultSize(this.f56423b, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.a, i3);
        if (this.f56423b > 0 && this.a > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.f56423b;
                int i6 = i5 * size2;
                int i7 = this.a;
                if (i6 < size * i7) {
                    defaultSize = (i5 * size2) / i7;
                } else if (i5 * size2 > size * i7) {
                    defaultSize2 = (i7 * size) / i5;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i8 = this.a;
                int i9 = this.f56423b;
                int i10 = (size * i8) / i9;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i10;
                } else {
                    defaultSize = (i9 * size2) / i8;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i11 = this.f56423b;
                int i12 = this.a;
                i4 = (size2 * i11) / i12;
                if (mode != Integer.MIN_VALUE || i4 <= size) {
                    defaultSize2 = size2;
                    defaultSize = i4;
                } else {
                    defaultSize2 = (i12 * size) / i11;
                    defaultSize = size;
                }
            } else {
                i4 = this.f56423b;
                int i13 = this.a;
                if (mode2 != Integer.MIN_VALUE || i13 <= size2) {
                    defaultSize2 = i13;
                } else {
                    i4 = (i4 * size2) / i13;
                    defaultSize2 = size2;
                }
                if (mode == Integer.MIN_VALUE && i4 > size) {
                    defaultSize2 = (this.a * size) / this.f56423b;
                    defaultSize = size;
                }
                defaultSize = i4;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        if (f2 != getRotation()) {
            super.setRotation(f2);
            requestLayout();
        }
    }
}
