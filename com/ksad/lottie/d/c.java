package com.ksad.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes6.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.ksad.lottie.d f31992i;

    /* renamed from: b  reason: collision with root package name */
    public float f31985b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31986c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f31987d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f31988e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f31989f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f31990g = -2.1474836E9f;

    /* renamed from: h  reason: collision with root package name */
    public float f31991h = 2.1474836E9f;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public boolean f31984a = false;

    private float o() {
        com.ksad.lottie.d dVar = this.f31992i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.f()) / Math.abs(this.f31985b);
    }

    private boolean p() {
        return h() < 0.0f;
    }

    private void q() {
        if (this.f31992i == null) {
            return;
        }
        float f2 = this.f31988e;
        if (f2 < this.f31990g || f2 > this.f31991h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f31990g), Float.valueOf(this.f31991h), Float.valueOf(this.f31988e)));
        }
    }

    public void a(float f2) {
        this.f31985b = f2;
    }

    public void a(int i2) {
        float f2 = i2;
        if (this.f31988e == f2) {
            return;
        }
        this.f31988e = e.b(f2, k(), l());
        this.f31987d = System.nanoTime();
        c();
    }

    public void a(int i2, int i3) {
        com.ksad.lottie.d dVar = this.f31992i;
        float d2 = dVar == null ? -3.4028235E38f : dVar.d();
        com.ksad.lottie.d dVar2 = this.f31992i;
        float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
        float f2 = i2;
        this.f31990g = e.b(f2, d2, e2);
        float f3 = i3;
        this.f31991h = e.b(f3, d2, e2);
        a((int) e.b(this.f31988e, f2, f3));
    }

    public void a(com.ksad.lottie.d dVar) {
        int d2;
        float e2;
        boolean z = this.f31992i == null;
        this.f31992i = dVar;
        if (z) {
            d2 = (int) Math.max(this.f31990g, dVar.d());
            e2 = Math.min(this.f31991h, dVar.e());
        } else {
            d2 = (int) dVar.d();
            e2 = dVar.e();
        }
        a(d2, (int) e2);
        a((int) this.f31988e);
        this.f31987d = System.nanoTime();
    }

    public void b(int i2) {
        a(i2, (int) this.f31991h);
    }

    public void c(int i2) {
        a((int) this.f31990g, i2);
    }

    @MainThread
    public void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f31984a = false;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        b();
        n();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        com.ksad.lottie.d dVar = this.f31992i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f31988e - dVar.d()) / (this.f31992i.e() - this.f31992i.d());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        m();
        if (this.f31992i == null || !isRunning()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float o = ((float) (nanoTime - this.f31987d)) / o();
        float f2 = this.f31988e;
        if (p()) {
            o = -o;
        }
        float f3 = f2 + o;
        this.f31988e = f3;
        boolean z = !e.c(f3, k(), l());
        this.f31988e = e.b(this.f31988e, k(), l());
        this.f31987d = nanoTime;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f31989f < getRepeatCount()) {
                a();
                this.f31989f++;
                if (getRepeatMode() == 2) {
                    this.f31986c = !this.f31986c;
                    g();
                } else {
                    this.f31988e = p() ? l() : k();
                }
                this.f31987d = nanoTime;
            } else {
                this.f31988e = l();
                n();
                b(p());
            }
        }
        q();
    }

    public float e() {
        return this.f31988e;
    }

    public void f() {
        this.f31992i = null;
        this.f31990g = -2.1474836E9f;
        this.f31991h = 2.1474836E9f;
    }

    public void g() {
        a(-h());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float f2;
        float k;
        if (this.f31992i == null) {
            return 0.0f;
        }
        if (p()) {
            f2 = l();
            k = this.f31988e;
        } else {
            f2 = this.f31988e;
            k = k();
        }
        return (f2 - k) / (l() - k());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.ksad.lottie.d dVar = this.f31992i;
        if (dVar == null) {
            return 0L;
        }
        return dVar.c();
    }

    public float h() {
        return this.f31985b;
    }

    @MainThread
    public void i() {
        this.f31984a = true;
        a(p());
        a((int) (p() ? l() : k()));
        this.f31987d = System.nanoTime();
        this.f31989f = 0;
        m();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f31984a;
    }

    @MainThread
    public void j() {
        n();
        b(p());
    }

    public float k() {
        com.ksad.lottie.d dVar = this.f31992i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31990g;
        return f2 == -2.1474836E9f ? dVar.d() : f2;
    }

    public float l() {
        com.ksad.lottie.d dVar = this.f31992i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31991h;
        return f2 == 2.1474836E9f ? dVar.e() : f2;
    }

    public void m() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void n() {
        c(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f31986c) {
            return;
        }
        this.f31986c = false;
        g();
    }
}
