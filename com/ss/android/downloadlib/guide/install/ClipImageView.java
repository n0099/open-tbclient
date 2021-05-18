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
    public boolean f35885e;

    /* renamed from: f  reason: collision with root package name */
    public Path f35886f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f35887g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f35888h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f35889i;

    public ClipImageView(Context context) {
        super(context);
        this.f35885e = true;
        a(context);
    }

    public void a(Context context) {
        this.f35886f = new Path();
        this.f35887g = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f35885e) {
            this.f35886f.reset();
            this.f35887g.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f35889i;
            if (fArr != null) {
                this.f35886f.addRoundRect(this.f35887g, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f35886f);
            Paint paint = this.f35888h;
            if (paint != null) {
                canvas.drawPath(this.f35886f, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f35888h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f35888h.setColor(i2);
    }

    public void setClip(boolean z) {
        this.f35885e = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f35889i = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35885e = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35885e = true;
        a(context);
    }
}
