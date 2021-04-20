package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public float f34549a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f34550b;

    /* renamed from: c  reason: collision with root package name */
    public Path f34551c;

    public d(Context context) {
        this(context, null);
        setLayerType(1, null);
        this.f34549a = ao.a(context, 4.0f);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setLayerType(1, null);
        this.f34549a = ao.a(context, 4.0f);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(1, null);
        this.f34549a = ao.a(context, 4.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        RectF rectF = this.f34550b;
        if (rectF == null) {
            this.f34551c = new Path();
            this.f34550b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.f34550b.bottom = canvas.getHeight();
            this.f34551c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.f34549a;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        this.f34551c.addRoundRect(this.f34550b, fArr, Path.Direction.CW);
        canvas.clipPath(this.f34551c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float getRadius() {
        return this.f34549a;
    }

    public void setRadius(float f2) {
        this.f34549a = f2;
        invalidate();
    }
}
