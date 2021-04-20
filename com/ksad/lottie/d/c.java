package com.ksad.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes6.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    public com.ksad.lottie.d i;

    /* renamed from: b  reason: collision with root package name */
    public float f31647b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31648c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f31649d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f31650e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f31651f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f31652g = -2.1474836E9f;

    /* renamed from: h  reason: collision with root package name */
    public float f31653h = 2.1474836E9f;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public boolean f31646a = false;

    private float o() {
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.f()) / Math.abs(this.f31647b);
    }

    private boolean p() {
        return h() < 0.0f;
    }

    private void q() {
        if (this.i == null) {
            return;
        }
        float f2 = this.f31650e;
        if (f2 < this.f31652g || f2 > this.f31653h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f31652g), Float.valueOf(this.f31653h), Float.valueOf(this.f31650e)));
        }
    }

    public void a(float f2) {
        this.f31647b = f2;
    }

    public void a(int i) {
        float f2 = i;
        if (this.f31650e == f2) {
            return;
        }
        this.f31650e = e.b(f2, k(), l());
        this.f31649d = System.nanoTime();
        c();
    }

    public void a(int i, int i2) {
        com.ksad.lottie.d dVar = this.i;
        float d2 = dVar == null ? -3.4028235E38f : dVar.d();
        com.ksad.lottie.d dVar2 = this.i;
        float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
        float f2 = i;
        this.f31652g = e.b(f2, d2, e2);
        float f3 = i2;
        this.f31653h = e.b(f3, d2, e2);
        a((int) e.b(this.f31650e, f2, f3));
    }

    public void a(com.ksad.lottie.d dVar) {
        int d2;
        float e2;
        boolean z = this.i == null;
        this.i = dVar;
        if (z) {
            d2 = (int) Math.max(this.f31652g, dVar.d());
            e2 = Math.min(this.f31653h, dVar.e());
        } else {
            d2 = (int) dVar.d();
            e2 = dVar.e();
        }
        a(d2, (int) e2);
        a((int) this.f31650e);
        this.f31649d = System.nanoTime();
    }

    public void b(int i) {
        a(i, (int) this.f31653h);
    }

    public void c(int i) {
        a((int) this.f31652g, i);
    }

    @MainThread
    public void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f31646a = false;
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
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f31650e - dVar.d()) / (this.i.e() - this.i.d());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        m();
        if (this.i == null || !isRunning()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float o = ((float) (nanoTime - this.f31649d)) / o();
        float f2 = this.f31650e;
        if (p()) {
            o = -o;
        }
        float f3 = f2 + o;
        this.f31650e = f3;
        boolean z = !e.c(f3, k(), l());
        this.f31650e = e.b(this.f31650e, k(), l());
        this.f31649d = nanoTime;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f31651f < getRepeatCount()) {
                a();
                this.f31651f++;
                if (getRepeatMode() == 2) {
                    this.f31648c = !this.f31648c;
                    g();
                } else {
                    this.f31650e = p() ? l() : k();
                }
                this.f31649d = nanoTime;
            } else {
                this.f31650e = l();
                n();
                b(p());
            }
        }
        q();
    }

    public float e() {
        return this.f31650e;
    }

    public void f() {
        this.i = null;
        this.f31652g = -2.1474836E9f;
        this.f31653h = 2.1474836E9f;
    }

    public void g() {
        a(-h());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float f2;
        float k;
        if (this.i == null) {
            return 0.0f;
        }
        if (p()) {
            f2 = l();
            k = this.f31650e;
        } else {
            f2 = this.f31650e;
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
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return 0L;
        }
        return dVar.c();
    }

    public float h() {
        return this.f31647b;
    }

    @MainThread
    public void i() {
        this.f31646a = true;
        a(p());
        a((int) (p() ? l() : k()));
        this.f31649d = System.nanoTime();
        this.f31651f = 0;
        m();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f31646a;
    }

    @MainThread
    public void j() {
        n();
        b(p());
    }

    public float k() {
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31652g;
        return f2 == -2.1474836E9f ? dVar.d() : f2;
    }

    public float l() {
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31653h;
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
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f31648c) {
            return;
        }
        this.f31648c = false;
        g();
    }
}
