package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class e extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Paint f34647a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f34648b;

    /* renamed from: c  reason: collision with root package name */
    public int f34649c;

    /* renamed from: d  reason: collision with root package name */
    public int f34650d;

    /* renamed from: e  reason: collision with root package name */
    public int f34651e;

    /* renamed from: f  reason: collision with root package name */
    public int f34652f;

    /* renamed from: g  reason: collision with root package name */
    public int f34653g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f34654h;
    public RectF i;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34655a = 1;

        /* renamed from: b  reason: collision with root package name */
        public int f34656b = 12;

        /* renamed from: c  reason: collision with root package name */
        public int f34657c = Color.parseColor("#4d000000");

        /* renamed from: d  reason: collision with root package name */
        public int f34658d = 18;

        /* renamed from: e  reason: collision with root package name */
        public int f34659e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f34660f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int[] f34661g;

        public a() {
            this.f34661g = r0;
            int[] iArr = {0};
        }

        public a a(int i) {
            this.f34656b = i;
            return this;
        }

        public e a() {
            return new e(this.f34655a, this.f34661g, this.f34656b, this.f34657c, this.f34658d, this.f34659e, this.f34660f);
        }

        public a b(int i) {
            this.f34657c = i;
            return this;
        }

        public a c(int i) {
            this.f34658d = i;
            return this;
        }

        public a d(int i) {
            this.f34659e = i;
            return this;
        }

        public a e(int i) {
            this.f34660f = i;
            return this;
        }

        public a f(int i) {
            this.f34661g[0] = i;
            return this;
        }
    }

    public e(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.f34650d = i;
        this.f34654h = iArr;
        this.f34651e = i2;
        this.f34649c = i4;
        this.f34652f = i5;
        this.f34653g = i6;
        Paint paint = new Paint();
        this.f34647a = paint;
        paint.setColor(0);
        this.f34647a.setAntiAlias(true);
        this.f34647a.setShadowLayer(i4, i5, i6, i3);
        this.f34647a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f34648b = paint2;
        paint2.setAntiAlias(true);
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        e a2 = new a().f(i).a(i2).b(i3).c(i4).d(i5).e(i6).a();
        view.setLayerType(1, null);
        view.setBackground(a2);
    }

    public static void a(View view, Drawable drawable) {
        view.setLayerType(1, null);
        view.setBackground(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] iArr = this.f34654h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f34648b.setColor(iArr[0]);
            } else {
                Paint paint = this.f34648b;
                RectF rectF = this.i;
                float f2 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.i;
                paint.setShader(new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.f34654h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f34650d != 1) {
            canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.f34647a);
            canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.f34648b);
            return;
        }
        RectF rectF3 = this.i;
        int i = this.f34651e;
        canvas.drawRoundRect(rectF3, i, i, this.f34647a);
        RectF rectF4 = this.i;
        int i2 = this.f34651e;
        canvas.drawRoundRect(rectF4, i2, i2, this.f34648b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f34647a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.f34649c;
        int i6 = this.f34652f;
        int i7 = this.f34653g;
        this.i = new RectF((i + i5) - i6, (i2 + i5) - i7, (i3 - i5) - i6, (i4 - i5) - i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f34647a.setColorFilter(colorFilter);
    }
}
