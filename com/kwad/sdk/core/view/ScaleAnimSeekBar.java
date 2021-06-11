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
/* loaded from: classes7.dex */
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
    public Paint f34881a;

    /* renamed from: b  reason: collision with root package name */
    public int f34882b;

    /* renamed from: c  reason: collision with root package name */
    public int f34883c;

    /* renamed from: d  reason: collision with root package name */
    public int f34884d;

    /* renamed from: e  reason: collision with root package name */
    public int f34885e;

    /* renamed from: f  reason: collision with root package name */
    public int f34886f;

    /* renamed from: g  reason: collision with root package name */
    public int f34887g;

    /* renamed from: h  reason: collision with root package name */
    public int f34888h;

    /* renamed from: i  reason: collision with root package name */
    public int f34889i;
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

    /* loaded from: classes7.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z);

        void b(ScaleAnimSeekBar scaleAnimSeekBar);
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34887g = 100;
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

    private float a(int i2) {
        int i3 = this.k;
        int i4 = this.f34886f;
        return ((i3 * (i2 - i4)) / (this.f34887g - i4)) - (i3 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Rect rect = this.x;
        int i2 = this.f34885e;
        rect.left = (int) (f2 - i2);
        rect.right = (int) (i2 + f2);
        this.v.right = (int) f2;
        invalidate();
    }

    private void a(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.k = this.F ? (int) (i2 - ((this.O * 2) * (this.L - this.K))) : i2 - (this.O * 2);
        Rect rect = this.u;
        int i4 = -this.f34889i;
        rect.top = i4;
        rect.bottom = -i4;
        rect.left = (this.j ? -i2 : -this.k) / 2;
        this.u.right = this.j ? i2 / 2 : this.k / 2;
        Rect rect2 = this.v;
        int i5 = -this.f34889i;
        rect2.top = i5;
        rect2.bottom = -i5;
        rect2.left = (this.j ? -i2 : -this.k) / 2;
        Rect rect3 = this.v;
        int i6 = this.k;
        rect3.right = (-i6) / 2;
        Rect rect4 = this.w;
        rect4.top = -this.f34889i;
        rect4.bottom = -rect3.top;
        rect4.left = (this.j ? -i2 : -i6) / 2;
        Rect rect5 = this.w;
        int i7 = this.k;
        rect5.right = (-i7) / 2;
        Rect rect6 = this.x;
        int i8 = this.f34885e;
        rect6.top = -i8;
        rect6.bottom = i8;
        rect6.left = ((-i7) / 2) - i8;
        rect6.right = ((-i7) / 2) + i8;
        setThumbDrawable(this.y);
        setProgress(this.m);
        setSecondaryProgress(this.o);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            a(context);
        }
        Paint paint = new Paint();
        this.f34881a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f34881a.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.r = gradientDrawable;
        gradientDrawable.setShape(0);
        this.r.setColor(this.f34882b);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.s = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.s.setColor(this.f34883c);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.t = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.t.setColor(this.f34884d);
        this.u = new Rect();
        this.v = new Rect();
        this.x = new Rect();
        this.w = new Rect();
        this.m = this.f34886f;
    }

    private void a(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setBounds(this.x);
            this.y.draw(canvas);
        } else {
            this.f34881a.setColor(this.f34883c);
            canvas.drawCircle(this.x.centerX(), this.x.centerY(), (this.x.width() * this.K) / 2.0f, this.f34881a);
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
        gradientDrawable.setCornerRadius(this.f34888h * this.M);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(boolean z, int i2) {
        if (!z) {
            this.m = i2;
            a(b(a(i2)));
            return;
        }
        float b2 = b(a(this.m));
        float b3 = b(a(i2));
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
        int i2;
        int i3;
        Rect rect = this.x;
        int i4 = rect.left;
        int i5 = rect.right;
        if (i4 < i5 && (i2 = rect.top) < (i3 = rect.bottom)) {
            float f4 = this.K;
            int i6 = this.l;
            if (f2 >= (i4 * f4) - i6 && f2 <= (i5 * f4) + i6 && f3 >= (i2 * f4) - i6 && f3 <= (i3 * f4) + i6) {
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
    public int b(int i2) {
        int i3 = this.k;
        return i2 > i3 / 2 ? this.f34887g : i2 < (-i3) / 2 ? this.f34886f : Math.round(((i2 + (i3 / 2.0f)) * (this.f34887g - this.f34886f)) / i3) + this.f34886f;
    }

    private void b(boolean z) {
        if (this.F) {
            boolean z2 = z;
            c(z2);
            d(z2);
        }
    }

    private boolean b(float f2, float f3) {
        int i2;
        int i3;
        Rect rect = this.u;
        int i4 = rect.left;
        int i5 = rect.right;
        if (i4 < i5 && (i2 = rect.top) < (i3 = rect.bottom)) {
            float f4 = this.M;
            int i6 = this.l;
            if (f2 >= (i4 * f4) - i6 && f2 <= (i5 * f4) + i6 && f3 >= (i2 * f4) - i6 && f3 <= (i3 * f4) + i6) {
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

    public void a(int i2, boolean z, boolean z2) {
        int i3 = this.f34886f;
        if (i2 <= i3 || i2 >= (i3 = this.f34887g)) {
            i2 = i3;
        }
        a(z, i2);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null) {
            int i4 = this.n;
            int i5 = this.m;
            if (i4 != i5) {
                this.B = z2;
                onSeekBarChangedListener.a(this, i5, z2);
                this.B = false;
            }
        }
        this.n = this.m;
    }

    public void a(Context context) {
        this.F = true;
        this.O = ao.a(context, 10.0f);
        this.f34885e = ao.a(context, 3.0f);
        this.l = ao.a(context, 20.0f);
        this.y = null;
        this.G = false;
        this.f34889i = ao.a(context, 0.3f);
        this.f34888h = ao.a(context, 1.0f);
        this.f34882b = 654311423;
        this.f34883c = -1;
        this.f34884d = 1090519039;
        this.f34886f = 0;
        this.f34887g = 100;
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
        return this.f34887g;
    }

    public int getProgress() {
        return this.m;
    }

    public int getProgressLength() {
        return this.k;
    }

    public int getProgressX() {
        return (int) (getX() + (this.f34885e * this.L));
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
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
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

    public void setMaxProgress(int i2) {
        this.f34887g = i2;
    }

    public void setMinProgress(int i2) {
        this.f34886f = i2;
        if (this.m < i2) {
            this.m = i2;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.E = new WeakReference<>(aVar);
    }

    public void setProgress(int i2) {
        a(i2, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i2) {
        this.f34882b = i2;
        this.r.setColor(i2);
    }

    public void setProgressColor(@ColorInt int i2) {
        this.f34883c = i2;
        this.s.setColor(i2);
    }

    public void setSecondaryProgress(int i2) {
        int i3 = this.f34886f;
        if (i2 <= i3 || i2 >= (i3 = this.f34887g)) {
            i2 = i3;
        }
        this.o = i2;
        this.w.right = (int) b(a(i2));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i2) {
        this.f34884d = i2;
        this.t.setColor(i2);
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

    public void setThumbTouchOffset(int i2) {
        this.l = i2;
        invalidate();
    }
}
