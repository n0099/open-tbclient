package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
/* loaded from: classes4.dex */
public class h extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f12154a;

    /* renamed from: b  reason: collision with root package name */
    private int f12155b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private Paint h;
    private Path i;
    private float[] j;
    private RectF k;

    public h(Context context) {
        super(context);
        this.c = 100;
        this.d = false;
        this.e = Color.parseColor("#3185FC");
        this.f = Color.parseColor("#3185FC");
        this.g = Color.parseColor("#d8d8d8");
        this.i = new Path();
        this.j = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        setLayerType(1, null);
        a();
    }

    private void a() {
        this.f12154a = new Paint();
        this.h = new Paint();
        this.k = new RectF();
    }

    private void a(Canvas canvas, float f, float f2, float f3, float f4, Paint paint) {
        this.k.set(f, f2, f3, f4);
        canvas.drawRect(this.k, paint);
    }

    public void a(float f) {
        if (this.j == null || this.j.length <= 0) {
            return;
        }
        for (int i = 0; i < this.j.length; i++) {
            this.j[i] = f;
        }
    }

    public void a(int i) {
        if (i <= 0) {
            this.f12155b = 0;
        } else if (i >= 100) {
            this.f12155b = 100;
        } else {
            this.f12155b = i;
        }
        postInvalidate();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.e = i;
        this.f = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.k.set(0.0f, 0.0f, getWidth(), getHeight());
        this.i.addRoundRect(this.k, this.j, Path.Direction.CW);
        canvas.clipPath(this.i);
        super.onDraw(canvas);
        if (this.f12155b >= 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = measuredHeight / 2.0f;
            float f2 = (this.f12155b / this.c) * measuredWidth;
            if (!this.d) {
                this.h.setColor(Color.parseColor("#40000000"));
                a(canvas, 0.0f, 0.0f, measuredWidth, measuredHeight, this.h);
                this.f12154a.setColor(Color.parseColor("#BFFFFFFF"));
                a(canvas, 0.0f, 0.0f, f2, measuredHeight, this.f12154a);
            } else if (this.f12155b <= 0 || this.f12155b >= 100) {
                this.h.setColor(this.f);
                this.f12154a.setStyle(Paint.Style.FILL);
                a(canvas, 0.0f, 0.0f, measuredWidth, measuredHeight, this.h);
            } else {
                this.h.setColor(this.g);
                a(canvas, 0.0f, 0.0f, measuredWidth, measuredHeight, this.h);
                this.f12154a.setShader(new LinearGradient(0.0f, f, f2, f, this.e, this.f, Shader.TileMode.CLAMP));
                this.f12154a.setStyle(Paint.Style.FILL);
                a(canvas, 0.0f, 0.0f, f2, measuredHeight, this.f12154a);
            }
        }
        this.i.reset();
    }
}
