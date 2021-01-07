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
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.IMConnection;
import com.win.opensdk.bg;
import com.win.opensdk.d;
/* loaded from: classes4.dex */
public class CircleProgressbar extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f14059a;

    /* renamed from: b  reason: collision with root package name */
    private int f14060b;
    private int c;

    /* renamed from: case  reason: not valid java name */
    private int f73case;
    private int d;
    private int e;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private Ccase f74java;
    private long qdF;
    private Runnable qeK;
    private a qfA;
    private ColorStateList qfw;
    private Paint qfx;
    private RectF qfy;
    final Rect qfz;

    /* loaded from: classes4.dex */
    public interface a {
        void ej(int i, int i2);
    }

    /* renamed from: com.win.opensdk.views.CircleProgressbar$case  reason: invalid class name */
    /* loaded from: classes4.dex */
    public enum Ccase {
        COUNT,
        COUNT_BACK
    }

    public CircleProgressbar(Context context) {
        this(context, null);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.java = ViewCompat.MEASURED_STATE_MASK;
        this.f73case = 2;
        this.qfw = ColorStateList.valueOf(0);
        this.f14060b = -16776961;
        this.c = 8;
        this.qfx = new Paint();
        this.qfy = new RectF();
        this.d = 100;
        this.f74java = Ccase.COUNT_BACK;
        this.qdF = IMConnection.RETRY_DELAY_TIMES;
        this.qfz = new Rect();
        this.e = 0;
        this.qeK = new Runnable() { // from class: com.win.opensdk.views.CircleProgressbar.1
            @Override // java.lang.Runnable
            public final void run() {
                CircleProgressbar.this.removeCallbacks(this);
                switch (AnonymousClass2.java[CircleProgressbar.this.f74java.ordinal()]) {
                    case 1:
                        CircleProgressbar.this.d++;
                        break;
                    case 2:
                        CircleProgressbar.this.d--;
                        break;
                }
                if (CircleProgressbar.this.d >= 0 && CircleProgressbar.this.d <= 100) {
                    if (CircleProgressbar.this.qfA != null) {
                        CircleProgressbar.this.qfA.ej(CircleProgressbar.this.e, CircleProgressbar.this.d);
                    }
                    CircleProgressbar.this.invalidate();
                    CircleProgressbar.this.postDelayed(CircleProgressbar.this.qeK, CircleProgressbar.this.qdF / 100);
                    return;
                }
                CircleProgressbar.this.d = CircleProgressbar.Tt(CircleProgressbar.this.d);
            }
        };
        o(context, attributeSet);
    }

    private void o(Context context, AttributeSet attributeSet) {
        this.qfx.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f.CircleProgressbar);
        if (obtainStyledAttributes.hasValue(d.f.CircleProgressbar_win_in_circle_color)) {
            this.qfw = obtainStyledAttributes.getColorStateList(d.f.CircleProgressbar_win_in_circle_color);
        } else {
            this.qfw = ColorStateList.valueOf(0);
        }
        this.f14059a = this.qfw.getColorForState(getDrawableState(), 0);
        obtainStyledAttributes.recycle();
    }

    public void setOutLineColor(@ColorInt int i) {
        this.java = i;
        invalidate();
    }

    public void setOutLineWidth(@ColorInt int i) {
        this.f73case = i;
        invalidate();
    }

    public void setInCircleColor(@ColorInt int i) {
        this.qfw = ColorStateList.valueOf(i);
        invalidate();
    }

    public void setProgressColor(@ColorInt int i) {
        this.f14060b = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.c = i;
        invalidate();
    }

    public void setProgress(int i) {
        this.d = Tt(i);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int Tt(int i) {
        if (i > 100) {
            return 100;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int getProgress() {
        return this.d;
    }

    public void setTimeMillis(long j) {
        this.qdF = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.qdF;
    }

    public void setProgressType(Ccase ccase) {
        this.f74java = ccase;
        eKq();
        invalidate();
    }

    private void eKq() {
        switch (this.f74java) {
            case COUNT:
                this.d = 0;
                return;
            case COUNT_BACK:
                this.d = 100;
                return;
            default:
                return;
        }
    }

    public Ccase getProgressType() {
        return this.f74java;
    }

    public final void setCountdownProgressListener$6c60c32f(a aVar) {
        this.e = 1;
        this.qfA = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.qfz);
        int width = this.qfz.height() > this.qfz.width() ? this.qfz.width() : this.qfz.height();
        int colorForState = this.qfw.getColorForState(getDrawableState(), 0);
        this.qfx.setStyle(Paint.Style.FILL);
        this.qfx.setColor(colorForState);
        canvas.drawCircle(this.qfz.centerX(), this.qfz.centerY(), (width / 2) - this.f73case, this.qfx);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.qfz.centerX(), this.qfz.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.qfx.setColor(this.f14060b);
        this.qfx.setStyle(Paint.Style.STROKE);
        this.qfx.setStrokeWidth(this.c);
        this.qfx.setAntiAlias(true);
        int i = this.c + this.f73case;
        this.qfy.set(this.qfz.left + (i / 2), (this.qfz.top - i) + this.f73case + this.c + bg.k(getContext(), 0.4f), this.qfz.right - (i / 2), (((i + this.qfz.bottom) - this.f73case) - this.c) - bg.k(getContext(), 0.5f));
        canvas.drawArc(this.qfy, -90.0f, (this.d * (-360)) / 100, false, this.qfx);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = (this.f73case + this.c) * 4;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        int i4 = measuredWidth + i3;
        setMeasuredDimension(i4, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int colorForState = this.qfw.getColorForState(getDrawableState(), 0);
        if (this.f14059a == colorForState) {
            return;
        }
        this.f14059a = colorForState;
        invalidate();
    }
}
