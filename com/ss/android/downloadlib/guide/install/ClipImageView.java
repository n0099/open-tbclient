package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class ClipImageView extends ImageView {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Path f42990b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f42991c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f42992d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f42993e;

    public ClipImageView(Context context) {
        super(context);
        this.a = true;
        a(context);
    }

    public void a(Context context) {
        this.f42990b = new Path();
        this.f42991c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.a) {
            this.f42990b.reset();
            this.f42991c.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f42993e;
            if (fArr != null) {
                this.f42990b.addRoundRect(this.f42991c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f42990b);
            Paint paint = this.f42992d;
            if (paint != null) {
                canvas.drawPath(this.f42990b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f42992d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f42992d.setColor(i);
    }

    public void setClip(boolean z) {
        this.a = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f42993e = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f2 = i;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        a(context);
    }
}
