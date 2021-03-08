package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
/* loaded from: classes3.dex */
public class a extends TextureView {

    /* renamed from: a  reason: collision with root package name */
    private int f6259a;
    private int b;

    public a(Context context) {
        super(context);
    }

    public void a(int i, int i2) {
        if (this.b == i || this.f6259a == i2) {
            return;
        }
        this.b = i;
        this.f6259a = i2;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i3 = i;
            i4 = i2;
        } else {
            i3 = i2;
            i4 = i;
        }
        int defaultSize = getDefaultSize(this.b, i4);
        int defaultSize2 = getDefaultSize(this.f6259a, i3);
        if (this.b <= 0 || this.f6259a <= 0) {
            i5 = defaultSize2;
        } else {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i3);
            i5 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.b * i5 < this.f6259a * size) {
                    defaultSize = (this.b * i5) / this.f6259a;
                } else if (this.b * i5 > this.f6259a * size) {
                    i5 = (this.f6259a * size) / this.b;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i7 = (this.f6259a * size) / this.b;
                if (mode2 != Integer.MIN_VALUE || i7 <= i5) {
                    i5 = i7;
                    defaultSize = size;
                } else {
                    defaultSize = (this.b * i5) / this.f6259a;
                }
            } else if (mode2 == 1073741824) {
                i6 = (this.b * i5) / this.f6259a;
                if (mode == Integer.MIN_VALUE && i6 > size) {
                    i5 = (this.f6259a * size) / this.b;
                    defaultSize = size;
                }
                defaultSize = i6;
            } else {
                i6 = this.b;
                int i8 = this.f6259a;
                if (mode2 != Integer.MIN_VALUE || i8 <= i5) {
                    i5 = i8;
                } else {
                    i6 = (this.b * i5) / this.f6259a;
                }
                if (mode == Integer.MIN_VALUE && i6 > size) {
                    i5 = (this.f6259a * size) / this.b;
                    defaultSize = size;
                }
                defaultSize = i6;
            }
        }
        setMeasuredDimension(defaultSize, i5);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
