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

    /* renamed from: e  reason: collision with root package name */
    public boolean f35814e;

    /* renamed from: f  reason: collision with root package name */
    public Path f35815f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f35816g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f35817h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f35818i;

    public ClipImageView(Context context) {
        super(context);
        this.f35814e = true;
        a(context);
    }

    public void a(Context context) {
        this.f35815f = new Path();
        this.f35816g = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f35814e) {
            this.f35815f.reset();
            this.f35816g.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f35818i;
            if (fArr != null) {
                this.f35815f.addRoundRect(this.f35816g, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f35815f);
            Paint paint = this.f35817h;
            if (paint != null) {
                canvas.drawPath(this.f35815f, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f35817h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f35817h.setColor(i2);
    }

    public void setClip(boolean z) {
        this.f35814e = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f35818i = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35814e = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35814e = true;
        a(context);
    }
}
