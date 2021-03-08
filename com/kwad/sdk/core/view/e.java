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
/* loaded from: classes3.dex */
public class e extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private Paint f6317a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int[] h;
    private RectF i;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f6318a = 1;
        private int b = 12;
        private int c = Color.parseColor("#4d000000");
        private int d = 18;
        private int e = 0;
        private int f = 0;
        private int[] g = new int[1];

        public a() {
            this.g[0] = 0;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public e a() {
            return new e(this.f6318a, this.g, this.b, this.c, this.d, this.e, this.f);
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public a d(int i) {
            this.e = i;
            return this;
        }

        public a e(int i) {
            this.f = i;
            return this;
        }

        public a f(int i) {
            this.g[0] = i;
            return this;
        }
    }

    private e(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.d = i;
        this.h = iArr;
        this.e = i2;
        this.c = i4;
        this.f = i5;
        this.g = i6;
        this.f6317a = new Paint();
        this.f6317a.setColor(0);
        this.f6317a.setAntiAlias(true);
        this.f6317a.setShadowLayer(i4, i5, i6, i3);
        this.f6317a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.b = new Paint();
        this.b.setAntiAlias(true);
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
        if (this.h != null) {
            if (this.h.length == 1) {
                this.b.setColor(this.h[0]);
            } else {
                this.b.setShader(new LinearGradient(this.i.left, this.i.height() / 2.0f, this.i.right, this.i.height() / 2.0f, this.h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.d == 1) {
            canvas.drawRoundRect(this.i, this.e, this.e, this.f6317a);
            canvas.drawRoundRect(this.i, this.e, this.e, this.b);
            return;
        }
        canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.f6317a);
        canvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0f, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6317a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.i = new RectF((this.c + i) - this.f, (this.c + i2) - this.g, (i3 - this.c) - this.f, (i4 - this.c) - this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f6317a.setColorFilter(colorFilter);
    }
}
