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
    public int f37136a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f37137b;

    /* renamed from: c  reason: collision with root package name */
    public int f37138c;

    /* renamed from: d  reason: collision with root package name */
    public int f37139d;

    /* renamed from: e  reason: collision with root package name */
    public int f37140e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f37141f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f37142g;

    /* renamed from: h  reason: collision with root package name */
    public int f37143h;

    /* renamed from: i  reason: collision with root package name */
    public K1 f37144i;
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
        this.f37136a = 2;
        this.f37137b = ColorStateList.valueOf(0);
        this.f37139d = -16776961;
        this.f37140e = 8;
        this.f37141f = new Paint();
        this.f37142g = new RectF();
        this.f37143h = 100;
        this.f37144i = K1.COUNT_BACK;
        this.j = 3000L;
        this.k = new Rect();
        this.m = 0;
        this.n = new J1(this);
        a(context, attributeSet);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f37136a = 2;
        this.f37137b = ColorStateList.valueOf(0);
        this.f37139d = -16776961;
        this.f37140e = 8;
        this.f37141f = new Paint();
        this.f37142g = new RectF();
        this.f37143h = 100;
        this.f37144i = K1.COUNT_BACK;
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
        this.f37141f.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.win_CircleProgressbar);
        this.f37137b = obtainStyledAttributes.hasValue(R.styleable.win_CircleProgressbar_win_in_circle_color) ? obtainStyledAttributes.getColorStateList(R.styleable.win_CircleProgressbar_win_in_circle_color) : ColorStateList.valueOf(0);
        this.f37138c = this.f37137b.getColorForState(getDrawableState(), 0);
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        int i2;
        int ordinal = this.f37144i.ordinal();
        if (ordinal == 0) {
            i2 = 0;
        } else if (ordinal != 1) {
            return;
        } else {
            i2 = 100;
        }
        this.f37143h = i2;
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
        int colorForState = this.f37137b.getColorForState(getDrawableState(), 0);
        if (this.f37138c != colorForState) {
            this.f37138c = colorForState;
            invalidate();
        }
    }

    public int getProgress() {
        return this.f37143h;
    }

    public K1 getProgressType() {
        return this.f37144i;
    }

    public long getTimeMillis() {
        return this.j;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        getDrawingRect(this.k);
        int width = this.k.height() > this.k.width() ? this.k.width() : this.k.height();
        int colorForState = this.f37137b.getColorForState(getDrawableState(), 0);
        this.f37141f.setStyle(Paint.Style.FILL);
        this.f37141f.setColor(colorForState);
        canvas.drawCircle(this.k.centerX(), this.k.centerY(), (width / 2) - this.f37136a, this.f37141f);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.k.centerX(), this.k.centerY() - ((paint.ascent() + paint.descent()) / 2.0f), paint);
        this.f37141f.setColor(this.f37139d);
        this.f37141f.setStyle(Paint.Style.STROKE);
        this.f37141f.setStrokeWidth(this.f37140e);
        this.f37141f.setAntiAlias(true);
        int i2 = this.f37140e;
        int i3 = this.f37136a;
        int i4 = i2 + i3;
        RectF rectF = this.f37142g;
        Rect rect = this.k;
        int i5 = i4 / 2;
        int i6 = (rect.top - i4) + i3 + i2;
        Rect rect2 = this.k;
        rectF.set(rect.left + i5, z.a(getContext(), 0.4f) + i6, rect2.right - i5, (((rect2.bottom + i4) - this.f37136a) - this.f37140e) - z.a(getContext(), 0.5f));
        canvas.drawArc(this.f37142g, -90.0f, (this.f37143h * (-360)) / 100, false, this.f37141f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = (this.f37136a + this.f37140e) * 4;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        int i5 = measuredWidth + i4;
        setMeasuredDimension(i5, i5);
    }

    public void setInCircleColor(int i2) {
        this.f37137b = ColorStateList.valueOf(i2);
        invalidate();
    }

    public void setOutLineColor(int i2) {
        invalidate();
    }

    public void setOutLineWidth(int i2) {
        this.f37136a = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f37143h = i2;
        invalidate();
    }

    public void setProgressColor(int i2) {
        this.f37139d = i2;
        invalidate();
    }

    public void setProgressLineWidth(int i2) {
        this.f37140e = i2;
        invalidate();
    }

    public void setProgressType(K1 k1) {
        this.f37144i = k1;
        b();
        invalidate();
    }

    public void setTimeMillis(long j) {
        this.j = j;
        invalidate();
    }
}
