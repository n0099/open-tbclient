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
    public float[] f36841a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    public float f36842b;

    /* renamed from: c  reason: collision with root package name */
    public Path f36843c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f36844d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f36845e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36846f;

    private float[] a() {
        float[] fArr = this.f36841a;
        float f2 = this.f36842b;
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
        this.f36843c.reset();
        this.f36843c.addRoundRect(this.f36845e, a(), Path.Direction.CW);
        return this.f36843c;
    }

    public void a(float f2) {
        this.f36842b = f2;
    }

    public void a(int i, int i2) {
        this.f36845e.set(0.0f, 0.0f, i, i2);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int i = R.attr.ksad_radius;
        int i2 = R.attr.ksad_clipBackground;
        int[] iArr = {i, i2};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f36842b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), 0);
        this.f36846f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), true);
        obtainStyledAttributes.recycle();
        this.f36843c = new Path();
        this.f36844d = new Paint(1);
        this.f36845e = new RectF();
        this.f36844d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f36846f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f36845e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        if (this.f36846f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f36844d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f36845e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f36844d);
        }
        canvas.restore();
    }
}
