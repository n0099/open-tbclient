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
    public boolean f38671e;

    /* renamed from: f  reason: collision with root package name */
    public Path f38672f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f38673g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f38674h;
    public float[] i;

    public ClipImageView(Context context) {
        super(context);
        this.f38671e = true;
        a(context);
    }

    public void a(Context context) {
        this.f38672f = new Path();
        this.f38673g = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f38671e) {
            this.f38672f.reset();
            this.f38673g.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.i;
            if (fArr != null) {
                this.f38672f.addRoundRect(this.f38673g, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f38672f);
            Paint paint = this.f38674h;
            if (paint != null) {
                canvas.drawPath(this.f38672f, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f38674h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f38674h.setColor(i);
    }

    public void setClip(boolean z) {
        this.f38671e = z;
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
        this.f38671e = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f38671e = true;
        a(context);
    }
}
