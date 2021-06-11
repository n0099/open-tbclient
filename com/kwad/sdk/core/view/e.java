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
    public Paint f34905a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f34906b;

    /* renamed from: c  reason: collision with root package name */
    public int f34907c;

    /* renamed from: d  reason: collision with root package name */
    public int f34908d;

    /* renamed from: e  reason: collision with root package name */
    public int f34909e;

    /* renamed from: f  reason: collision with root package name */
    public int f34910f;

    /* renamed from: g  reason: collision with root package name */
    public int f34911g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f34912h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f34913i;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34914a = 1;

        /* renamed from: b  reason: collision with root package name */
        public int f34915b = 12;

        /* renamed from: c  reason: collision with root package name */
        public int f34916c = Color.parseColor("#4d000000");

        /* renamed from: d  reason: collision with root package name */
        public int f34917d = 18;

        /* renamed from: e  reason: collision with root package name */
        public int f34918e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f34919f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int[] f34920g;

        public a() {
            this.f34920g = r0;
            int[] iArr = {0};
        }

        public a a(int i2) {
            this.f34915b = i2;
            return this;
        }

        public e a() {
            return new e(this.f34914a, this.f34920g, this.f34915b, this.f34916c, this.f34917d, this.f34918e, this.f34919f);
        }

        public a b(int i2) {
            this.f34916c = i2;
            return this;
        }

        public a c(int i2) {
            this.f34917d = i2;
            return this;
        }

        public a d(int i2) {
            this.f34918e = i2;
            return this;
        }

        public a e(int i2) {
            this.f34919f = i2;
            return this;
        }

        public a f(int i2) {
            this.f34920g[0] = i2;
            return this;
        }
    }

    public e(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        this.f34908d = i2;
        this.f34912h = iArr;
        this.f34909e = i3;
        this.f34907c = i5;
        this.f34910f = i6;
        this.f34911g = i7;
        Paint paint = new Paint();
        this.f34905a = paint;
        paint.setColor(0);
        this.f34905a.setAntiAlias(true);
        this.f34905a.setShadowLayer(i5, i6, i7, i4);
        this.f34905a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f34906b = paint2;
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
        int[] iArr = this.f34912h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f34906b.setColor(iArr[0]);
            } else {
                Paint paint = this.f34906b;
                RectF rectF = this.f34913i;
                float f2 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.f34913i;
                paint.setShader(new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.f34912h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f34908d != 1) {
            canvas.drawCircle(this.f34913i.centerX(), this.f34913i.centerY(), Math.min(this.f34913i.width(), this.f34913i.height()) / 2.0f, this.f34905a);
            canvas.drawCircle(this.f34913i.centerX(), this.f34913i.centerY(), Math.min(this.f34913i.width(), this.f34913i.height()) / 2.0f, this.f34906b);
            return;
        }
        RectF rectF3 = this.f34913i;
        int i2 = this.f34909e;
        canvas.drawRoundRect(rectF3, i2, i2, this.f34905a);
        RectF rectF4 = this.f34913i;
        int i3 = this.f34909e;
        canvas.drawRoundRect(rectF4, i3, i3, this.f34906b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f34905a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        int i6 = this.f34907c;
        int i7 = this.f34910f;
        int i8 = this.f34911g;
        this.f34913i = new RectF((i2 + i6) - i7, (i3 + i6) - i8, (i4 - i6) - i7, (i5 - i6) - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f34905a.setColorFilter(colorFilter);
    }
}
