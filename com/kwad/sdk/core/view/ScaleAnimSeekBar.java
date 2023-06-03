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
    public int afA;
    public int afB;
    public int afC;
    public GradientDrawable afD;
    public GradientDrawable afE;
    public GradientDrawable afF;
    public Rect afG;
    public Rect afH;
    public Rect afI;
    public Rect afJ;
    public Drawable afK;
    public boolean afL;
    public boolean afM;
    public boolean afN;
    public boolean afO;
    public boolean afP;
    public WeakReference<a> afQ;
    public boolean afR;
    public boolean afS;
    public ValueAnimator afT;
    public ValueAnimator afU;
    public ValueAnimator afV;
    public float afW;
    public float afX;
    public float afY;
    public float afZ;
    public Paint afm;
    public int afn;
    public int afo;
    public int afp;
    public int afq;
    public int afr;
    public int afs;
    public int aft;
    public int afu;
    public boolean afv;
    public int afw;
    public int afx;
    public int afy;
    public int afz;
    public int aga;
    public boolean agb;

    /* loaded from: classes10.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void qf();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afs = 100;
        this.afv = false;
        this.afK = null;
        this.afL = false;
        this.afM = false;
        this.afN = false;
        this.afO = true;
        this.afR = true;
        this.afS = false;
        this.afW = 1.0f;
        this.afX = 1.34f;
        this.afY = 1.0f;
        this.afZ = 2.0f;
        b(context, attributeSet);
    }

    private void a(int i, boolean z, boolean z2) {
        int i2 = this.afr;
        if (i <= i2 || i >= (i2 = this.afs)) {
            i = i2;
        }
        g(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.afz != this.afy) {
            this.afN = z2;
            onSeekBarChangedListener.a(this, z2);
            this.afN = false;
        }
        this.afz = this.afy;
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f = this.afY;
        rect2.top = (int) (rect.top * f);
        rect2.bottom = (int) (rect.bottom * f);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aft * this.afY);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void aO(boolean z) {
        if (this.afR) {
            boolean z2 = z;
            aP(z2);
            aQ(z2);
        }
    }

    private void aP(boolean z) {
        float f = this.afW;
        float f2 = z ? this.afX : 1.0f;
        ValueAnimator valueAnimator = this.afT;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.afT = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.afT.setInterpolator(new LinearInterpolator());
            this.afT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.afW = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.afT.setFloatValues(f, f2);
        this.afT.start();
    }

    private void aQ(boolean z) {
        float f = this.afY;
        float f2 = z ? this.afZ : 1.0f;
        ValueAnimator valueAnimator = this.afU;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.afU = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.afU.setInterpolator(new LinearInterpolator());
            this.afU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.afY = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.afU.setFloatValues(f, f2);
        this.afU.start();
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bF(context);
        }
        Paint paint = new Paint();
        this.afm = paint;
        paint.setStyle(Paint.Style.FILL);
        this.afm.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.afD = gradientDrawable;
        gradientDrawable.setShape(0);
        this.afD.setColor(this.afn);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.afE = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.afE.setColor(this.afo);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.afF = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.afF.setColor(this.afp);
        this.afG = new Rect();
        this.afH = new Rect();
        this.afJ = new Rect();
        this.afI = new Rect();
        this.afy = this.afr;
    }

    private void bF(Context context) {
        this.afR = true;
        this.aga = com.kwad.sdk.b.kwai.a.a(context, 10.0f);
        this.afq = com.kwad.sdk.b.kwai.a.a(context, 3.0f);
        this.afx = com.kwad.sdk.b.kwai.a.a(context, 20.0f);
        this.afK = null;
        this.afS = false;
        this.afu = com.kwad.sdk.b.kwai.a.a(context, 0.3f);
        this.aft = com.kwad.sdk.b.kwai.a.a(context, 1.0f);
        this.afn = 654311423;
        this.afo = -1;
        this.afp = 1090519039;
        this.afr = 0;
        this.afs = 100;
        this.afv = false;
    }

    private float ba(int i) {
        int i2 = this.afw;
        int i3 = this.afr;
        return ((i2 * (i - i3)) / (this.afs - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bb(int i) {
        int i2 = this.afw;
        return i > i2 / 2 ? this.afs : i < (-i2) / 2 ? this.afr : Math.round(((i + (i2 / 2.0f)) * (this.afs - this.afr)) / i2) + this.afr;
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.afK;
        if (drawable != null) {
            drawable.setBounds(this.afJ);
            this.afK.draw(canvas);
        } else {
            this.afm.setColor(this.afo);
            canvas.drawCircle(this.afJ.centerX(), this.afJ.centerY(), (this.afJ.width() * this.afW) / 2.0f, this.afm);
        }
        canvas.restore();
    }

    private boolean c(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.afJ;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 >= i4 || (i = rect.top) >= (i2 = rect.bottom)) {
            return false;
        }
        float f3 = this.afW;
        int i5 = this.afx;
        return f >= (((float) i3) * f3) - ((float) i5) && f <= (((float) i4) * f3) + ((float) i5) && f2 >= (((float) i) * f3) - ((float) i5) && f2 <= (((float) i2) * f3) + ((float) i5);
    }

    private boolean d(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.afG;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 >= i4 || (i = rect.top) >= (i2 = rect.bottom)) {
            return false;
        }
        float f3 = this.afY;
        int i5 = this.afx;
        return f >= (((float) i3) * f3) - ((float) i5) && f <= (((float) i4) * f3) + ((float) i5) && f2 >= (((float) i) * f3) - ((float) i5) && f2 <= (((float) i2) * f3) + ((float) i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f) {
        Rect rect = this.afJ;
        int i = this.afq;
        rect.left = (int) (f - i);
        rect.right = (int) (i + f);
        this.afH.right = (int) f;
        invalidate();
    }

    private float f(float f) {
        float f2 = this.afw / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    private void g(boolean z, int i) {
        if (!z) {
            this.afy = i;
            e(f(ba(i)));
            return;
        }
        float f = f(ba(this.afy));
        float f2 = f(ba(i));
        ValueAnimator valueAnimator = this.afV;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.afV = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.afV.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f3) {
                    float f4 = f3 - 1.0f;
                    return (f4 * f4 * f4) + 1.0f;
                }
            });
            this.afV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.afy = scaleAnimSeekBar.bb((int) floatValue);
                    ScaleAnimSeekBar.this.e(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.afV.setFloatValues(f, f2);
        this.afV.start();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.afQ;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void o(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.afw = this.afR ? (int) (i - ((this.aga * 2) * (this.afX - this.afW))) : i - (this.aga * 2);
        Rect rect = this.afG;
        int i3 = -this.afu;
        rect.top = i3;
        rect.bottom = -i3;
        rect.left = (this.afv ? -i : -this.afw) / 2;
        this.afG.right = this.afv ? i / 2 : this.afw / 2;
        Rect rect2 = this.afH;
        int i4 = -this.afu;
        rect2.top = i4;
        rect2.bottom = -i4;
        rect2.left = (this.afv ? -i : -this.afw) / 2;
        Rect rect3 = this.afH;
        int i5 = this.afw;
        rect3.right = (-i5) / 2;
        Rect rect4 = this.afI;
        rect4.top = -this.afu;
        rect4.bottom = -rect3.top;
        rect4.left = (this.afv ? -i : -i5) / 2;
        Rect rect5 = this.afI;
        int i6 = this.afw;
        rect5.right = (-i6) / 2;
        Rect rect6 = this.afJ;
        int i7 = this.afq;
        rect6.top = -i7;
        rect6.bottom = i7;
        rect6.left = ((-i6) / 2) - i7;
        rect6.right = ((-i6) / 2) + i7;
        setThumbDrawable(this.afK);
        setProgress(this.afy);
        setSecondaryProgress(this.afA);
    }

    public final void aN(boolean z) {
        this.agb = z;
        aO(z);
    }

    public int getMaxProgress() {
        return this.afs;
    }

    public int getProgress() {
        return this.afy;
    }

    public int getProgressLength() {
        return this.afw;
    }

    public int getProgressX() {
        return (int) (getX() + (this.afq * this.afX));
    }

    public int getSecondaryProgress() {
        return this.afA;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.afC / 2, this.afB / 2);
        a(canvas, this.afG, this.afD);
        a(canvas, this.afI, this.afF);
        a(canvas, this.afH, this.afE);
        if (this.agb) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = getWidth();
        }
        this.afC = size;
        if (mode2 == 1073741824) {
            this.afB = size2;
        } else {
            this.afB = getHeight();
        }
        o(this.afC, this.afB);
        setMeasuredDimension(this.afC, this.afB);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
        if (r3 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
        r3.requestDisallowInterceptTouchEvent(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
        if (r3 != null) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.afC / 2);
        float y = motionEvent.getY() - (this.afB / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.afP = false;
                if (this.afM || this.afL) {
                    this.afM = false;
                    this.afL = false;
                    a(bb((int) x), this.afS, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (action == 2 && (this.afL || this.afM)) {
                a(bb((int) x), false, true);
            }
        } else if (!this.afO) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (c(x, y)) {
                aO(true);
                this.afL = true;
                this.afP = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.qf();
                }
            } else if (d(x, y)) {
                aO(true);
                this.afM = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.qf();
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i) {
        this.afs = i;
    }

    public void setMinProgress(int i) {
        this.afr = i;
        if (this.afy < i) {
            this.afy = i;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.afQ = new WeakReference<>(aVar);
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i) {
        this.afn = i;
        this.afD.setColor(i);
    }

    public void setProgressColor(@ColorInt int i) {
        this.afo = i;
        this.afE.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.afr;
        if (i <= i2 || i >= (i2 = this.afs)) {
            i = i2;
        }
        this.afA = i;
        this.afI.right = (int) f(ba(i));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i) {
        this.afp = i;
        this.afF.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.afK = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.afO = z;
    }

    public void setThumbScale(float f) {
        this.afW = f;
    }

    public void setThumbTouchOffset(int i) {
        this.afx = i;
        invalidate();
    }
}
