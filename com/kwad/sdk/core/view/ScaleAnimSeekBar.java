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
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ScaleAnimSeekBar extends View {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public WeakReference<a> E;
    public boolean F;
    public boolean G;
    public ValueAnimator H;
    public ValueAnimator I;
    public ValueAnimator J;
    public float K;
    public float L;
    public float M;
    public float N;
    public int O;
    public boolean P;

    /* renamed from: a  reason: collision with root package name */
    public Paint f34239a;

    /* renamed from: b  reason: collision with root package name */
    public int f34240b;

    /* renamed from: c  reason: collision with root package name */
    public int f34241c;

    /* renamed from: d  reason: collision with root package name */
    public int f34242d;

    /* renamed from: e  reason: collision with root package name */
    public int f34243e;

    /* renamed from: f  reason: collision with root package name */
    public int f34244f;

    /* renamed from: g  reason: collision with root package name */
    public int f34245g;

    /* renamed from: h  reason: collision with root package name */
    public int f34246h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public GradientDrawable r;
    public GradientDrawable s;
    public GradientDrawable t;
    public Rect u;
    public Rect v;
    public Rect w;
    public Rect x;
    public Drawable y;
    public boolean z;

    /* loaded from: classes6.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, int i, boolean z);

        void b(ScaleAnimSeekBar scaleAnimSeekBar);
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34245g = 100;
        this.j = false;
        this.y = null;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = true;
        this.F = true;
        this.G = false;
        this.K = 1.0f;
        this.L = 1.34f;
        this.M = 1.0f;
        this.N = 2.0f;
        a(context, attributeSet);
    }

    private float a(int i) {
        int i2 = this.k;
        int i3 = this.f34244f;
        return ((i2 * (i - i3)) / (this.f34245g - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Rect rect = this.x;
        int i = this.f34243e;
        rect.left = (int) (f2 - i);
        rect.right = (int) (i + f2);
        this.v.right = (int) f2;
        invalidate();
    }

    private void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.k = this.F ? (int) (i - ((this.O * 2) * (this.L - this.K))) : i - (this.O * 2);
        Rect rect = this.u;
        int i3 = -this.i;
        rect.top = i3;
        rect.bottom = -i3;
        rect.left = (this.j ? -i : -this.k) / 2;
        this.u.right = this.j ? i / 2 : this.k / 2;
        Rect rect2 = this.v;
        int i4 = -this.i;
        rect2.top = i4;
        rect2.bottom = -i4;
        rect2.left = (this.j ? -i : -this.k) / 2;
        Rect rect3 = this.v;
        int i5 = this.k;
        rect3.right = (-i5) / 2;
        Rect rect4 = this.w;
        rect4.top = -this.i;
        rect4.bottom = -rect3.top;
        rect4.left = (this.j ? -i : -i5) / 2;
        Rect rect5 = this.w;
        int i6 = this.k;
        rect5.right = (-i6) / 2;
        Rect rect6 = this.x;
        int i7 = this.f34243e;
        rect6.top = -i7;
        rect6.bottom = i7;
        rect6.left = ((-i6) / 2) - i7;
        rect6.right = ((-i6) / 2) + i7;
        setThumbDrawable(this.y);
        setProgress(this.m);
        setSecondaryProgress(this.o);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            a(context);
        }
        Paint paint = new Paint();
        this.f34239a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f34239a.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.r = gradientDrawable;
        gradientDrawable.setShape(0);
        this.r.setColor(this.f34240b);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.s = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.s.setColor(this.f34241c);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.t = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.t.setColor(this.f34242d);
        this.u = new Rect();
        this.v = new Rect();
        this.x = new Rect();
        this.w = new Rect();
        this.m = this.f34244f;
    }

    private void a(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setBounds(this.x);
            this.y.draw(canvas);
        } else {
            this.f34239a.setColor(this.f34241c);
            canvas.drawCircle(this.x.centerX(), this.x.centerY(), (this.x.width() * this.K) / 2.0f, this.f34239a);
        }
        canvas.restore();
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f2 = this.M;
        rect2.top = (int) (rect.top * f2);
        rect2.bottom = (int) (rect.bottom * f2);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.f34246h * this.M);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(boolean z, int i) {
        if (!z) {
            this.m = i;
            a(b(a(i)));
            return;
        }
        float b2 = b(a(this.m));
        float b3 = b(a(i));
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.J = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.J.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f2) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3) + 1.0f;
                }
            });
            this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.m = scaleAnimSeekBar.b((int) floatValue);
                    ScaleAnimSeekBar.this.a(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.J.setFloatValues(b2, b3);
        this.J.start();
    }

    private boolean a(float f2, float f3) {
        int i;
        int i2;
        Rect rect = this.x;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 < i4 && (i = rect.top) < (i2 = rect.bottom)) {
            float f4 = this.K;
            int i5 = this.l;
            if (f2 >= (i3 * f4) - i5 && f2 <= (i4 * f4) + i5 && f3 >= (i * f4) - i5 && f3 <= (i2 * f4) + i5) {
                return true;
            }
        }
        return false;
    }

    private float b(float f2) {
        float f3 = this.k / 2;
        if (f2 > f3) {
            return f3;
        }
        float f4 = -f3;
        return f2 < f4 ? f4 : f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int i2 = this.k;
        return i > i2 / 2 ? this.f34245g : i < (-i2) / 2 ? this.f34244f : Math.round(((i + (i2 / 2.0f)) * (this.f34245g - this.f34244f)) / i2) + this.f34244f;
    }

    private void b(boolean z) {
        if (this.F) {
            boolean z2 = z;
            c(z2);
            d(z2);
        }
    }

    private boolean b(float f2, float f3) {
        int i;
        int i2;
        Rect rect = this.u;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 < i4 && (i = rect.top) < (i2 = rect.bottom)) {
            float f4 = this.M;
            int i5 = this.l;
            if (f2 >= (i3 * f4) - i5 && f2 <= (i4 * f4) + i5 && f3 >= (i * f4) - i5 && f3 <= (i2 * f4) + i5) {
                return true;
            }
        }
        return false;
    }

    private void c(boolean z) {
        float f2 = this.K;
        float f3 = z ? this.L : 1.0f;
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.H = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.H.setInterpolator(new LinearInterpolator());
            this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.K = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.H.setFloatValues(f2, f3);
        this.H.start();
    }

    private void d(boolean z) {
        float f2 = this.M;
        float f3 = z ? this.N : 1.0f;
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.I = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.I.setInterpolator(new LinearInterpolator());
            this.I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.M = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.I.setFloatValues(f2, f3);
        this.I.start();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.E;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void a(int i, boolean z, boolean z2) {
        int i2 = this.f34244f;
        if (i <= i2 || i >= (i2 = this.f34245g)) {
            i = i2;
        }
        a(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null) {
            int i3 = this.n;
            int i4 = this.m;
            if (i3 != i4) {
                this.B = z2;
                onSeekBarChangedListener.a(this, i4, z2);
                this.B = false;
            }
        }
        this.n = this.m;
    }

    public void a(Context context) {
        this.F = true;
        this.O = ao.a(context, 10.0f);
        this.f34243e = ao.a(context, 3.0f);
        this.l = ao.a(context, 20.0f);
        this.y = null;
        this.G = false;
        this.i = ao.a(context, 0.3f);
        this.f34246h = ao.a(context, 1.0f);
        this.f34240b = 654311423;
        this.f34241c = -1;
        this.f34242d = 1090519039;
        this.f34244f = 0;
        this.f34245g = 100;
        this.j = false;
    }

    public void a(boolean z) {
        this.P = z;
        b(z);
    }

    public boolean a() {
        return (this.A || this.z) ? false : true;
    }

    public int getMaxProgress() {
        return this.f34245g;
    }

    public int getProgress() {
        return this.m;
    }

    public int getProgressLength() {
        return this.k;
    }

    public int getProgressX() {
        return (int) (getX() + (this.f34243e * this.L));
    }

    public int getSecondaryProgress() {
        return this.o;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.q / 2, this.p / 2);
        a(canvas, this.u, this.r);
        a(canvas, this.w, this.t);
        a(canvas, this.v, this.s);
        if (this.P) {
            a(canvas);
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
        this.q = size;
        if (mode2 == 1073741824) {
            this.p = size2;
        } else {
            this.p = getHeight();
        }
        a(this.q, this.p);
        setMeasuredDimension(this.q, this.p);
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
        float x = motionEvent.getX() - (this.q / 2);
        float y = motionEvent.getY() - (this.p / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.D = false;
                if (this.A || this.z) {
                    this.A = false;
                    this.z = false;
                    a(b((int) x), this.G, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.b(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (action == 2 && (this.z || this.A)) {
                a(b((int) x), false, true);
            }
        } else if (!this.C) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (a(x, y)) {
                b(true);
                this.z = true;
                this.D = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.a(this);
                }
            } else if (b(x, y)) {
                b(true);
                this.A = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.a(this);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i) {
        this.f34245g = i;
    }

    public void setMinProgress(int i) {
        this.f34244f = i;
        if (this.m < i) {
            this.m = i;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.E = new WeakReference<>(aVar);
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i) {
        this.f34240b = i;
        this.r.setColor(i);
    }

    public void setProgressColor(@ColorInt int i) {
        this.f34241c = i;
        this.s.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.f34244f;
        if (i <= i2 || i >= (i2 = this.f34245g)) {
            i = i2;
        }
        this.o = i;
        this.w.right = (int) b(a(i));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i) {
        this.f34242d = i;
        this.t.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.y = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.C = z;
    }

    public void setThumbScale(float f2) {
        this.K = f2;
    }

    public void setThumbTouchOffset(int i) {
        this.l = i;
        invalidate();
    }
}
