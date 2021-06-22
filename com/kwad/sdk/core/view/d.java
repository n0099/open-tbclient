package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public float f35000a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f35001b;

    /* renamed from: c  reason: collision with root package name */
    public Path f35002c;

    public d(Context context) {
        this(context, null);
        setLayerType(1, null);
        this.f35000a = ao.a(context, 4.0f);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setLayerType(1, null);
        this.f35000a = ao.a(context, 4.0f);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayerType(1, null);
        this.f35000a = ao.a(context, 4.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        RectF rectF = this.f35001b;
        if (rectF == null) {
            this.f35002c = new Path();
            this.f35001b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.f35001b.bottom = canvas.getHeight();
            this.f35002c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.f35000a;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        this.f35002c.addRoundRect(this.f35001b, fArr, Path.Direction.CW);
        canvas.clipPath(this.f35002c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float getRadius() {
        return this.f35000a;
    }

    public void setRadius(float f2) {
        this.f35000a = f2;
        invalidate();
    }
}
