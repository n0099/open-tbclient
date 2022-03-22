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
/* loaded from: classes7.dex */
public class i {
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public float f41528b;

    /* renamed from: c  reason: collision with root package name */
    public Path f41529c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f41530d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f41531e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41532f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public a f41533g;

    /* loaded from: classes7.dex */
    public static class a {
        public boolean a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41534b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41535c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41536d = true;

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }

        public void b(boolean z) {
            this.f41534b = z;
        }

        public boolean b() {
            return this.f41534b;
        }

        public void c(boolean z) {
            this.f41535c = z;
        }

        public boolean c() {
            return this.f41535c;
        }

        public void d(boolean z) {
            this.f41536d = z;
        }

        public boolean d() {
            return this.f41536d;
        }
    }

    public i() {
        this.a = new float[8];
        this.f41533g = new a();
    }

    public i(a aVar) {
        this.a = new float[8];
        this.f41533g = aVar == null ? new a() : aVar;
    }

    private float[] a() {
        this.a[0] = this.f41533g.a() ? this.f41528b : 0.0f;
        this.a[1] = this.f41533g.a() ? this.f41528b : 0.0f;
        this.a[2] = this.f41533g.b() ? this.f41528b : 0.0f;
        this.a[3] = this.f41533g.b() ? this.f41528b : 0.0f;
        this.a[4] = this.f41533g.c() ? this.f41528b : 0.0f;
        this.a[5] = this.f41533g.c() ? this.f41528b : 0.0f;
        this.a[6] = this.f41533g.d() ? this.f41528b : 0.0f;
        this.a[7] = this.f41533g.d() ? this.f41528b : 0.0f;
        return this.a;
    }

    private Path b() {
        try {
            this.f41529c.reset();
        } catch (Exception unused) {
        }
        this.f41529c.addRoundRect(this.f41531e, this.f41528b == 0.0f ? this.a : a(), Path.Direction.CW);
        return this.f41529c;
    }

    public void a(float f2) {
        this.f41528b = f2;
    }

    public void a(int i, int i2) {
        this.f41531e.set(0.0f, 0.0f, i, i2);
    }

    public void a(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f040320, R.attr.obfuscated_res_0x7f04030a};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f41528b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f040320), 0);
            this.f41532f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f04030a), true);
            obtainStyledAttributes.recycle();
        }
        this.f41529c = new Path();
        this.f41530d = new Paint(1);
        this.f41531e = new RectF();
        this.f41530d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(Canvas canvas) {
        if (this.f41532f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f41531e, null, 31);
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
        if (this.f41532f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f41530d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.f41531e, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(b());
    }

    public void d(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(b(), this.f41530d);
        }
        canvas.restore();
    }
}
