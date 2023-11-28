package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class KSCouponLabelTextView extends TextView implements d {
    public final Rect Al;
    public final RectF Am;
    public final RectF Ap;
    public float Ar;
    public float As;
    public float At;
    public final RectF Au;
    public final RectF Av;
    public final Path Aw;
    public Path Ax;
    public Path Ay;
    public boolean Az;
    public final Paint mPaint;
    @ColorInt
    public int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Al = new Rect();
        this.Am = new RectF();
        this.Au = new RectF();
        this.Av = new RectF();
        this.Aw = new Path();
        this.Ap = new RectF();
        this.Az = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Al = new Rect();
        this.Am = new RectF();
        this.Au = new RectF();
        this.Av = new RectF();
        this.Aw = new Path();
        this.Ap = new RectF();
        this.Az = true;
        a(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        if (this.Az) {
            int measuredWidth = getMeasuredWidth();
            if (getPaddingLeft() + getPaddingRight() + getPaint().measureText(getText().toString()) <= measuredWidth) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                setVisibility(8);
            }
        }
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Al = new Rect();
        this.Am = new RectF();
        this.Au = new RectF();
        this.Av = new RectF();
        this.Aw = new Path();
        this.Ap = new RectF();
        this.Az = true;
        a(context, attributeSet, i);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0607a6);
        this.Ar = obtainStyledAttributes.getDimension(0, 8.0f);
        this.As = obtainStyledAttributes.getDimension(3, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(2, color);
        this.At = obtainStyledAttributes.getDimension(1, 16.0f);
        obtainStyledAttributes.recycle();
        kb();
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.Ar;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.Ax, Path.Op.DIFFERENCE);
        path.op(this.Ay, Path.Op.DIFFERENCE);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.left;
        float f2 = this.At;
        float f3 = f - f2;
        rectF2.left = f3;
        rectF2.right = f3 + (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.At;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.right;
        float f2 = this.At;
        float f3 = f + f2;
        rectF2.right = f3;
        rectF2.left = f3 - (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.At;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.Ar);
        this.Ap.set(rectF);
        RectF rectF4 = this.Ap;
        float f = rectF4.top;
        float f2 = this.Ar;
        rectF4.bottom = f + (f2 * 2.0f);
        rectF4.right = rectF4.left + (f2 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.Ar, rectF.top);
        this.Ap.set(rectF);
        RectF rectF5 = this.Ap;
        float f3 = rectF5.right;
        float f4 = this.Ar;
        rectF5.left = f3 - (f4 * 2.0f);
        rectF5.bottom = rectF5.top + (f4 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.Ar);
        this.Ap.set(rectF);
        RectF rectF6 = this.Ap;
        float f5 = rectF6.right;
        float f6 = this.Ar;
        rectF6.left = f5 - (f6 * 2.0f);
        rectF6.top = rectF6.bottom - (f6 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Ar, rectF.bottom);
        this.Ap.set(rectF);
        RectF rectF7 = this.Ap;
        float f7 = rectF7.left;
        float f8 = this.Ar;
        rectF7.right = f7 + (f8 * 2.0f);
        rectF7.top = rectF7.bottom - (f8 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void kb() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.As);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0607a6);
        this.strokeColor = color;
        setTextColor(color);
        kb();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Al.setEmpty();
        getDrawingRect(this.Al);
        float f = this.As / 2.0f;
        this.Am.set(this.Al);
        RectF rectF = this.Am;
        rectF.left += f;
        rectF.top += f;
        rectF.right -= f;
        rectF.bottom -= f;
        a(rectF, this.Au);
        b(this.Am, this.Av);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.Ax;
            if (path == null) {
                this.Ax = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.Ay;
            if (path2 == null) {
                this.Ay = new Path();
            } else {
                path2.reset();
            }
            a(this.Aw, this.Ax, this.Ay, this.Am, this.Au, this.Av);
            canvas.drawPath(this.Aw, this.mPaint);
            return;
        }
        b(this.Aw, this.Am, this.Au, this.Av);
        canvas.drawPath(this.Aw, this.mPaint);
    }
}
