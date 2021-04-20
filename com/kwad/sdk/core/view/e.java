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
    public Paint f34552a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f34553b;

    /* renamed from: c  reason: collision with root package name */
    public int f34554c;

    /* renamed from: d  reason: collision with root package name */
    public int f34555d;

    /* renamed from: e  reason: collision with root package name */
    public int f34556e;

    /* renamed from: f  reason: collision with root package name */
    public int f34557f;

    /* renamed from: g  reason: collision with root package name */
    public int f34558g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f34559h;
    public RectF i;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34560a = 1;

        /* renamed from: b  reason: collision with root package name */
        public int f34561b = 12;

        /* renamed from: c  reason: collision with root package name */
        public int f34562c = Color.parseColor("#4d000000");

        /* renamed from: d  reason: collision with root package name */
        public int f34563d = 18;

        /* renamed from: e  reason: collision with root package name */
        public int f34564e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f34565f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int[] f34566g;

        public a() {
            this.f34566g = r0;
            int[] iArr = {0};
        }

        public a a(int i) {
            this.f34561b = i;
            return this;
        }

        public e a() {
            return new e(this.f34560a, this.f34566g, this.f34561b, this.f34562c, this.f34563d, this.f34564e, this.f34565f);
        }

        public a b(int i) {
            this.f34562c = i;
            return this;
        }

        public a c(int i) {
            this.f34563d = i;
            return this;
        }

        public a d(int i) {
            this.f34564e = i;
            return this;
        }

        public a e(int i) {
            this.f34565f = i;
            return this;
        }

        public a f(int i) {
            this.f34566g[0] = i;
            return this;
        }
    }

    public e(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.f34555d = i;
        this.f34559h = iArr;
        this.f34556e = i2;
        this.f34554c = i4;
        this.f34557f = i5;
        this.f34558g = i6;
        Paint paint = new Paint();
        this.f34552a = paint;
        paint.setColor(0);
        this.f34552a.setAntiAlias(true);
        this.f34552a.setShadowLayer(i4, i5, i6, i3);
        this.f34552a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f34553b = paint2;
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
        int[] iArr = this.f34559h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f34553b.setColor(iArr[0]);
            } else {
                Paint paint = this.f34553b;
                RectF rectF = this.i;
                float f2 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.i;
                paint.setShader(new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.f34559h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f34555d != 1) {
            canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.f34552a);
            canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.f34553b);
            return;
        }
        RectF rectF3 = this.i;
        int i = this.f34556e;
        canvas.drawRoundRect(rectF3, i, i, this.f34552a);
        RectF rectF4 = this.i;
        int i2 = this.f34556e;
        canvas.drawRoundRect(rectF4, i2, i2, this.f34553b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f34552a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.f34554c;
        int i6 = this.f34557f;
        int i7 = this.f34558g;
        this.i = new RectF((i + i5) - i6, (i2 + i5) - i7, (i3 - i5) - i6, (i4 - i5) - i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f34552a.setColorFilter(colorFilter);
    }
}
