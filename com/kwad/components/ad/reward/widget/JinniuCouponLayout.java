package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
/* loaded from: classes8.dex */
public class JinniuCouponLayout extends LinearLayout {
    @ColorInt
    public int endColor;
    public Paint mPaint;
    @ColorInt
    public int startColor;
    public float wl;
    public float wm;
    public Rect wn;
    public RectF wo;
    public RectF wp;
    public RectF wq;
    public RectF wr;
    public Path ws;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.wl = 4.0f;
        this.wm = 10.0f;
        this.wn = new Rect();
        this.wo = new RectF();
        this.wp = new RectF();
        this.wq = new RectF();
        this.wr = new RectF();
        this.ws = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.wl = 4.0f;
        this.wm = 10.0f;
        this.wn = new Rect();
        this.wo = new RectF();
        this.wp = new RectF();
        this.wq = new RectF();
        this.wr = new RectF();
        this.ws = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.wl = 4.0f;
        this.wm = 10.0f;
        this.wn = new Rect();
        this.wo = new RectF();
        this.wp = new RectF();
        this.wq = new RectF();
        this.wr = new RectF();
        this.ws = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.wl = 4.0f;
        this.wm = 10.0f;
        this.wn = new Rect();
        this.wo = new RectF();
        this.wp = new RectF();
        this.wq = new RectF();
        this.wr = new RectF();
        this.ws = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i, 0);
        this.wm = obtainStyledAttributes.getDimension(0, 4.0f);
        this.wl = obtainStyledAttributes.getDimension(1, 10.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        RectF rectF4 = this.wo;
        path.moveTo(rectF4.left, rectF4.top + this.wm);
        this.wr.set(rectF);
        RectF rectF5 = this.wr;
        float f = rectF5.top;
        float f2 = this.wm;
        rectF5.bottom = f + (f2 * 2.0f);
        rectF5.right = rectF5.left + (f2 * 2.0f);
        path.arcTo(rectF5, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.wm, rectF.top);
        this.wr.set(rectF);
        RectF rectF6 = this.wr;
        float f3 = rectF6.right;
        float f4 = this.wm;
        rectF6.left = f3 - (f4 * 2.0f);
        rectF6.bottom = rectF6.top + (f4 * 2.0f);
        path.arcTo(rectF6, 270.0f, 90.0f);
        this.wr.set(rectF);
        RectF rectF7 = this.wr;
        float f5 = rectF7.right;
        float f6 = this.wm;
        rectF7.left = f5 - (f6 * 2.0f);
        rectF7.top = rectF7.bottom - (f6 * 2.0f);
        path.arcTo(rectF7, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.wm, rectF.bottom);
        this.wr.set(rectF);
        RectF rectF8 = this.wr;
        float f7 = rectF8.left;
        float f8 = this.wm;
        rectF8.right = f7 + (f8 * 2.0f);
        rectF8.top = rectF8.bottom - (f8 * 2.0f);
        path.arcTo(rectF8, 90.0f, 90.0f);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.wn.setEmpty();
        getDrawingRect(this.wn);
        this.wo.set(this.wn);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.wp;
            if (rectF == null) {
                this.wp = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.wq;
            if (rectF2 == null) {
                this.wq = new RectF();
            } else {
                rectF2.setEmpty();
            }
            Rect rect = this.wn;
            float measuredWidth = rect.left + childAt.getMeasuredWidth();
            RectF rectF3 = this.wp;
            int i = rect.top;
            float f = this.wl;
            rectF3.set(measuredWidth, i - f, (2.0f * f) + measuredWidth, i + f);
            RectF rectF4 = this.wq;
            RectF rectF5 = this.wp;
            float f2 = rectF5.left;
            int i2 = this.wn.bottom;
            float f3 = this.wl;
            rectF4.set(f2, i2 - f3, rectF5.right, i2 + f3);
            a(this.ws, this.wo, this.wp, this.wq);
            setGradientPaint(this.wo);
            canvas.drawPath(this.ws, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }
}
