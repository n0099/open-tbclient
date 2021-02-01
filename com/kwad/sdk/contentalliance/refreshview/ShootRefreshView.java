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
import androidx.core.view.InputDeviceCompat;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class ShootRefreshView extends View implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ShootRefreshView, Float> f8831a = new Property<ShootRefreshView, Float>(Float.class, null) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ShootRefreshView shootRefreshView) {
            return Float.valueOf(shootRefreshView.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public void set(ShootRefreshView shootRefreshView, Float f) {
            shootRefreshView.o = f.floatValue();
            shootRefreshView.invalidate();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Property<ShootRefreshView, Float> f8832b = new Property<ShootRefreshView, Float>(Float.class, null) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ShootRefreshView shootRefreshView) {
            return Float.valueOf(shootRefreshView.p);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public void set(ShootRefreshView shootRefreshView, Float f) {
            shootRefreshView.p = f.floatValue();
            shootRefreshView.invalidate();
        }
    };
    private static final float c = (float) Math.toDegrees(0.5235987901687622d);
    private static final float d = (float) Math.sqrt(3.0d);
    private final Paint e;
    private final RectF f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private Shader q;
    private boolean r;
    private ValueAnimator s;
    private float t;
    private float u;
    private boolean v;
    private AnimatorSet w;

    public ShootRefreshView(Context context) {
        this(context, null);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Paint(1);
        this.f = new RectF();
        this.v = false;
        a(context, attributeSet);
        g();
        h();
        a();
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.j = -1044481;
        this.k = InputDeviceCompat.SOURCE_ANY;
        this.l = 234880768;
        this.m = ao.a(getContext(), 1.5f);
        this.q = new SweepGradient(0.0f, 0.0f, new int[]{this.k, this.l}, new float[]{0.3f, 1.0f});
    }

    private void a(Canvas canvas) {
        canvas.save();
        canvas.translate(this.h, this.i);
        if (this.s.isRunning()) {
            canvas.rotate(this.n - 90.0f);
            if (this.e.getShader() != this.q) {
                this.e.setShader(this.q);
            }
        } else {
            this.e.setShader(null);
        }
        if (this.u < this.g * 2) {
            this.t = 0.0f;
        } else {
            this.t = ((this.u - (this.g * 2)) * 360.0f) / (4.0f * this.g);
        }
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(0.0f - this.g, 0.0f - this.g, this.g + 0.0f, this.g + 0.0f);
        if (this.v) {
            canvas.drawArc(rectF, -90.0f, 360.0f, false, this.e);
        } else {
            canvas.drawArc(rectF, -90.0f, this.t, false, this.e);
        }
        canvas.restore();
    }

    private void b(Canvas canvas) {
        this.e.setShader(null);
        canvas.save();
        canvas.translate(this.h, this.i);
        canvas.rotate(-this.p);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                canvas.restore();
                return;
            }
            canvas.save();
            canvas.rotate(i2 * (-60));
            if (this.o > 0.5235988f) {
                double tan = Math.tan(this.o);
                double tan2 = Math.tan(this.o + 1.0471976f);
                canvas.drawLine(0.0f, -this.g, this.g * ((float) ((1.0d - (d * tan2)) / (2.0d * (tan - tan2)))), ((float) ((((2.0d * tan2) - tan) - ((d * tan) * tan2)) / ((tan - tan2) * 2.0d))) * this.g, this.e);
            } else {
                double tan3 = Math.tan(this.o);
                canvas.drawLine(0.0f, -this.g, (float) (((2.0d * tan3) * this.g) / (Math.pow(tan3, 2.0d) + 1.0d)), (float) (((Math.pow(tan3, 2.0d) - 1.0d) * this.g) / (Math.pow(tan3, 2.0d) + 1.0d)), this.e);
            }
            canvas.restore();
            i = i2 + 1;
        }
    }

    private void g() {
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.m);
        this.e.setColor(this.j);
    }

    private void h() {
        i();
        this.s = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.s.setRepeatCount(-1);
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
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(f8831a, 0.5235988f, 1.2566371f), PropertyValuesHolder.ofFloat(f8832b, -(c / 2.0f), (-(c / 2.0f)) - 120.0f));
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(350L);
        this.w = new AnimatorSet();
        this.w.play(ofPropertyValuesHolder).after(ofFloat);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a() {
        this.o = 1.2566371f;
        this.p = (-(c / 2.0f)) - 240.0f;
        this.n = 0.0f;
        invalidate();
        this.v = false;
        this.r = false;
        this.w.end();
        this.s.end();
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a(float f, float f2) {
        this.u = f;
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
    protected void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.r) {
            b(canvas);
        }
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f.set(getPaddingLeft() + 0, getPaddingTop() + 0, i - getPaddingRight(), i2 - getPaddingBottom());
        this.f.inset(this.m, this.m);
        this.g = (int) (Math.min(this.f.width(), this.f.height()) / 2.0f);
        this.h = (int) this.f.centerX();
        this.i = (int) this.f.centerY();
    }
}
