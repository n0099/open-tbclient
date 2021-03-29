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
    public float[] f36842a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    public float f36843b;

    /* renamed from: c  reason: collision with root package name */
    public Path f36844c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f36845d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f36846e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36847f;

    private float[] a() {
        float[] fArr = this.f36842a;
        float f2 = this.f36843b;
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
        this.f36844c.reset();
        this.f36844c.addRoundRect(this.f36846e, a(), Path.Direction.CW);
        return this.f36844c;
    }

    public void a(float f2) {
        this.f36843b = f2;
    }

    public void a(int i, int i2) {
        this.f36846e.set(0.0f, 0.0f, i, i2);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int i = R.attr.ksad_radius;
        int i2 = R.attr.ksad_clipBackground;
        int[] iArr = {i, i2};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f36843b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
        this.f36847f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
        obtainStyledAttributes.recycle();
        this.f36844c = new Path();
        this.f36845d = new Paint(1);
        this.f36846e = new RectF();
        this.f36845d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f36847f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f36846e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        if (this.f36847f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f36845d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f36846e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f36845d);
        }
        canvas.restore();
    }
}
