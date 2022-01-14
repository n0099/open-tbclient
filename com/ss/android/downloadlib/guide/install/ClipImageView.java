package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class ClipImageView extends ImageView {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Path f59688b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f59689c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f59690d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f59691e;

    public ClipImageView(Context context) {
        super(context);
        this.a = true;
        a(context);
    }

    public void a(Context context) {
        this.f59688b = new Path();
        this.f59689c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.a) {
            this.f59688b.reset();
            this.f59689c.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f59691e;
            if (fArr != null) {
                this.f59688b.addRoundRect(this.f59689c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f59688b);
            Paint paint = this.f59690d;
            if (paint != null) {
                canvas.drawPath(this.f59688b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f59690d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f59690d.setColor(i2);
    }

    public void setClip(boolean z) {
        this.a = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f59691e = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        a(context);
    }
}
