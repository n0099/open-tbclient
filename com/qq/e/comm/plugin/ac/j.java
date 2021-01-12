package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class j extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private RectF f11862a;

    /* renamed from: b  reason: collision with root package name */
    private Path f11863b;
    private float[] c;

    public j(Context context) {
        super(context);
        this.f11862a = new RectF();
        this.f11863b = new Path();
        this.c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void a(float f) {
        this.c[0] = f;
        this.c[1] = f;
        this.c[2] = f;
        this.c[3] = f;
        this.c[4] = f;
        this.c[5] = f;
        this.c[6] = f;
        this.c[7] = f;
    }

    public void a(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.c = fArr;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f11862a.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f11863b.addRoundRect(this.f11862a, this.c, Path.Direction.CW);
        canvas.clipPath(this.f11863b);
        super.onDraw(canvas);
        this.f11863b.reset();
    }
}
