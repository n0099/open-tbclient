package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes5.dex */
public final class a extends TextureView {
    public int a;
    public int b;

    public a(Context context) {
        super(context);
    }

    public final void a(int i, int i2) {
        if (this.b == i || this.a == i2) {
            return;
        }
        this.b = i;
        this.a = i2;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i2 = i;
            i = i2;
        }
        int defaultSize = TextureView.getDefaultSize(this.b, i);
        int defaultSize2 = TextureView.getDefaultSize(this.a, i2);
        if (this.b > 0 && this.a > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.b;
                int i5 = i4 * size2;
                int i6 = this.a;
                if (i5 < size * i6) {
                    defaultSize = (i4 * size2) / i6;
                } else if (i4 * size2 > size * i6) {
                    defaultSize2 = (i6 * size) / i4;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i7 = this.a;
                int i8 = this.b;
                int i9 = (size * i7) / i8;
                if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i9;
                } else {
                    defaultSize = (i8 * size2) / i7;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i10 = this.b;
                int i11 = this.a;
                i3 = (size2 * i10) / i11;
                if (mode != Integer.MIN_VALUE || i3 <= size) {
                    defaultSize2 = size2;
                    defaultSize = i3;
                } else {
                    defaultSize2 = (i11 * size) / i10;
                    defaultSize = size;
                }
            } else {
                i3 = this.b;
                int i12 = this.a;
                if (mode2 != Integer.MIN_VALUE || i12 <= size2) {
                    defaultSize2 = i12;
                } else {
                    i3 = (i3 * size2) / i12;
                    defaultSize2 = size2;
                }
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (this.a * size) / this.b;
                    defaultSize = size;
                }
                defaultSize = i3;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public final void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
