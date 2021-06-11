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
    public com.ksad.lottie.d f31894i;

    /* renamed from: b  reason: collision with root package name */
    public float f31887b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31888c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f31889d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f31890e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f31891f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f31892g = -2.1474836E9f;

    /* renamed from: h  reason: collision with root package name */
    public float f31893h = 2.1474836E9f;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public boolean f31886a = false;

    private float o() {
        com.ksad.lottie.d dVar = this.f31894i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.f()) / Math.abs(this.f31887b);
    }

    private boolean p() {
        return h() < 0.0f;
    }

    private void q() {
        if (this.f31894i == null) {
            return;
        }
        float f2 = this.f31890e;
        if (f2 < this.f31892g || f2 > this.f31893h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f31892g), Float.valueOf(this.f31893h), Float.valueOf(this.f31890e)));
        }
    }

    public void a(float f2) {
        this.f31887b = f2;
    }

    public void a(int i2) {
        float f2 = i2;
        if (this.f31890e == f2) {
            return;
        }
        this.f31890e = e.b(f2, k(), l());
        this.f31889d = System.nanoTime();
        c();
    }

    public void a(int i2, int i3) {
        com.ksad.lottie.d dVar = this.f31894i;
        float d2 = dVar == null ? -3.4028235E38f : dVar.d();
        com.ksad.lottie.d dVar2 = this.f31894i;
        float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
        float f2 = i2;
        this.f31892g = e.b(f2, d2, e2);
        float f3 = i3;
        this.f31893h = e.b(f3, d2, e2);
        a((int) e.b(this.f31890e, f2, f3));
    }

    public void a(com.ksad.lottie.d dVar) {
        int d2;
        float e2;
        boolean z = this.f31894i == null;
        this.f31894i = dVar;
        if (z) {
            d2 = (int) Math.max(this.f31892g, dVar.d());
            e2 = Math.min(this.f31893h, dVar.e());
        } else {
            d2 = (int) dVar.d();
            e2 = dVar.e();
        }
        a(d2, (int) e2);
        a((int) this.f31890e);
        this.f31889d = System.nanoTime();
    }

    public void b(int i2) {
        a(i2, (int) this.f31893h);
    }

    public void c(int i2) {
        a((int) this.f31892g, i2);
    }

    @MainThread
    public void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f31886a = false;
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
        com.ksad.lottie.d dVar = this.f31894i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f31890e - dVar.d()) / (this.f31894i.e() - this.f31894i.d());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        m();
        if (this.f31894i == null || !isRunning()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float o = ((float) (nanoTime - this.f31889d)) / o();
        float f2 = this.f31890e;
        if (p()) {
            o = -o;
        }
        float f3 = f2 + o;
        this.f31890e = f3;
        boolean z = !e.c(f3, k(), l());
        this.f31890e = e.b(this.f31890e, k(), l());
        this.f31889d = nanoTime;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f31891f < getRepeatCount()) {
                a();
                this.f31891f++;
                if (getRepeatMode() == 2) {
                    this.f31888c = !this.f31888c;
                    g();
                } else {
                    this.f31890e = p() ? l() : k();
                }
                this.f31889d = nanoTime;
            } else {
                this.f31890e = l();
                n();
                b(p());
            }
        }
        q();
    }

    public float e() {
        return this.f31890e;
    }

    public void f() {
        this.f31894i = null;
        this.f31892g = -2.1474836E9f;
        this.f31893h = 2.1474836E9f;
    }

    public void g() {
        a(-h());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float f2;
        float k;
        if (this.f31894i == null) {
            return 0.0f;
        }
        if (p()) {
            f2 = l();
            k = this.f31890e;
        } else {
            f2 = this.f31890e;
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
        com.ksad.lottie.d dVar = this.f31894i;
        if (dVar == null) {
            return 0L;
        }
        return dVar.c();
    }

    public float h() {
        return this.f31887b;
    }

    @MainThread
    public void i() {
        this.f31886a = true;
        a(p());
        a((int) (p() ? l() : k()));
        this.f31889d = System.nanoTime();
        this.f31891f = 0;
        m();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f31886a;
    }

    @MainThread
    public void j() {
        n();
        b(p());
    }

    public float k() {
        com.ksad.lottie.d dVar = this.f31894i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31892g;
        return f2 == -2.1474836E9f ? dVar.d() : f2;
    }

    public float l() {
        com.ksad.lottie.d dVar = this.f31894i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31893h;
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
        if (i2 == 2 || !this.f31888c) {
            return;
        }
        this.f31888c = false;
        g();
    }
}
