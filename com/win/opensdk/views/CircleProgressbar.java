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
import com.win.opensdk.J1;
import com.win.opensdk.K1;
import com.win.opensdk.R;
import com.win.opensdk.l;
import com.win.opensdk.z;
/* loaded from: classes7.dex */
public class CircleProgressbar extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public int f40918a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f40919b;

    /* renamed from: c  reason: collision with root package name */
    public int f40920c;

    /* renamed from: d  reason: collision with root package name */
    public int f40921d;

    /* renamed from: e  reason: collision with root package name */
    public int f40922e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f40923f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f40924g;

    /* renamed from: h  reason: collision with root package name */
    public int f40925h;

    /* renamed from: i  reason: collision with root package name */
    public K1 f40926i;
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

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f40918a = 2;
        this.f40919b = ColorStateList.valueOf(0);
        this.f40921d = -16776961;
        this.f40922e = 8;
        this.f40923f = new Paint();
        this.f40924g = new RectF();
        this.f40925h = 100;
        this.f40926i = K1.COUNT_BACK;
        this.j = 3000L;
        this.k = new Rect();
        this.m = 0;
        this.n = new J1(this);
        a(context, attributeSet);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f40918a = 2;
        this.f40919b = ColorStateList.valueOf(0);
        this.f40921d = -16776961;
        this.f40922e = 8;
        this.f40923f = new Paint();
        this.f40924g = new RectF();
        this.f40925h = 100;
        this.f40926i = K1.COUNT_BACK;
        this.j = 3000L;
        this.k = new Rect();
        this.m = 0;
        this.n = new J1(this);
        a(context, attributeSet);
    }

    public void a() {
        b();
        c();
    }

    public void a(int i2, l lVar) {
        this.m = i2;
        this.l = lVar;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f40923f.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.win_CircleProgressbar);
        this.f40919b = obtainStyledAttributes.hasValue(R.styleable.win_CircleProgressbar_win_in_circle_color) ? obtainStyledAttributes.getColorStateList(R.styleable.win_CircleProgressbar_win_in_circle_color) : ColorStateList.valueOf(0);
        this.f40920c = this.f40919b.getColorForState(getDrawableState(), 0);
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        int i2;
        int ordinal = this.f40926i.ordinal();
        if (ordinal == 0) {
            i2 = 0;
        } else if (ordinal != 1) {
            return;
        } else {
            i2 = 100;
        }
        this.f40925h = i2;
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
        int colorForState = this.f40919b.getColorForState(getDrawableState(), 0);
        if (this.f40920c != colorForState) {
            this.f40920c = colorForState;
            invalidate();
        }
    }

    public int getProgress() {
        return this.f40925h;
    }

    public K1 getProgressType() {
        return this.f40926i;
    }

    public long getTimeMillis() {
        return this.j;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getDrawingRect(this.k);
        int width = this.k.height() > this.k.width() ? this.k.width() : this.k.height();
        int colorForState = this.f40919b.getColorForState(getDrawableState(), 0);
        this.f40923f.setStyle(Paint.Style.FILL);
        this.f40923f.setColor(colorForState);
        canvas.drawCircle(this.k.centerX(), this.k.centerY(), (width / 2) - this.f40918a, this.f40923f);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.k.centerX(), this.k.centerY() - ((paint.ascent() + paint.descent()) / 2.0f), paint);
        this.f40923f.setColor(this.f40921d);
        this.f40923f.setStyle(Paint.Style.STROKE);
        this.f40923f.setStrokeWidth(this.f40922e);
        this.f40923f.setAntiAlias(true);
        int i2 = this.f40922e;
        int i3 = this.f40918a;
        int i4 = i2 + i3;
        RectF rectF = this.f40924g;
        Rect rect = this.k;
        int i5 = i4 / 2;
        int i6 = (rect.top - i4) + i3 + i2;
        Rect rect2 = this.k;
        rectF.set(rect.left + i5, z.a(getContext(), 0.4f) + i6, rect2.right - i5, (((rect2.bottom + i4) - this.f40918a) - this.f40922e) - z.a(getContext(), 0.5f));
        canvas.drawArc(this.f40924g, -90.0f, (this.f40925h * (-360)) / 100, false, this.f40923f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = (this.f40918a + this.f40922e) * 4;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        int i5 = measuredWidth + i4;
        setMeasuredDimension(i5, i5);
    }

    public void setInCircleColor(int i2) {
        this.f40919b = ColorStateList.valueOf(i2);
        invalidate();
    }

    public void setOutLineColor(int i2) {
        invalidate();
    }

    public void setOutLineWidth(int i2) {
        this.f40918a = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f40925h = i2;
        invalidate();
    }

    public void setProgressColor(int i2) {
        this.f40921d = i2;
        invalidate();
    }

    public void setProgressLineWidth(int i2) {
        this.f40922e = i2;
        invalidate();
    }

    public void setProgressType(K1 k1) {
        this.f40926i = k1;
        b();
        invalidate();
    }

    public void setTimeMillis(long j) {
        this.j = j;
        invalidate();
    }
}
