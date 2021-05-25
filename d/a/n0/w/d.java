package d.a.n0.w;

import d.a.n0.w.b;
/* loaded from: classes4.dex */
public final class d extends b<d> {
    public e t;
    public float u;
    public boolean v;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.t = null;
        this.u = Float.MAX_VALUE;
        this.v = false;
    }

    @Override // d.a.n0.w.b
    public void g() {
        k();
        this.t.g(d());
        super.g();
    }

    @Override // d.a.n0.w.b
    public boolean i(long j) {
        if (this.v) {
            float f2 = this.u;
            if (f2 != Float.MAX_VALUE) {
                this.t.e(f2);
                this.u = Float.MAX_VALUE;
            }
            this.f62436b = this.t.a();
            this.f62435a = 0.0f;
            this.v = false;
            return true;
        }
        if (this.u != Float.MAX_VALUE) {
            this.t.a();
            long j2 = j / 2;
            b.i h2 = this.t.h(this.f62436b, this.f62435a, j2);
            this.t.e(this.u);
            this.u = Float.MAX_VALUE;
            b.i h3 = this.t.h(h2.f62444a, h2.f62445b, j2);
            this.f62436b = h3.f62444a;
            this.f62435a = h3.f62445b;
        } else {
            b.i h4 = this.t.h(this.f62436b, this.f62435a, j);
            this.f62436b = h4.f62444a;
            this.f62435a = h4.f62445b;
        }
        float max = Math.max(this.f62436b, this.f62442h);
        this.f62436b = max;
        float min = Math.min(max, this.f62441g);
        this.f62436b = min;
        if (j(min, this.f62435a)) {
            this.f62436b = this.t.a();
            this.f62435a = 0.0f;
            return true;
        }
        return false;
    }

    public boolean j(float f2, float f3) {
        return this.t.c(f2, f3);
    }

    public final void k() {
        e eVar = this.t;
        if (eVar != null) {
            double a2 = eVar.a();
            if (a2 <= this.f62441g) {
                if (a2 < this.f62442h) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
                return;
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public d l(e eVar) {
        this.t = eVar;
        return this;
    }
}
