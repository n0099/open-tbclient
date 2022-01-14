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
    public float f58090b;

    /* renamed from: c  reason: collision with root package name */
    public Path f58091c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f58092d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f58093e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58094f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public a f58095g;

    /* loaded from: classes3.dex */
    public static class a {
        public boolean a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f58096b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f58097c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f58098d = true;

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }

        public void b(boolean z) {
            this.f58096b = z;
        }

        public boolean b() {
            return this.f58096b;
        }

        public void c(boolean z) {
            this.f58097c = z;
        }

        public boolean c() {
            return this.f58097c;
        }

        public void d(boolean z) {
            this.f58098d = z;
        }

        public boolean d() {
            return this.f58098d;
        }
    }

    public i() {
        this.a = new float[8];
        this.f58095g = new a();
    }

    public i(a aVar) {
        this.a = new float[8];
        this.f58095g = aVar == null ? new a() : aVar;
    }

    private float[] a() {
        this.a[0] = this.f58095g.a() ? this.f58090b : 0.0f;
        this.a[1] = this.f58095g.a() ? this.f58090b : 0.0f;
        this.a[2] = this.f58095g.b() ? this.f58090b : 0.0f;
        this.a[3] = this.f58095g.b() ? this.f58090b : 0.0f;
        this.a[4] = this.f58095g.c() ? this.f58090b : 0.0f;
        this.a[5] = this.f58095g.c() ? this.f58090b : 0.0f;
        this.a[6] = this.f58095g.d() ? this.f58090b : 0.0f;
        this.a[7] = this.f58095g.d() ? this.f58090b : 0.0f;
        return this.a;
    }

    private Path b() {
        try {
            this.f58091c.reset();
        } catch (Exception unused) {
        }
        this.f58091c.addRoundRect(this.f58093e, this.f58090b == 0.0f ? this.a : a(), Path.Direction.CW);
        return this.f58091c;
    }

    public void a(float f2) {
        this.f58090b = f2;
    }

    public void a(int i2, int i3) {
        this.f58093e.set(0.0f, 0.0f, i2, i3);
    }

    public void a(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i2 = R.attr.ksad_radius;
            int i3 = R.attr.ksad_clipBackground;
            int[] iArr = {i2, i3};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f58090b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), 0);
            this.f58094f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
            obtainStyledAttributes.recycle();
        }
        this.f58091c = new Path();
        this.f58092d = new Paint(1);
        this.f58093e = new RectF();
        this.f58092d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f58094f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f58093e, null, 31);
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
        if (this.f58094f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f58092d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f58093e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f58092d);
        }
        canvas.restore();
    }
}
