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
    public float[] f37131a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    public float f37132b;

    /* renamed from: c  reason: collision with root package name */
    public Path f37133c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f37134d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f37135e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37136f;

    private float[] a() {
        float[] fArr = this.f37131a;
        float f2 = this.f37132b;
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
        this.f37133c.reset();
        this.f37133c.addRoundRect(this.f37135e, a(), Path.Direction.CW);
        return this.f37133c;
    }

    public void a(float f2) {
        this.f37132b = f2;
    }

    public void a(int i, int i2) {
        this.f37135e.set(0.0f, 0.0f, i, i2);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int i = R.attr.ksad_radius;
        int i2 = R.attr.ksad_clipBackground;
        int[] iArr = {i, i2};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f37132b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
        this.f37136f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
        obtainStyledAttributes.recycle();
        this.f37133c = new Path();
        this.f37134d = new Paint(1);
        this.f37135e = new RectF();
        this.f37134d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f37136f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f37135e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        if (this.f37136f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f37134d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f37135e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f37134d);
        }
        canvas.restore();
    }
}
