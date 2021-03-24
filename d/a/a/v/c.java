package d.a.a.v;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    public d.a.a.d n;

    /* renamed from: g  reason: collision with root package name */
    public float f41439g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41440h = false;
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
        this.f41439g = f2;
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
        long nanoTime = System.nanoTime();
        float k = ((float) (nanoTime - this.i)) / k();
        float f2 = this.j;
        if (o()) {
            k = -k;
        }
        float f3 = f2 + k;
        this.j = f3;
        boolean z = !e.d(f3, m(), l());
        this.j = e.b(this.j, m(), l());
        this.i = nanoTime;
        f();
        if (z) {
            if (getRepeatCount() != -1 && this.k >= getRepeatCount()) {
                this.j = l();
                s();
                c(o());
            } else {
                d();
                this.k++;
                if (getRepeatMode() == 2) {
                    this.f41440h = !this.f41440h;
                    v();
                } else {
                    this.j = o() ? l() : m();
                }
                this.i = nanoTime;
            }
        }
        C();
    }

    public void g() {
        this.n = null;
        this.l = -2.1474836E9f;
        this.m = 2.1474836E9f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
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

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float i() {
        d.a.a.d dVar = this.n;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.j - dVar.m()) / (this.n.f() - this.n.m());
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
        return (1.0E9f / dVar.h()) / Math.abs(this.f41439g);
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
        return f2 == -2.1474836E9f ? dVar.m() : f2;
    }

    public float n() {
        return this.f41439g;
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
        this.i = System.nanoTime();
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
        if (i == 2 || !this.f41440h) {
            return;
        }
        this.f41440h = false;
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
        this.i = System.nanoTime();
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
            z((int) Math.max(this.l, dVar.m()), (int) Math.min(this.m, dVar.f()));
        } else {
            z((int) dVar.m(), (int) dVar.f());
        }
        x((int) this.j);
        this.i = System.nanoTime();
    }

    public void x(int i) {
        float f2 = i;
        if (this.j == f2) {
            return;
        }
        this.j = e.b(f2, m(), l());
        this.i = System.nanoTime();
        f();
    }

    public void y(int i) {
        z((int) this.l, i);
    }

    public void z(int i, int i2) {
        d.a.a.d dVar = this.n;
        float m = dVar == null ? -3.4028235E38f : dVar.m();
        d.a.a.d dVar2 = this.n;
        float f2 = dVar2 == null ? Float.MAX_VALUE : dVar2.f();
        float f3 = i;
        this.l = e.b(f3, m, f2);
        float f4 = i2;
        this.m = e.b(f4, m, f2);
        x((int) e.b(this.j, f3, f4));
    }
}
