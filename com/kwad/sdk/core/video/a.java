package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes6.dex */
public class a extends TextureView {

    /* renamed from: a  reason: collision with root package name */
    public int f34377a;

    /* renamed from: b  reason: collision with root package name */
    public int f34378b;

    public a(Context context) {
        super(context);
    }

    public void a(int i, int i2) {
        if (this.f34378b == i || this.f34377a == i2) {
            return;
        }
        this.f34378b = i;
        this.f34377a = i2;
        requestLayout();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i2 = i;
            i = i2;
        }
        int defaultSize = TextureView.getDefaultSize(this.f34378b, i);
        int defaultSize2 = TextureView.getDefaultSize(this.f34377a, i2);
        if (this.f34378b > 0 && this.f34377a > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.f34378b;
                int i5 = i4 * size2;
                int i6 = this.f34377a;
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
                int i7 = this.f34377a;
                int i8 = this.f34378b;
                int i9 = (size * i7) / i8;
                if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i9;
                } else {
                    defaultSize = (i8 * size2) / i7;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i10 = this.f34378b;
                int i11 = this.f34377a;
                i3 = (size2 * i10) / i11;
                if (mode != Integer.MIN_VALUE || i3 <= size) {
                    defaultSize2 = size2;
                    defaultSize = i3;
                } else {
                    defaultSize2 = (i11 * size) / i10;
                    defaultSize = size;
                }
            } else {
                i3 = this.f34378b;
                int i12 = this.f34377a;
                if (mode2 != Integer.MIN_VALUE || i12 <= size2) {
                    defaultSize2 = i12;
                } else {
                    i3 = (i3 * size2) / i12;
                    defaultSize2 = size2;
                }
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (this.f34377a * size) / this.f34378b;
                    defaultSize = size;
                }
                defaultSize = i3;
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
