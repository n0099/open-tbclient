package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.ao;
/* loaded from: classes4.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f9528a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f9529b;
    private Path c;

    public d(Context context) {
        this(context, null);
        setLayerType(1, null);
        this.f9528a = ao.a(context, 4.0f);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setLayerType(1, null);
        this.f9528a = ao.a(context, 4.0f);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(1, null);
        this.f9528a = ao.a(context, 4.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        if (this.f9529b == null) {
            this.c = new Path();
            this.f9529b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            this.f9529b.right = canvas.getWidth();
            this.f9529b.bottom = canvas.getHeight();
            this.c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        fArr[0] = this.f9528a;
        fArr[1] = this.f9528a;
        fArr[2] = this.f9528a;
        fArr[3] = this.f9528a;
        fArr[4] = this.f9528a;
        fArr[5] = this.f9528a;
        fArr[6] = this.f9528a;
        fArr[7] = this.f9528a;
        this.c.addRoundRect(this.f9529b, fArr, Path.Direction.CW);
        canvas.clipPath(this.c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public float getRadius() {
        return this.f9528a;
    }

    public void setRadius(float f) {
        this.f9528a = f;
        invalidate();
    }
}
