package d.a.a.x;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {
    @Nullable
    public d.a.a.d n;

    /* renamed from: g  reason: collision with root package name */
    public float f41789g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41790h = false;
    public long i = 0;
    public float j = 0.0f;
    public int k = 0;
    public float l = -2.1474836E9f;
    public float m = 2.1474836E9f;
    @VisibleForTesting
    public boolean o = false;

    public void A(int i) {
        z(i, (int) this.m);
    }

    public void B(float f2) {
        this.f41789g = f2;
    }

    public final void C() {
        if (this.n == null) {
            return;
        }
        float f2 = this.j;
        if (f2 < this.l || f2 > this.m) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.l), Float.valueOf(this.m), Float.valueOf(this.j)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        b();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        r();
        if (this.n == null || !isRunning()) {
            return;
        }
        d.a.a.c.a("LottieValueAnimator#doFrame");
        long j2 = this.i;
        float k = ((float) (j2 != 0 ? j - j2 : 0L)) / k();
        float f2 = this.j;
        if (o()) {
            k = -k;
        }
        float f3 = f2 + k;
        this.j = f3;
        boolean z = !g.e(f3, m(), l());
        this.j = g.c(this.j, m(), l());
        this.i = j;
        f();
        if (z) {
            if (getRepeatCount() != -1 && this.k >= getRepeatCount()) {
                this.j = this.f41789g < 0.0f ? m() : l();
                s();
                c(o());
            } else {
                d();
                this.k++;
                if (getRepeatMode() == 2) {
                    this.f41790h = !this.f41790h;
                    v();
                } else {
                    this.j = o() ? l() : m();
                }
                this.i = j;
            }
        }
        C();
        d.a.a.c.b("LottieValueAnimator#doFrame");
    }

    public void g() {
        this.n = null;
        this.l = -2.1474836E9f;
        this.m = 2.1474836E9f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float m;
        float l;
        float m2;
        if (this.n == null) {
            return 0.0f;
        }
        if (o()) {
            m = l() - this.j;
            l = l();
            m2 = m();
        } else {
            m = this.j - m();
            l = l();
            m2 = m();
        }
        return m / (l - m2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(i());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        d.a.a.d dVar = this.n;
        if (dVar == null) {
            return 0L;
        }
        return dVar.d();
    }

    @MainThread
    public void h() {
        s();
        c(o());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float i() {
        d.a.a.d dVar = this.n;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.j - dVar.o()) / (this.n.f() - this.n.o());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.o;
    }

    public float j() {
        return this.j;
    }

    public final float k() {
        d.a.a.d dVar = this.n;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h()) / Math.abs(this.f41789g);
    }

    public float l() {
        d.a.a.d dVar = this.n;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.m;
        return f2 == 2.1474836E9f ? dVar.f() : f2;
    }

    public float m() {
        d.a.a.d dVar = this.n;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.l;
        return f2 == -2.1474836E9f ? dVar.o() : f2;
    }

    public float n() {
        return this.f41789g;
    }

    public final boolean o() {
        return n() < 0.0f;
    }

    @MainThread
    public void p() {
        s();
    }

    @MainThread
    public void q() {
        this.o = true;
        e(o());
        x((int) (o() ? l() : m()));
        this.i = 0L;
        this.k = 0;
        r();
    }

    public void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f41790h) {
            return;
        }
        this.f41790h = false;
        v();
    }

    @MainThread
    public void t(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.o = false;
        }
    }

    @MainThread
    public void u() {
        this.o = true;
        r();
        this.i = 0L;
        if (o() && j() == m()) {
            this.j = l();
        } else if (o() || j() != l()) {
        } else {
            this.j = m();
        }
    }

    public void v() {
        B(-n());
    }

    public void w(d.a.a.d dVar) {
        boolean z = this.n == null;
        this.n = dVar;
        if (z) {
            z((int) Math.max(this.l, dVar.o()), (int) Math.min(this.m, dVar.f()));
        } else {
            z((int) dVar.o(), (int) dVar.f());
        }
        float f2 = this.j;
        this.j = 0.0f;
        x((int) f2);
        f();
    }

    public void x(float f2) {
        if (this.j == f2) {
            return;
        }
        this.j = g.c(f2, m(), l());
        this.i = 0L;
        f();
    }

    public void y(float f2) {
        z(this.l, f2);
    }

    public void z(float f2, float f3) {
        if (f2 <= f3) {
            d.a.a.d dVar = this.n;
            float o = dVar == null ? -3.4028235E38f : dVar.o();
            d.a.a.d dVar2 = this.n;
            float f4 = dVar2 == null ? Float.MAX_VALUE : dVar2.f();
            this.l = g.c(f2, o, f4);
            this.m = g.c(f3, o, f4);
            x((int) g.c(this.j, f2, f3));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }
}
