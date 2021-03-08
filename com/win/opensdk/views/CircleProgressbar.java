package com.win.opensdk.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.win.opensdk.bd;
import com.win.opensdk.di;
import com.win.opensdk.dr;
import com.win.opensdk.o2;
import com.win.opensdk.v;
/* loaded from: classes14.dex */
public class CircleProgressbar extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public int f8175a;
    public int c;
    public int d;
    public int e;
    public Paint f;
    public RectF g;
    public int h;
    public long j;
    public int m;
    public Runnable n;
    public ColorStateList qmo;
    public o2 qmp;
    public final Rect qmq;
    public di qmr;

    public CircleProgressbar(Context context) {
        this(context, null);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8175a = 2;
        this.qmo = ColorStateList.valueOf(0);
        this.d = -16776961;
        this.e = 8;
        this.f = new Paint();
        this.g = new RectF();
        this.h = 100;
        this.qmp = o2.COUNT_BACK;
        this.j = IMConnection.RETRY_DELAY_TIMES;
        this.qmq = new Rect();
        this.m = 0;
        this.n = new dr(this);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bd.f.CircleProgressbar);
        if (obtainStyledAttributes.hasValue(bd.f.CircleProgressbar_win_in_circle_color)) {
            this.qmo = obtainStyledAttributes.getColorStateList(bd.f.CircleProgressbar_win_in_circle_color);
        } else {
            this.qmo = ColorStateList.valueOf(0);
        }
        this.c = this.qmo.getColorForState(getDrawableState(), 0);
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        int ordinal = this.qmp.ordinal();
        if (ordinal == 0) {
            this.h = 0;
        } else if (ordinal != 1) {
        } else {
            this.h = 100;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int colorForState = this.qmo.getColorForState(getDrawableState(), 0);
        if (this.c != colorForState) {
            this.c = colorForState;
            invalidate();
        }
    }

    public int getProgress() {
        return this.h;
    }

    public o2 getProgressType() {
        return this.qmp;
    }

    public long getTimeMillis() {
        return this.j;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getDrawingRect(this.qmq);
        int width = this.qmq.height() > this.qmq.width() ? this.qmq.width() : this.qmq.height();
        int colorForState = this.qmo.getColorForState(getDrawableState(), 0);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(colorForState);
        canvas.drawCircle(this.qmq.centerX(), this.qmq.centerY(), (width / 2) - this.f8175a, this.f);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.qmq.centerX(), this.qmq.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.f.setColor(this.d);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(this.e);
        this.f.setAntiAlias(true);
        int i = this.e;
        int i2 = this.f8175a;
        int i3 = i + i2;
        RectF rectF = this.g;
        Rect rect = this.qmq;
        int i4 = i3 / 2;
        Rect rect2 = this.qmq;
        rectF.set(rect.left + i4, i + i2 + (rect.top - i3) + v.a(getContext(), 0.4f), rect2.right - i4, (((rect2.bottom + i3) - this.f8175a) - this.e) - v.a(getContext(), 0.5f));
        canvas.drawArc(this.g, -90.0f, (this.h * (-360)) / 100, false, this.f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = (this.f8175a + this.e) * 4;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        int i4 = measuredWidth + i3;
        setMeasuredDimension(i4, i4);
    }

    public void setInCircleColor(int i) {
        this.qmo = ColorStateList.valueOf(i);
        invalidate();
    }

    public void setOutLineColor(int i) {
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.f8175a = i;
        invalidate();
    }

    public void setProgress(int i) {
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.h = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.e = i;
        invalidate();
    }

    public void setProgressType(o2 o2Var) {
        this.qmp = o2Var;
        b();
        invalidate();
    }

    public void setTimeMillis(long j) {
        this.j = j;
        invalidate();
    }
}
