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
    private int f13759a;

    /* renamed from: b  reason: collision with root package name */
    private int f13760b;
    private int c;

    /* renamed from: case  reason: not valid java name */
    private int f72case;
    private int d;
    private int e;
    private int java;

    /* renamed from: java  reason: collision with other field name */
    private Ccase f73java;
    private long pZf;
    private ColorStateList qaW;
    private Paint qaX;
    private RectF qaY;
    final Rect qaZ;
    private Runnable qak;
    private a qba;

    /* loaded from: classes3.dex */
    public interface a {
        void ej(int i, int i2);
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
        this.qaW = ColorStateList.valueOf(0);
        this.f13760b = -16776961;
        this.c = 8;
        this.qaX = new Paint();
        this.qaY = new RectF();
        this.d = 100;
        this.f73java = Ccase.COUNT_BACK;
        this.pZf = IMConnection.RETRY_DELAY_TIMES;
        this.qaZ = new Rect();
        this.e = 0;
        this.qak = new Runnable() { // from class: com.win.opensdk.views.CircleProgressbar.1
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
                    if (CircleProgressbar.this.qba != null) {
                        CircleProgressbar.this.qba.ej(CircleProgressbar.this.e, CircleProgressbar.this.d);
                    }
                    CircleProgressbar.this.invalidate();
                    CircleProgressbar.this.postDelayed(CircleProgressbar.this.qak, CircleProgressbar.this.pZf / 100);
                    return;
                }
                CircleProgressbar.this.d = CircleProgressbar.RM(CircleProgressbar.this.d);
            }
        };
        o(context, attributeSet);
    }

    private void o(Context context, AttributeSet attributeSet) {
        this.qaX.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f.CircleProgressbar);
        if (obtainStyledAttributes.hasValue(d.f.CircleProgressbar_win_in_circle_color)) {
            this.qaW = obtainStyledAttributes.getColorStateList(d.f.CircleProgressbar_win_in_circle_color);
        } else {
            this.qaW = ColorStateList.valueOf(0);
        }
        this.f13759a = this.qaW.getColorForState(getDrawableState(), 0);
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
        this.qaW = ColorStateList.valueOf(i);
        invalidate();
    }

    public void setProgressColor(@ColorInt int i) {
        this.f13760b = i;
        invalidate();
    }

    public void setProgressLineWidth(int i) {
        this.c = i;
        invalidate();
    }

    public void setProgress(int i) {
        this.d = RM(i);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int RM(int i) {
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
        this.pZf = j;
        invalidate();
    }

    public long getTimeMillis() {
        return this.pZf;
    }

    public void setProgressType(Ccase ccase) {
        this.f73java = ccase;
        eGA();
        invalidate();
    }

    private void eGA() {
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
        this.qba = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.qaZ);
        int width = this.qaZ.height() > this.qaZ.width() ? this.qaZ.width() : this.qaZ.height();
        int colorForState = this.qaW.getColorForState(getDrawableState(), 0);
        this.qaX.setStyle(Paint.Style.FILL);
        this.qaX.setColor(colorForState);
        canvas.drawCircle(this.qaZ.centerX(), this.qaZ.centerY(), (width / 2) - this.f72case, this.qaX);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.qaZ.centerX(), this.qaZ.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.qaX.setColor(this.f13760b);
        this.qaX.setStyle(Paint.Style.STROKE);
        this.qaX.setStrokeWidth(this.c);
        this.qaX.setAntiAlias(true);
        int i = this.c + this.f72case;
        this.qaY.set(this.qaZ.left + (i / 2), (this.qaZ.top - i) + this.f72case + this.c + bg.k(getContext(), 0.4f), this.qaZ.right - (i / 2), (((i + this.qaZ.bottom) - this.f72case) - this.c) - bg.k(getContext(), 0.5f));
        canvas.drawArc(this.qaY, -90.0f, (this.d * (-360)) / 100, false, this.qaX);
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
        int colorForState = this.qaW.getColorForState(getDrawableState(), 0);
        if (this.f13759a == colorForState) {
            return;
        }
        this.f13759a = colorForState;
        invalidate();
    }
}
