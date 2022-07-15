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
/* loaded from: classes5.dex */
public final class h {
    public float[] a;
    public float b;
    public Path c;
    public Paint d;
    public RectF e;
    public boolean f;
    @NonNull
    public a g;

    /* loaded from: classes5.dex */
    public static class a {
        public boolean a = true;
        public boolean b = true;
        public boolean c = true;
        public boolean d = true;

        public final a a(boolean z) {
            this.a = z;
            return this;
        }

        public final boolean a() {
            return this.a;
        }

        public final a b(boolean z) {
            this.b = z;
            return this;
        }

        public final boolean b() {
            return this.b;
        }

        public final a c(boolean z) {
            this.c = z;
            return this;
        }

        public final boolean c() {
            return this.c;
        }

        public final a d(boolean z) {
            this.d = z;
            return this;
        }

        public final boolean d() {
            return this.d;
        }

        public final void e(boolean z) {
            this.a = true;
            this.b = true;
            this.c = true;
            this.d = true;
        }
    }

    public h() {
        this.a = new float[8];
        this.g = new a();
    }

    public h(a aVar) {
        this.a = new float[8];
        this.g = aVar;
    }

    private float[] b() {
        this.a[0] = this.g.a() ? this.b : 0.0f;
        this.a[1] = this.g.a() ? this.b : 0.0f;
        this.a[2] = this.g.b() ? this.b : 0.0f;
        this.a[3] = this.g.b() ? this.b : 0.0f;
        this.a[4] = this.g.c() ? this.b : 0.0f;
        this.a[5] = this.g.c() ? this.b : 0.0f;
        this.a[6] = this.g.d() ? this.b : 0.0f;
        this.a[7] = this.g.d() ? this.b : 0.0f;
        return this.a;
    }

    private Path c() {
        try {
            this.c.reset();
        } catch (Exception unused) {
        }
        this.c.addRoundRect(this.e, this.b == 0.0f ? this.a : b(), Path.Direction.CW);
        return this.c;
    }

    @NonNull
    public final a a() {
        return this.g;
    }

    public final void a(float f) {
        this.b = f;
    }

    public final void a(int i, int i2) {
        this.e.set(0.0f, 0.0f, i, i2);
    }

    public final void a(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f040376, R.attr.obfuscated_res_0x7f04034a};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f040376), 0);
            this.f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f04034a), true);
            obtainStyledAttributes.recycle();
        }
        this.c = new Path();
        this.d = new Paint(1);
        this.e = new RectF();
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void a(Canvas canvas) {
        if (this.f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(c());
        }
    }

    public final void a(float[] fArr) {
        this.a = fArr;
    }

    public final void b(Canvas canvas) {
        if (this.f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(c(), this.d);
            }
            canvas.restore();
        }
    }

    public final void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(c());
    }

    public final void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(c(), this.d);
        }
        canvas.restore();
    }
}
