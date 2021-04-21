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
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float[] f37226a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    public float f37227b;

    /* renamed from: c  reason: collision with root package name */
    public Path f37228c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f37229d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f37230e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37231f;

    private float[] a() {
        float[] fArr = this.f37226a;
        float f2 = this.f37227b;
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
        this.f37228c.reset();
        this.f37228c.addRoundRect(this.f37230e, a(), Path.Direction.CW);
        return this.f37228c;
    }

    public void a(float f2) {
        this.f37227b = f2;
    }

    public void a(int i, int i2) {
        this.f37230e.set(0.0f, 0.0f, i, i2);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int i = R.attr.ksad_radius;
        int i2 = R.attr.ksad_clipBackground;
        int[] iArr = {i, i2};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f37227b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
        this.f37231f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
        obtainStyledAttributes.recycle();
        this.f37228c = new Path();
        this.f37229d = new Paint(1);
        this.f37230e = new RectF();
        this.f37229d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f37231f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f37230e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        if (this.f37231f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f37229d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f37230e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f37229d);
        }
        canvas.restore();
    }
}
