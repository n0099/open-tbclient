package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import com.kwad.sdk.R;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float[] f11156a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    private float f11157b;
    private Path c;
    private Paint d;
    private RectF e;
    private boolean f;

    private float[] a() {
        this.f11156a[0] = this.f11157b;
        this.f11156a[1] = this.f11157b;
        this.f11156a[2] = this.f11157b;
        this.f11156a[3] = this.f11157b;
        this.f11156a[4] = this.f11157b;
        this.f11156a[5] = this.f11157b;
        this.f11156a[6] = this.f11157b;
        this.f11156a[7] = this.f11157b;
        return this.f11156a;
    }

    private Path b() {
        this.c.reset();
        this.c.addRoundRect(this.e, a(), Path.Direction.CW);
        return this.c;
    }

    public void a(float f) {
        this.f11157b = f;
    }

    public void a(int i, int i2) {
        this.e.set(0.0f, 0.0f, i, i2);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int i = R.attr.ksad_radius;
        int i2 = R.attr.ksad_clipBackground;
        int[] iArr = {i, i2};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f11157b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
        this.f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
        obtainStyledAttributes.recycle();
        this.c = new Path();
        this.d = new Paint(1);
        this.e = new RectF();
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        if (this.f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.d);
        }
        canvas.restore();
    }
}
