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
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class i {
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public float f56652b;

    /* renamed from: c  reason: collision with root package name */
    public Path f56653c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f56654d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f56655e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56656f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public a f56657g;

    /* loaded from: classes8.dex */
    public static class a {
        public boolean a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f56658b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56659c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56660d = true;

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }

        public void b(boolean z) {
            this.f56658b = z;
        }

        public boolean b() {
            return this.f56658b;
        }

        public void c(boolean z) {
            this.f56659c = z;
        }

        public boolean c() {
            return this.f56659c;
        }

        public void d(boolean z) {
            this.f56660d = z;
        }

        public boolean d() {
            return this.f56660d;
        }
    }

    public i() {
        this.a = new float[8];
        this.f56657g = new a();
    }

    public i(a aVar) {
        this.a = new float[8];
        this.f56657g = aVar == null ? new a() : aVar;
    }

    private float[] a() {
        this.a[0] = this.f56657g.a() ? this.f56652b : 0.0f;
        this.a[1] = this.f56657g.a() ? this.f56652b : 0.0f;
        this.a[2] = this.f56657g.b() ? this.f56652b : 0.0f;
        this.a[3] = this.f56657g.b() ? this.f56652b : 0.0f;
        this.a[4] = this.f56657g.c() ? this.f56652b : 0.0f;
        this.a[5] = this.f56657g.c() ? this.f56652b : 0.0f;
        this.a[6] = this.f56657g.d() ? this.f56652b : 0.0f;
        this.a[7] = this.f56657g.d() ? this.f56652b : 0.0f;
        return this.a;
    }

    private Path b() {
        try {
            this.f56653c.reset();
        } catch (Exception unused) {
        }
        this.f56653c.addRoundRect(this.f56655e, this.f56652b == 0.0f ? this.a : a(), Path.Direction.CW);
        return this.f56653c;
    }

    public void a(float f2) {
        this.f56652b = f2;
    }

    public void a(int i2, int i3) {
        this.f56655e.set(0.0f, 0.0f, i2, i3);
    }

    public void a(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.ksad_radius, R.attr.ksad_clipBackground};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f56652b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, (int) R.attr.ksad_radius), 0);
            this.f56656f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, (int) R.attr.ksad_clipBackground), true);
            obtainStyledAttributes.recycle();
        }
        this.f56653c = new Path();
        this.f56654d = new Paint(1);
        this.f56655e = new RectF();
        this.f56654d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f56656f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f56655e, null, 31);
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
        if (this.f56656f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f56654d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f56655e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f56654d);
        }
        canvas.restore();
    }
}
