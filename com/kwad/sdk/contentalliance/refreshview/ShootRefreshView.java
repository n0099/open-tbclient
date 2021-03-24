package com.kwad.sdk.contentalliance.refreshview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class ShootRefreshView extends View implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ShootRefreshView, Float> f32969a = new Property<ShootRefreshView, Float>(Float.class, null) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ShootRefreshView shootRefreshView) {
            return Float.valueOf(shootRefreshView.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public void set(ShootRefreshView shootRefreshView, Float f2) {
            shootRefreshView.o = f2.floatValue();
            shootRefreshView.invalidate();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Property<ShootRefreshView, Float> f32970b = new Property<ShootRefreshView, Float>(Float.class, null) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ShootRefreshView shootRefreshView) {
            return Float.valueOf(shootRefreshView.p);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public void set(ShootRefreshView shootRefreshView, Float f2) {
            shootRefreshView.p = f2.floatValue();
            shootRefreshView.invalidate();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final float f32971c = (float) Math.toDegrees(0.5235987901687622d);

    /* renamed from: d  reason: collision with root package name */
    public static final float f32972d = (float) Math.sqrt(3.0d);

    /* renamed from: e  reason: collision with root package name */
    public final Paint f32973e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f32974f;

    /* renamed from: g  reason: collision with root package name */
    public int f32975g;

    /* renamed from: h  reason: collision with root package name */
    public int f32976h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;
    public Shader q;
    public boolean r;
    public ValueAnimator s;
    public float t;
    public float u;
    public boolean v;
    public AnimatorSet w;

    public ShootRefreshView(Context context) {
        this(context, null);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32973e = new Paint(1);
        this.f32974f = new RectF();
        this.v = false;
        a(context, attributeSet);
        g();
        h();
        a();
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.j = -1044481;
        this.k = -256;
        this.l = 234880768;
        this.m = ao.a(getContext(), 1.5f);
        this.q = new SweepGradient(0.0f, 0.0f, new int[]{this.k, this.l}, new float[]{0.3f, 1.0f});
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Canvas canvas) {
        Paint paint;
        Shader shader;
        float f2;
        int i;
        canvas.save();
        canvas.translate(this.f32976h, this.i);
        if (this.s.isRunning()) {
            canvas.rotate(this.n - 90.0f);
            Shader shader2 = this.f32973e.getShader();
            shader = this.q;
            if (shader2 != shader) {
                paint = this.f32973e;
            }
            f2 = this.u;
            i = this.f32975g;
            if (f2 >= i * 2) {
                this.t = 0.0f;
            } else {
                this.t = ((f2 - (i * 2)) * 360.0f) / (i * 4.0f);
            }
            this.f32973e.setAntiAlias(true);
            this.f32973e.setStyle(Paint.Style.STROKE);
            int i2 = this.f32975g;
            canvas.drawArc(new RectF(0.0f - i2, 0.0f - i2, i2 + 0.0f, i2 + 0.0f), -90.0f, !this.v ? 360.0f : this.t, false, this.f32973e);
            canvas.restore();
        }
        paint = this.f32973e;
        shader = null;
        paint.setShader(shader);
        f2 = this.u;
        i = this.f32975g;
        if (f2 >= i * 2) {
        }
        this.f32973e.setAntiAlias(true);
        this.f32973e.setStyle(Paint.Style.STROKE);
        int i22 = this.f32975g;
        canvas.drawArc(new RectF(0.0f - i22, 0.0f - i22, i22 + 0.0f, i22 + 0.0f), -90.0f, !this.v ? 360.0f : this.t, false, this.f32973e);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        int i;
        float pow;
        float f2;
        float f3;
        Paint paint;
        Canvas canvas2;
        float pow2;
        Canvas canvas3 = canvas;
        this.f32973e.setShader(null);
        canvas.save();
        canvas3.translate(this.f32976h, this.i);
        canvas3.rotate(-this.p);
        int i2 = 0;
        while (i2 < 6) {
            canvas.save();
            canvas3.rotate(i2 * (-60));
            float f4 = this.o;
            if (f4 > 0.5235988f) {
                double tan = Math.tan(f4);
                double tan2 = Math.tan(this.o + 1.0471976f);
                float f5 = f32972d;
                double d2 = f5;
                Double.isNaN(d2);
                double d3 = 1.0d - (d2 * tan2);
                double d4 = (tan - tan2) * 2.0d;
                int i3 = this.f32975g;
                float f6 = i3 * ((float) (d3 / d4));
                i = i2;
                double d5 = f5;
                Double.isNaN(d5);
                pow = ((float) ((((2.0d * tan2) - tan) - ((d5 * tan) * tan2)) / d4)) * i3;
                f2 = 0.0f;
                f3 = -i3;
                paint = this.f32973e;
                canvas2 = canvas;
                pow2 = f6;
            } else {
                i = i2;
                double tan3 = Math.tan(f4);
                double d6 = this.f32975g;
                Double.isNaN(d6);
                double d7 = this.f32975g;
                Double.isNaN(d7);
                pow = (float) (((Math.pow(tan3, 2.0d) - 1.0d) * d7) / (Math.pow(tan3, 2.0d) + 1.0d));
                f2 = 0.0f;
                f3 = -this.f32975g;
                paint = this.f32973e;
                canvas2 = canvas;
                pow2 = (float) (((tan3 * 2.0d) * d6) / (Math.pow(tan3, 2.0d) + 1.0d));
            }
            canvas2.drawLine(f2, f3, pow2, pow, paint);
            canvas.restore();
            i2 = i + 1;
            canvas3 = canvas;
        }
        canvas.restore();
    }

    private void g() {
        this.f32973e.setStyle(Paint.Style.STROKE);
        this.f32973e.setStrokeWidth(this.m);
        this.f32973e.setColor(this.j);
    }

    private void h() {
        i();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.s = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.s.setInterpolator(new LinearInterpolator());
        this.s.setDuration(400L);
        this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShootRefreshView.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShootRefreshView.this.invalidate();
            }
        });
    }

    private void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.5235988f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(30L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShootRefreshView.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShootRefreshView.this.invalidate();
            }
        });
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(f32969a, 0.5235988f, 1.2566371f);
        Property<ShootRefreshView, Float> property = f32970b;
        float f2 = f32971c;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, ofFloat2, PropertyValuesHolder.ofFloat(property, -(f2 / 2.0f), (-(f2 / 2.0f)) - 120.0f));
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.w = animatorSet;
        animatorSet.play(ofPropertyValuesHolder).after(ofFloat);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a() {
        this.o = 1.2566371f;
        this.p = (-(f32971c / 2.0f)) - 240.0f;
        this.n = 0.0f;
        invalidate();
        this.v = false;
        this.r = false;
        this.w.end();
        this.s.end();
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a(float f2, float f3) {
        this.u = f2;
        invalidate();
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void b() {
        this.n = 0.0f;
        this.p = 0.0f;
        this.o = 0.0f;
        if (this.w.isRunning()) {
            this.s.end();
        } else {
            this.s.start();
        }
        this.r = true;
        this.v = true;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void c() {
        this.w.start();
        this.s.end();
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void d() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void e() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public int f() {
        return Build.VERSION.SDK_INT > 19 ? 500 : 800;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.r) {
            b(canvas);
        }
        a(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f32974f.set(getPaddingLeft() + 0, getPaddingTop() + 0, i - getPaddingRight(), i2 - getPaddingBottom());
        RectF rectF = this.f32974f;
        int i5 = this.m;
        rectF.inset(i5, i5);
        this.f32975g = (int) (Math.min(this.f32974f.width(), this.f32974f.height()) / 2.0f);
        this.f32976h = (int) this.f32974f.centerX();
        this.i = (int) this.f32974f.centerY();
    }
}
