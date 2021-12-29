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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class i {
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public float f60380b;

    /* renamed from: c  reason: collision with root package name */
    public Path f60381c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f60382d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f60383e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60384f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public a f60385g;

    /* loaded from: classes3.dex */
    public static class a {
        public boolean a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f60386b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f60387c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f60388d = true;

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }

        public void b(boolean z) {
            this.f60386b = z;
        }

        public boolean b() {
            return this.f60386b;
        }

        public void c(boolean z) {
            this.f60387c = z;
        }

        public boolean c() {
            return this.f60387c;
        }

        public void d(boolean z) {
            this.f60388d = z;
        }

        public boolean d() {
            return this.f60388d;
        }
    }

    public i() {
        this.a = new float[8];
        this.f60385g = new a();
    }

    public i(a aVar) {
        this.a = new float[8];
        this.f60385g = aVar == null ? new a() : aVar;
    }

    private float[] a() {
        this.a[0] = this.f60385g.a() ? this.f60380b : 0.0f;
        this.a[1] = this.f60385g.a() ? this.f60380b : 0.0f;
        this.a[2] = this.f60385g.b() ? this.f60380b : 0.0f;
        this.a[3] = this.f60385g.b() ? this.f60380b : 0.0f;
        this.a[4] = this.f60385g.c() ? this.f60380b : 0.0f;
        this.a[5] = this.f60385g.c() ? this.f60380b : 0.0f;
        this.a[6] = this.f60385g.d() ? this.f60380b : 0.0f;
        this.a[7] = this.f60385g.d() ? this.f60380b : 0.0f;
        return this.a;
    }

    private Path b() {
        try {
            this.f60381c.reset();
        } catch (Exception unused) {
        }
        this.f60381c.addRoundRect(this.f60383e, this.f60380b == 0.0f ? this.a : a(), Path.Direction.CW);
        return this.f60381c;
    }

    public void a(float f2) {
        this.f60380b = f2;
    }

    public void a(int i2, int i3) {
        this.f60383e.set(0.0f, 0.0f, i2, i3);
    }

    public void a(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i2 = R.attr.ksad_radius;
            int i3 = R.attr.ksad_clipBackground;
            int[] iArr = {i2, i3};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f60380b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), 0);
            this.f60384f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
            obtainStyledAttributes.recycle();
        }
        this.f60381c = new Path();
        this.f60382d = new Paint(1);
        this.f60383e = new RectF();
        this.f60382d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f60384f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f60383e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void a(float[] fArr) {
        this.a = fArr;
    }

    public void b(Canvas canvas) {
        if (this.f60384f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f60382d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f60383e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f60382d);
        }
        canvas.restore();
    }
}
