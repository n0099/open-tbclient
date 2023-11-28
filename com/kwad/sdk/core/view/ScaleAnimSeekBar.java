package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class ScaleAnimSeekBar extends View {
    public Paint aBN;
    public int aBO;
    public int aBP;
    public int aBQ;
    public int aBR;
    public int aBS;
    public int aBT;
    public int aBU;
    public int aBV;
    public boolean aBW;
    public int aBX;
    public int aBY;
    public int aBZ;
    public float aCA;
    public int aCB;
    public boolean aCC;
    public int aCa;
    public int aCb;
    public int aCc;
    public int aCd;
    public GradientDrawable aCe;
    public GradientDrawable aCf;
    public GradientDrawable aCg;
    public Rect aCh;
    public Rect aCi;
    public Rect aCj;
    public Rect aCk;
    public Drawable aCl;
    public boolean aCm;
    public boolean aCn;
    public boolean aCo;
    public boolean aCp;
    public boolean aCq;
    public WeakReference<a> aCr;
    public boolean aCs;
    public boolean aCt;
    public ValueAnimator aCu;
    public ValueAnimator aCv;
    public ValueAnimator aCw;
    public float aCx;
    public float aCy;
    public float aCz;

    /* loaded from: classes10.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void th();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bp(boolean z) {
        if (!this.aCs) {
            return;
        }
        if (z) {
            bq(true);
            br(true);
            return;
        }
        bq(false);
        br(false);
    }

    private float cY(int i) {
        int i2 = this.aBX;
        int i3 = this.aBS;
        return ((i2 * (i - i3)) / (this.aBT - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cZ(int i) {
        int i2 = this.aBX;
        if (i > i2 / 2) {
            return this.aBT;
        }
        if (i < (-i2) / 2) {
            return this.aBS;
        }
        return Math.round(((i + (i2 / 2.0f)) * (this.aBT - this.aBS)) / i2) + this.aBS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f) {
        Rect rect = this.aCk;
        int i = this.aBR;
        rect.left = (int) (f - i);
        rect.right = (int) (i + f);
        this.aCi.right = (int) f;
        invalidate();
    }

    private float h(float f) {
        float f2 = this.aBX / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        if (f < f3) {
            return f3;
        }
        return f;
    }

    public final void bo(boolean z) {
        this.aCC = z;
        bp(z);
    }

    public void setMaxProgress(int i) {
        this.aBT = i;
    }

    public void setMinProgress(int i) {
        this.aBS = i;
        if (this.aBZ < i) {
            this.aBZ = i;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aCr = new WeakReference<>(aVar);
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i) {
        this.aBO = i;
        this.aCe.setColor(i);
    }

    public void setProgressColor(@ColorInt int i) {
        this.aBP = i;
        this.aCf.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.aBS;
        if (i <= i2 || i >= (i2 = this.aBT)) {
            i = i2;
        }
        this.aCb = i;
        this.aCj.right = (int) h(cY(i));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i) {
        this.aBQ = i;
        this.aCg.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aCl = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aCp = z;
    }

    public void setThumbScale(float f) {
        this.aCx = f;
    }

    public void setThumbTouchOffset(int i) {
        this.aBY = i;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBT = 100;
        this.aBW = false;
        this.aCl = null;
        this.aCm = false;
        this.aCn = false;
        this.aCo = false;
        this.aCp = true;
        this.aCs = true;
        this.aCt = false;
        this.aCx = 1.0f;
        this.aCy = 1.34f;
        this.aCz = 1.0f;
        this.aCA = 2.0f;
        init(context, attributeSet);
    }

    private void a(int i, boolean z, boolean z2) {
        int i2 = this.aBS;
        if (i <= i2 || i >= (i2 = this.aBT)) {
            i = i2;
        }
        i(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aCa != this.aBZ) {
            this.aCo = z2;
            onSeekBarChangedListener.a(this, z2);
            this.aCo = false;
        }
        this.aCa = this.aBZ;
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f = this.aCz;
        rect2.top = (int) (rect.top * f);
        rect2.bottom = (int) (rect.bottom * f);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aBU * this.aCz);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void bm(Context context) {
        this.aCs = true;
        this.aCB = com.kwad.sdk.d.a.a.a(context, 10.0f);
        this.aBR = com.kwad.sdk.d.a.a.a(context, 3.0f);
        this.aBY = com.kwad.sdk.d.a.a.a(context, 20.0f);
        this.aCl = null;
        this.aCt = false;
        this.aBV = com.kwad.sdk.d.a.a.a(context, 0.5f);
        this.aBU = com.kwad.sdk.d.a.a.a(context, 1.0f);
        this.aBO = 654311423;
        this.aBP = -1;
        this.aBQ = 1090519039;
        this.aBS = 0;
        this.aBT = 100;
        this.aBW = false;
    }

    private void bq(boolean z) {
        float f;
        float f2 = this.aCx;
        if (z) {
            f = this.aCy;
        } else {
            f = 1.0f;
        }
        ValueAnimator valueAnimator = this.aCu;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aCu = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aCu.setInterpolator(new LinearInterpolator());
            this.aCu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aCx = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aCu.setFloatValues(f2, f);
        this.aCu.start();
    }

    private void br(boolean z) {
        float f;
        float f2 = this.aCz;
        if (z) {
            f = this.aCA;
        } else {
            f = 1.0f;
        }
        ValueAnimator valueAnimator = this.aCv;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aCv = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aCv.setInterpolator(new LinearInterpolator());
            this.aCv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aCz = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aCv.setFloatValues(f2, f);
        this.aCv.start();
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aCl;
        if (drawable != null) {
            drawable.setBounds(this.aCk);
            this.aCl.draw(canvas);
        } else {
            this.aBN.setColor(this.aBP);
            canvas.drawCircle(this.aCk.centerX(), this.aCk.centerY(), (this.aCk.width() * this.aCx) / 2.0f, this.aBN);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aCd / 2, this.aCc / 2);
        a(canvas, this.aCh, this.aCe);
        a(canvas, this.aCj, this.aCg);
        a(canvas, this.aCi, this.aCf);
        if (this.aCC) {
            c(canvas);
        }
        canvas.restore();
    }

    private boolean d(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aCk;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 < i4 && (i = rect.top) < (i2 = rect.bottom)) {
            float f3 = this.aCx;
            int i5 = this.aBY;
            if (f >= (i3 * f3) - i5 && f <= (i4 * f3) + i5 && f2 >= (i * f3) - i5 && f2 <= (i2 * f3) + i5) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean e(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aCh;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 < i4 && (i = rect.top) < (i2 = rect.bottom)) {
            float f3 = this.aCz;
            int i5 = this.aBY;
            if (f >= (i3 * f3) - i5 && f <= (i4 * f3) + i5 && f2 >= (i * f3) - i5 && f2 <= (i2 * f3) + i5) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.aCd = size;
        } else {
            this.aCd = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aCc = size2;
        } else {
            this.aCc = getHeight();
        }
        z(this.aCd, this.aCc);
        setMeasuredDimension(this.aCd, this.aCc);
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aCr;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getMaxProgress() {
        return this.aBT;
    }

    public int getProgress() {
        return this.aBZ;
    }

    public int getProgressLength() {
        return this.aBX;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aBR * this.aCy));
    }

    public int getSecondaryProgress() {
        return this.aCb;
    }

    private void i(boolean z, int i) {
        if (z) {
            float h = h(cY(this.aBZ));
            float h2 = h(cY(i));
            ValueAnimator valueAnimator = this.aCw;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.aCw = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.aCw.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2) + 1.0f;
                    }
                });
                this.aCw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.aBZ = scaleAnimSeekBar.cZ((int) floatValue);
                        ScaleAnimSeekBar.this.g(floatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.aCw.setFloatValues(h, h2);
            this.aCw.start();
            return;
        }
        this.aBZ = i;
        g(h(cY(i)));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bm(context);
        }
        Paint paint = new Paint();
        this.aBN = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aBN.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aCe = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aCe.setColor(this.aBO);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aCf = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aCf.setColor(this.aBP);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aCg = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aCg.setColor(this.aBQ);
        this.aCh = new Rect();
        this.aCi = new Rect();
        this.aCk = new Rect();
        this.aCj = new Rect();
        this.aBZ = this.aBS;
    }

    private void z(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i > 0 && i2 > 0) {
            if (this.aCs) {
                this.aBX = (int) (i - ((this.aCB * 2) * (this.aCy - this.aCx)));
            } else {
                this.aBX = i - (this.aCB * 2);
            }
            Rect rect = this.aCh;
            int i7 = -this.aBV;
            rect.top = i7;
            rect.bottom = -i7;
            if (this.aBW) {
                i3 = -i;
            } else {
                i3 = -this.aBX;
            }
            rect.left = i3 / 2;
            Rect rect2 = this.aCh;
            if (this.aBW) {
                i4 = i / 2;
            } else {
                i4 = this.aBX / 2;
            }
            rect2.right = i4;
            Rect rect3 = this.aCi;
            int i8 = -this.aBV;
            rect3.top = i8;
            rect3.bottom = -i8;
            if (this.aBW) {
                i5 = -i;
            } else {
                i5 = -this.aBX;
            }
            rect3.left = i5 / 2;
            Rect rect4 = this.aCi;
            int i9 = this.aBX;
            rect4.right = (-i9) / 2;
            Rect rect5 = this.aCj;
            rect5.top = -this.aBV;
            rect5.bottom = -rect4.top;
            if (this.aBW) {
                i6 = -i;
            } else {
                i6 = -i9;
            }
            rect5.left = i6 / 2;
            Rect rect6 = this.aCj;
            int i10 = this.aBX;
            rect6.right = (-i10) / 2;
            Rect rect7 = this.aCk;
            int i11 = this.aBR;
            rect7.top = -i11;
            rect7.bottom = i11;
            rect7.left = ((-i10) / 2) - i11;
            rect7.right = ((-i10) / 2) + i11;
            setThumbDrawable(this.aCl);
            setProgress(this.aBZ);
            setSecondaryProgress(this.aCb);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.aCd / 2);
        float y = motionEvent.getY() - (this.aCc / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aCm || this.aCn)) {
                    a(cZ((int) x), false, true);
                }
            } else {
                this.aCq = false;
                if (this.aCn || this.aCm) {
                    this.aCn = false;
                    this.aCm = false;
                    a(cZ((int) x), this.aCt, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else if (!this.aCp) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (d(x, y)) {
                bp(true);
                this.aCm = true;
                this.aCq = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.th();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (e(x, y)) {
                bp(true);
                this.aCn = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.th();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }
}
