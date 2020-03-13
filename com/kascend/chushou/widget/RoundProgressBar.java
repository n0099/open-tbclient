package com.kascend.chushou.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.kascend.chushou.a;
/* loaded from: classes5.dex */
public class RoundProgressBar extends View {
    private Paint a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private final RectF nhr;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nhr = new RectF();
        this.a = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.RoundProgressBar);
        this.b = obtainStyledAttributes.getColor(a.k.RoundProgressBar_roundColor, SupportMenu.CATEGORY_MASK);
        this.c = obtainStyledAttributes.getColor(a.k.RoundProgressBar_roundProgressColor, -16711936);
        this.d = obtainStyledAttributes.getColor(a.k.RoundProgressBar_textColor, -16711936);
        this.e = obtainStyledAttributes.getDimension(a.k.RoundProgressBar_textSize, 15.0f);
        this.f = obtainStyledAttributes.getDimension(a.k.RoundProgressBar_roundWidth, 3.0f);
        this.g = obtainStyledAttributes.getInteger(a.k.RoundProgressBar_max, 100);
        this.i = obtainStyledAttributes.getBoolean(a.k.RoundProgressBar_textIsDisplayable, true);
        this.j = obtainStyledAttributes.getInt(a.k.RoundProgressBar_style, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i = (int) (width - (this.f / 2.0f));
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f);
        this.a.setAntiAlias(true);
        canvas.drawCircle(width, width, i, this.a);
        this.a.setStrokeWidth(0.0f);
        this.a.setColor(this.d);
        this.a.setTextSize(this.e);
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        int i2 = (int) ((this.h / this.g) * 100.0f);
        float measureText = this.a.measureText(i2 + "%");
        if (this.i && i2 != 0 && this.j == 0) {
            canvas.drawText(i2 + "%", width - (measureText / 2.0f), width + (this.e / 2.0f), this.a);
        }
        this.a.setStrokeWidth(this.f);
        this.a.setColor(this.c);
        this.nhr.set(width - i, width - i, width + i, width + i);
        switch (this.j) {
            case 0:
                this.a.setStyle(Paint.Style.STROKE);
                canvas.drawArc(this.nhr, 90.0f, (this.h * 360) / this.g, false, this.a);
                return;
            case 1:
                this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.h != 0) {
                    canvas.drawArc(this.nhr, 90.0f, (this.h * 360) / this.g, true, this.a);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public synchronized int getMax() {
        return this.g;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.g = i;
    }

    public synchronized int getProgress() {
        return this.h;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.g) {
            i = this.g;
        }
        if (i <= this.g) {
            this.h = i;
            postInvalidate();
        }
    }

    public void setProgressOnUIThread(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.g) {
            i = this.g;
        }
        if (i <= this.g) {
            this.h = i;
            invalidate();
        }
    }

    public int getCricleColor() {
        return this.b;
    }

    public void setCricleColor(int i) {
        this.b = i;
    }

    public int getCricleProgressColor() {
        return this.c;
    }

    public void setCricleProgressColor(int i) {
        this.c = i;
    }

    public int getTextColor() {
        return this.d;
    }

    public void setTextColor(int i) {
        this.d = i;
    }

    public float getTextSize() {
        return this.e;
    }

    public void setTextSize(float f) {
        this.e = f;
    }

    public float getRoundWidth() {
        return this.f;
    }

    public void setRoundWidth(float f) {
        this.f = f;
    }

    public void setRoundColor(int i) {
        this.b = i;
        postInvalidate();
    }

    public void setRoundProgressColor(int i) {
        this.c = i;
        postInvalidate();
    }
}
