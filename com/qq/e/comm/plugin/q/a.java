package com.qq.e.comm.plugin.q;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
/* loaded from: classes4.dex */
class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f12652a;

    /* renamed from: b  reason: collision with root package name */
    private float f12653b;
    private RectF c;
    private float d;
    private Path e;

    public a(Context context) {
        super(context);
        setLayerType(1, null);
        this.c = new RectF();
        this.f12652a = new Paint();
        this.f12652a.setAntiAlias(true);
        this.e = new Path();
    }

    private float a() {
        return (float) (((2.0f * this.d) * Math.sqrt(Math.pow(b() / 2, 2.0d) + Math.pow(c() - this.f12653b, 2.0d))) / b());
    }

    private int b() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private int c() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void a(float f) {
        this.f12653b = (float) (f / Math.sqrt(2.0d));
        this.d = f;
        this.f12652a.setStrokeWidth(f);
    }

    public void a(int i) {
        this.f12652a.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.moveTo(getPaddingLeft(), getHeight() / 2);
        this.e.lineTo((c() - this.f12653b) + getPaddingLeft(), getPaddingTop());
        this.e.lineTo(c() + getPaddingLeft(), this.f12653b + getPaddingTop());
        this.e.lineTo(a() + getPaddingLeft(), getHeight() / 2);
        this.e.lineTo(c() + getPaddingLeft(), (b() - this.f12653b) + getPaddingTop());
        this.e.lineTo((c() - this.f12653b) + getPaddingLeft(), b() + getPaddingTop());
        this.e.close();
        canvas.drawPath(this.e, this.f12652a);
        this.c.set((c() - (this.f12653b * 2.0f)) + getPaddingLeft(), getPaddingTop(), c() + getPaddingLeft(), (this.f12653b * 2.0f) + getPaddingTop());
        canvas.drawArc(this.c, 0.0f, -90.0f, true, this.f12652a);
        this.c.set((c() - (this.f12653b * 2.0f)) + getPaddingLeft(), (b() - (this.f12653b * 2.0f)) + getPaddingTop(), c() + getPaddingLeft(), b() + getPaddingTop());
        canvas.drawArc(this.c, 0.0f, 90.0f, true, this.f12652a);
    }
}
