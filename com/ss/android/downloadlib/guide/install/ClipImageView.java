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
    public boolean f36640e;

    /* renamed from: f  reason: collision with root package name */
    public Path f36641f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f36642g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f36643h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f36644i;

    public ClipImageView(Context context) {
        super(context);
        this.f36640e = true;
        a(context);
    }

    public void a(Context context) {
        this.f36641f = new Path();
        this.f36642g = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f36640e) {
            this.f36641f.reset();
            this.f36642g.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f36644i;
            if (fArr != null) {
                this.f36641f.addRoundRect(this.f36642g, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f36641f);
            Paint paint = this.f36643h;
            if (paint != null) {
                canvas.drawPath(this.f36641f, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f36643h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f36643h.setColor(i2);
    }

    public void setClip(boolean z) {
        this.f36640e = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f36644i = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36640e = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36640e = true;
        a(context);
    }
}
