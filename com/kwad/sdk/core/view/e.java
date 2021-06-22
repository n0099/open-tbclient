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
/* loaded from: classes7.dex */
public class e extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Paint f35003a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f35004b;

    /* renamed from: c  reason: collision with root package name */
    public int f35005c;

    /* renamed from: d  reason: collision with root package name */
    public int f35006d;

    /* renamed from: e  reason: collision with root package name */
    public int f35007e;

    /* renamed from: f  reason: collision with root package name */
    public int f35008f;

    /* renamed from: g  reason: collision with root package name */
    public int f35009g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f35010h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f35011i;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35012a = 1;

        /* renamed from: b  reason: collision with root package name */
        public int f35013b = 12;

        /* renamed from: c  reason: collision with root package name */
        public int f35014c = Color.parseColor("#4d000000");

        /* renamed from: d  reason: collision with root package name */
        public int f35015d = 18;

        /* renamed from: e  reason: collision with root package name */
        public int f35016e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f35017f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int[] f35018g;

        public a() {
            this.f35018g = r0;
            int[] iArr = {0};
        }

        public a a(int i2) {
            this.f35013b = i2;
            return this;
        }

        public e a() {
            return new e(this.f35012a, this.f35018g, this.f35013b, this.f35014c, this.f35015d, this.f35016e, this.f35017f);
        }

        public a b(int i2) {
            this.f35014c = i2;
            return this;
        }

        public a c(int i2) {
            this.f35015d = i2;
            return this;
        }

        public a d(int i2) {
            this.f35016e = i2;
            return this;
        }

        public a e(int i2) {
            this.f35017f = i2;
            return this;
        }

        public a f(int i2) {
            this.f35018g[0] = i2;
            return this;
        }
    }

    public e(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        this.f35006d = i2;
        this.f35010h = iArr;
        this.f35007e = i3;
        this.f35005c = i5;
        this.f35008f = i6;
        this.f35009g = i7;
        Paint paint = new Paint();
        this.f35003a = paint;
        paint.setColor(0);
        this.f35003a.setAntiAlias(true);
        this.f35003a.setShadowLayer(i5, i6, i7, i4);
        this.f35003a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f35004b = paint2;
        paint2.setAntiAlias(true);
    }

    public static void a(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        e a2 = new a().f(i2).a(i3).b(i4).c(i5).d(i6).e(i7).a();
        view.setLayerType(1, null);
        view.setBackground(a2);
    }

    public static void a(View view, Drawable drawable) {
        view.setLayerType(1, null);
        view.setBackground(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] iArr = this.f35010h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f35004b.setColor(iArr[0]);
            } else {
                Paint paint = this.f35004b;
                RectF rectF = this.f35011i;
                float f2 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.f35011i;
                paint.setShader(new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.f35010h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f35006d != 1) {
            canvas.drawCircle(this.f35011i.centerX(), this.f35011i.centerY(), Math.min(this.f35011i.width(), this.f35011i.height()) / 2.0f, this.f35003a);
            canvas.drawCircle(this.f35011i.centerX(), this.f35011i.centerY(), Math.min(this.f35011i.width(), this.f35011i.height()) / 2.0f, this.f35004b);
            return;
        }
        RectF rectF3 = this.f35011i;
        int i2 = this.f35007e;
        canvas.drawRoundRect(rectF3, i2, i2, this.f35003a);
        RectF rectF4 = this.f35011i;
        int i3 = this.f35007e;
        canvas.drawRoundRect(rectF4, i3, i3, this.f35004b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f35003a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        int i6 = this.f35005c;
        int i7 = this.f35008f;
        int i8 = this.f35009g;
        this.f35011i = new RectF((i2 + i6) - i7, (i3 + i6) - i8, (i4 - i6) - i7, (i5 - i6) - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f35003a.setColorFilter(colorFilter);
    }
}
