package com.ksad.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes4.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.ksad.lottie.d i;

    /* renamed from: b  reason: collision with root package name */
    private float f7986b = 1.0f;
    private boolean c = false;
    private long d = 0;
    private float e = 0.0f;
    private int f = 0;
    private float g = -2.1474836E9f;
    private float h = 2.1474836E9f;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    protected boolean f7985a = false;

    private float o() {
        if (this.i == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.i.f()) / Math.abs(this.f7986b);
    }

    private boolean p() {
        return h() < 0.0f;
    }

    private void q() {
        if (this.i == null) {
            return;
        }
        if (this.e < this.g || this.e > this.h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(this.e)));
        }
    }

    public void a(float f) {
        this.f7986b = f;
    }

    public void a(int i) {
        if (this.e == i) {
            return;
        }
        this.e = e.b(i, k(), l());
        this.d = System.nanoTime();
        c();
    }

    public void a(int i, int i2) {
        float d = this.i == null ? -3.4028235E38f : this.i.d();
        float e = this.i == null ? Float.MAX_VALUE : this.i.e();
        this.g = e.b(i, d, e);
        this.h = e.b(i2, d, e);
        a((int) e.b(this.e, i, i2));
    }

    public void a(com.ksad.lottie.d dVar) {
        boolean z = this.i == null;
        this.i = dVar;
        if (z) {
            a((int) Math.max(this.g, dVar.d()), (int) Math.min(this.h, dVar.e()));
        } else {
            a((int) dVar.d(), (int) dVar.e());
        }
        a((int) this.e);
        this.d = System.nanoTime();
    }

    public void b(int i) {
        a(i, (int) this.h);
    }

    public void c(int i) {
        a((int) this.g, i);
    }

    @MainThread
    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f7985a = false;
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
        if (this.i == null) {
            return 0.0f;
        }
        return (this.e - this.i.d()) / (this.i.e() - this.i.d());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        m();
        if (this.i == null || !isRunning()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float o = ((float) (nanoTime - this.d)) / o();
        float f = this.e;
        if (p()) {
            o = -o;
        }
        this.e = o + f;
        boolean z = !e.c(this.e, k(), l());
        this.e = e.b(this.e, k(), l());
        this.d = nanoTime;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f < getRepeatCount()) {
                a();
                this.f++;
                if (getRepeatMode() == 2) {
                    this.c = this.c ? false : true;
                    g();
                } else {
                    this.e = p() ? l() : k();
                }
                this.d = nanoTime;
            } else {
                this.e = l();
                n();
                b(p());
            }
        }
        q();
    }

    public float e() {
        return this.e;
    }

    public void f() {
        this.i = null;
        this.g = -2.1474836E9f;
        this.h = 2.1474836E9f;
    }

    public void g() {
        a(-h());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.i == null) {
            return 0.0f;
        }
        return p() ? (l() - this.e) / (l() - k()) : (this.e - k()) / (l() - k());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.i == null) {
            return 0L;
        }
        return this.i.c();
    }

    public float h() {
        return this.f7986b;
    }

    @MainThread
    public void i() {
        this.f7985a = true;
        a(p());
        a((int) (p() ? l() : k()));
        this.d = System.nanoTime();
        this.f = 0;
        m();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f7985a;
    }

    @MainThread
    public void j() {
        n();
        b(p());
    }

    public float k() {
        if (this.i == null) {
            return 0.0f;
        }
        return this.g == -2.1474836E9f ? this.i.d() : this.g;
    }

    public float l() {
        if (this.i == null) {
            return 0.0f;
        }
        return this.h == 2.1474836E9f ? this.i.e() : this.h;
    }

    protected void m() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void n() {
        c(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.c) {
            return;
        }
        this.c = false;
        g();
    }
}
