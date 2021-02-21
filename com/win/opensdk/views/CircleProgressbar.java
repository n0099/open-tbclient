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
/* loaded from: classes3.dex */
public class CircleProgressbar extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f13761a;

    /* renamed from: b  reason: collision with root package name */
    private int f13762b;
    private int c;

    /* renamed from: case  reason: not valid java name */
    private int f72case;
    private int d;
    private int e;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private Ccase f73java;
    private long qjJ;
    private Runnable qkO;
    private ColorStateList qlA;
    private Paint qlB;
    private RectF qlC;
    final Rect qlD;
    private a qlE;

    /* loaded from: classes3.dex */
    public interface a {
        void eh(int i, int i2);
    }

    /* renamed from: com.win.opensdk.views.CircleProgressbar$case  reason: invalid class name */
    /* loaded from: classes3.dex */
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
        this.f72case = 2;
        this.qlA = ColorStateList.valueOf(0);
        this.f13762b = -16776961;
        this.c = 8;
        this.qlB = new Paint();
        this.qlC = new RectF();
        this.d = 100;
        this.f73java = Ccase.COUNT_BACK;
        this.qjJ = IMConnection.RETRY_DELAY_TIMES;
        this.qlD = new Rect();
        this.e = 0;
        this.qkO = new Runnable() { // from class: com.win.opensdk.views.CircleProgressbar.1
            @Override // java.lang.Runnable
            public final void run() {
                CircleProgressbar.this.removeCallbacks(this);
                switch (AnonymousClass2.java[CircleProgressbar.this.f73java.ordinal()]) {
                    case 1:
                        CircleProgressbar.this.d++;
                        break;
                    case 2:
                        CircleProgressbar.this.d--;
                        break;
                }
                if (CircleProgressbar.this.d >= 0 && CircleProgressbar.this.d <= 100) {
                    if (CircleProgressbar.this.qlE != null) {
                        CircleProgressbar.this.qlE.eh(CircleProgressbar.this.e, CircleProgressbar.this.d);
                    }
                    CircleProgressbar.this.invalidate();
                    CircleProgressbar.this.postDelayed(CircleProgressbar.this.qkO, CircleProgressbar.this.qjJ / 100);
                    return;
                }
                CircleProgressbar.this.d = CircleProgressbar.Si(CircleProgressbar.this.d);
            }
        };
        o(context, attributeSet);
    }

    private void o(Context context, AttributeSet attributeSet) {
        this.qlB.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f.CircleProgressbar);
        if (obtainStyledAttributes.hasValue(d.f.CircleProgressbar_win_in_circle_color)) {
            this.qlA = obtainStyledAttributes.getColorStateList(d.f.CircleProgressbar_win_in_circle_color);
        } else {
            this.qlA = ColorStateList.valueOf(0);
        }
        this.f13761a = this.qlA.getColorForState(getDrawableState(), 0);
        obtainStyledAttributes.recycle();
    }

    public void setOutLineColor(@ColorInt int i) {
        this.java = i;
        invalidate();
    }

    public void setOutLineWidth(@ColorInt int i) {
        this.f72case = i;
        invalidate();
    }

    public void setInCircleColor(@ColorInt int i) {
        this.qlA = ColorStateList.valueOf(i);
        invalidate();
    }

    public void setProgressColor(@ColorInt int i) {
        this.f13762b = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.c = i;
        invalidate();
    }

    public void setProgress(int i) {
        this.d = Si(i);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int Si(int i) {
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
        this.qjJ = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.qjJ;
    }

    public void setProgressType(Ccase ccase) {
        this.f73java = ccase;
        eIY();
        invalidate();
    }

    private void eIY() {
        switch (this.f73java) {
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
        return this.f73java;
    }

    public final void setCountdownProgressListener$6c60c32f(a aVar) {
        this.e = 1;
        this.qlE = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.qlD);
        int width = this.qlD.height() > this.qlD.width() ? this.qlD.width() : this.qlD.height();
        int colorForState = this.qlA.getColorForState(getDrawableState(), 0);
        this.qlB.setStyle(Paint.Style.FILL);
        this.qlB.setColor(colorForState);
        canvas.drawCircle(this.qlD.centerX(), this.qlD.centerY(), (width / 2) - this.f72case, this.qlB);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.qlD.centerX(), this.qlD.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.qlB.setColor(this.f13762b);
        this.qlB.setStyle(Paint.Style.STROKE);
        this.qlB.setStrokeWidth(this.c);
        this.qlB.setAntiAlias(true);
        int i = this.c + this.f72case;
        this.qlC.set(this.qlD.left + (i / 2), (this.qlD.top - i) + this.f72case + this.c + bg.k(getContext(), 0.4f), this.qlD.right - (i / 2), (((i + this.qlD.bottom) - this.f72case) - this.c) - bg.k(getContext(), 0.5f));
        canvas.drawArc(this.qlC, -90.0f, (this.d * (-360)) / 100, false, this.qlB);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = (this.f72case + this.c) * 4;
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
        int colorForState = this.qlA.getColorForState(getDrawableState(), 0);
        if (this.f13761a == colorForState) {
            return;
        }
        this.f13761a = colorForState;
        invalidate();
    }
}
