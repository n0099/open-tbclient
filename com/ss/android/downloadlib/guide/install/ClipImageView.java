package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class ClipImageView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f39055e;

    /* renamed from: f  reason: collision with root package name */
    public Path f39056f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f39057g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f39058h;
    public float[] i;

    public ClipImageView(Context context) {
        super(context);
        this.f39055e = true;
        a(context);
    }

    public void a(Context context) {
        this.f39056f = new Path();
        this.f39057g = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f39055e) {
            this.f39056f.reset();
            this.f39057g.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.i;
            if (fArr != null) {
                this.f39056f.addRoundRect(this.f39057g, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f39056f);
            Paint paint = this.f39058h;
            if (paint != null) {
                canvas.drawPath(this.f39056f, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f39058h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f39058h.setColor(i);
    }

    public void setClip(boolean z) {
        this.f39055e = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.i = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f2 = i;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39055e = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39055e = true;
        a(context);
    }
}
