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
import com.win.opensdk.G;
import com.win.opensdk.R;
import com.win.opensdk.l;
import com.win.opensdk.n2;
import com.win.opensdk.o2;
/* loaded from: classes7.dex */
public class CircleProgressbar extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public int f40351a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f40352b;

    /* renamed from: c  reason: collision with root package name */
    public int f40353c;

    /* renamed from: d  reason: collision with root package name */
    public int f40354d;

    /* renamed from: e  reason: collision with root package name */
    public int f40355e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f40356f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f40357g;

    /* renamed from: h  reason: collision with root package name */
    public int f40358h;
    public o2 i;
    public long j;
    public final Rect k;
    public l l;
    public int m;
    public Runnable n;

    public CircleProgressbar(Context context) {
        this(context, null);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40351a = 2;
        this.f40352b = ColorStateList.valueOf(0);
        this.f40354d = -16776961;
        this.f40355e = 8;
        this.f40356f = new Paint();
        this.f40357g = new RectF();
        this.f40358h = 100;
        this.i = o2.COUNT_BACK;
        this.j = 3000L;
        this.k = new Rect();
        this.m = 0;
        this.n = new n2(this);
        a(context, attributeSet);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f40351a = 2;
        this.f40352b = ColorStateList.valueOf(0);
        this.f40354d = -16776961;
        this.f40355e = 8;
        this.f40356f = new Paint();
        this.f40357g = new RectF();
        this.f40358h = 100;
        this.i = o2.COUNT_BACK;
        this.j = 3000L;
        this.k = new Rect();
        this.m = 0;
        this.n = new n2(this);
        a(context, attributeSet);
    }

    public void a() {
        b();
        c();
    }

    public void a(int i, l lVar) {
        this.m = i;
        this.l = lVar;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f40356f.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressbar);
        this.f40352b = obtainStyledAttributes.hasValue(R.styleable.CircleProgressbar_win_in_circle_color) ? obtainStyledAttributes.getColorStateList(R.styleable.CircleProgressbar_win_in_circle_color) : ColorStateList.valueOf(0);
        this.f40353c = this.f40352b.getColorForState(getDrawableState(), 0);
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        int i;
        int ordinal = this.i.ordinal();
        if (ordinal == 0) {
            i = 0;
        } else if (ordinal != 1) {
            return;
        } else {
            i = 100;
        }
        this.f40358h = i;
    }

    public void c() {
        d();
        post(this.n);
    }

    public void d() {
        removeCallbacks(this.n);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int colorForState = this.f40352b.getColorForState(getDrawableState(), 0);
        if (this.f40353c != colorForState) {
            this.f40353c = colorForState;
            invalidate();
        }
    }

    public int getProgress() {
        return this.f40358h;
    }

    public o2 getProgressType() {
        return this.i;
    }

    public long getTimeMillis() {
        return this.j;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getDrawingRect(this.k);
        int width = this.k.height() > this.k.width() ? this.k.width() : this.k.height();
        int colorForState = this.f40352b.getColorForState(getDrawableState(), 0);
        this.f40356f.setStyle(Paint.Style.FILL);
        this.f40356f.setColor(colorForState);
        canvas.drawCircle(this.k.centerX(), this.k.centerY(), (width / 2) - this.f40351a, this.f40356f);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.k.centerX(), this.k.centerY() - ((paint.ascent() + paint.descent()) / 2.0f), paint);
        this.f40356f.setColor(this.f40354d);
        this.f40356f.setStyle(Paint.Style.STROKE);
        this.f40356f.setStrokeWidth(this.f40355e);
        this.f40356f.setAntiAlias(true);
        int i = this.f40355e;
        int i2 = this.f40351a;
        int i3 = i + i2;
        RectF rectF = this.f40357g;
        Rect rect = this.k;
        int i4 = i3 / 2;
        int i5 = (rect.top - i3) + i2 + i;
        Rect rect2 = this.k;
        rectF.set(rect.left + i4, G.a(getContext(), 0.4f) + i5, rect2.right - i4, (((rect2.bottom + i3) - this.f40351a) - this.f40355e) - G.a(getContext(), 0.5f));
        canvas.drawArc(this.f40357g, -90.0f, (this.f40358h * (-360)) / 100, false, this.f40356f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = (this.f40351a + this.f40355e) * 4;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        int i4 = measuredWidth + i3;
        setMeasuredDimension(i4, i4);
    }

    public void setInCircleColor(int i) {
        this.f40352b = ColorStateList.valueOf(i);
        invalidate();
    }

    public void setOutLineColor(int i) {
        invalidate();
    }

    public void setOutLineWidth(int i) {
        this.f40351a = i;
        invalidate();
    }

    public void setProgress(int i) {
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.f40358h = i;
        invalidate();
    }

    public void setProgressColor(int i) {
        this.f40354d = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.f40355e = i;
        invalidate();
    }

    public void setProgressType(o2 o2Var) {
        this.i = o2Var;
        b();
        invalidate();
    }

    public void setTimeMillis(long j) {
        this.j = j;
        invalidate();
    }
}
