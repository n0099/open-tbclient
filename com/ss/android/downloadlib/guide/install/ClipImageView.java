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
    public boolean f38670e;

    /* renamed from: f  reason: collision with root package name */
    public Path f38671f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f38672g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f38673h;
    public float[] i;

    public ClipImageView(Context context) {
        super(context);
        this.f38670e = true;
        a(context);
    }

    public void a(Context context) {
        this.f38671f = new Path();
        this.f38672g = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f38670e) {
            this.f38671f.reset();
            this.f38672g.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.i;
            if (fArr != null) {
                this.f38671f.addRoundRect(this.f38672g, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f38671f);
            Paint paint = this.f38673h;
            if (paint != null) {
                canvas.drawPath(this.f38671f, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f38673h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f38673h.setColor(i);
    }

    public void setClip(boolean z) {
        this.f38670e = z;
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
        this.f38670e = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f38670e = true;
        a(context);
    }
}
