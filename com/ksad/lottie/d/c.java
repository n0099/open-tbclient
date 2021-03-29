package com.ksad.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes6.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    public com.ksad.lottie.d i;

    /* renamed from: b  reason: collision with root package name */
    public float f31358b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31359c = false;

    /* renamed from: d  reason: collision with root package name */
    public long f31360d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f31361e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f31362f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f31363g = -2.1474836E9f;

    /* renamed from: h  reason: collision with root package name */
    public float f31364h = 2.1474836E9f;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public boolean f31357a = false;

    private float o() {
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.f()) / Math.abs(this.f31358b);
    }

    private boolean p() {
        return h() < 0.0f;
    }

    private void q() {
        if (this.i == null) {
            return;
        }
        float f2 = this.f31361e;
        if (f2 < this.f31363g || f2 > this.f31364h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f31363g), Float.valueOf(this.f31364h), Float.valueOf(this.f31361e)));
        }
    }

    public void a(float f2) {
        this.f31358b = f2;
    }

    public void a(int i) {
        float f2 = i;
        if (this.f31361e == f2) {
            return;
        }
        this.f31361e = e.b(f2, k(), l());
        this.f31360d = System.nanoTime();
        c();
    }

    public void a(int i, int i2) {
        com.ksad.lottie.d dVar = this.i;
        float d2 = dVar == null ? -3.4028235E38f : dVar.d();
        com.ksad.lottie.d dVar2 = this.i;
        float e2 = dVar2 == null ? Float.MAX_VALUE : dVar2.e();
        float f2 = i;
        this.f31363g = e.b(f2, d2, e2);
        float f3 = i2;
        this.f31364h = e.b(f3, d2, e2);
        a((int) e.b(this.f31361e, f2, f3));
    }

    public void a(com.ksad.lottie.d dVar) {
        int d2;
        float e2;
        boolean z = this.i == null;
        this.i = dVar;
        if (z) {
            d2 = (int) Math.max(this.f31363g, dVar.d());
            e2 = Math.min(this.f31364h, dVar.e());
        } else {
            d2 = (int) dVar.d();
            e2 = dVar.e();
        }
        a(d2, (int) e2);
        a((int) this.f31361e);
        this.f31360d = System.nanoTime();
    }

    public void b(int i) {
        a(i, (int) this.f31364h);
    }

    public void c(int i) {
        a((int) this.f31363g, i);
    }

    @MainThread
    public void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f31357a = false;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        b();
        n();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float d() {
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f31361e - dVar.d()) / (this.i.e() - this.i.d());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        m();
        if (this.i == null || !isRunning()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float o = ((float) (nanoTime - this.f31360d)) / o();
        float f2 = this.f31361e;
        if (p()) {
            o = -o;
        }
        float f3 = f2 + o;
        this.f31361e = f3;
        boolean z = !e.c(f3, k(), l());
        this.f31361e = e.b(this.f31361e, k(), l());
        this.f31360d = nanoTime;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f31362f < getRepeatCount()) {
                a();
                this.f31362f++;
                if (getRepeatMode() == 2) {
                    this.f31359c = !this.f31359c;
                    g();
                } else {
                    this.f31361e = p() ? l() : k();
                }
                this.f31360d = nanoTime;
            } else {
                this.f31361e = l();
                n();
                b(p());
            }
        }
        q();
    }

    public float e() {
        return this.f31361e;
    }

    public void f() {
        this.i = null;
        this.f31363g = -2.1474836E9f;
        this.f31364h = 2.1474836E9f;
    }

    public void g() {
        a(-h());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        float f2;
        float k;
        if (this.i == null) {
            return 0.0f;
        }
        if (p()) {
            f2 = l();
            k = this.f31361e;
        } else {
            f2 = this.f31361e;
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
        return this.f31358b;
    }

    @MainThread
    public void i() {
        this.f31357a = true;
        a(p());
        a((int) (p() ? l() : k()));
        this.f31360d = System.nanoTime();
        this.f31362f = 0;
        m();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f31357a;
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
        float f2 = this.f31363g;
        return f2 == -2.1474836E9f ? dVar.d() : f2;
    }

    public float l() {
        com.ksad.lottie.d dVar = this.i;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f31364h;
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
        if (i == 2 || !this.f31359c) {
            return;
        }
        this.f31359c = false;
        g();
    }
}
