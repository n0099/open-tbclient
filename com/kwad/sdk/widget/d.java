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
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float[] f37698a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    public float f37699b;

    /* renamed from: c  reason: collision with root package name */
    public Path f37700c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f37701d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f37702e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37703f;

    private float[] a() {
        float[] fArr = this.f37698a;
        float f2 = this.f37699b;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        return fArr;
    }

    private Path b() {
        this.f37700c.reset();
        this.f37700c.addRoundRect(this.f37702e, a(), Path.Direction.CW);
        return this.f37700c;
    }

    public void a(float f2) {
        this.f37699b = f2;
    }

    public void a(int i2, int i3) {
        this.f37702e.set(0.0f, 0.0f, i2, i3);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int i2 = R.attr.ksad_radius;
        int i3 = R.attr.ksad_clipBackground;
        int[] iArr = {i2, i3};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f37699b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), 0);
        this.f37703f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
        obtainStyledAttributes.recycle();
        this.f37700c = new Path();
        this.f37701d = new Paint(1);
        this.f37702e = new RectF();
        this.f37701d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f37703f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f37702e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        if (this.f37703f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f37701d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f37702e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f37701d);
        }
        canvas.restore();
    }
}
