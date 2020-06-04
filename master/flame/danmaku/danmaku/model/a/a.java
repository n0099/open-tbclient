package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private int nAa;
    private final d<T> nzX;
    private final int nzY;
    private T nzZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nzX = dVar;
        this.nzY = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dOn() {
        T dOm;
        if (this.nzZ != null) {
            T t = this.nzZ;
            this.nzZ = (T) t.dOj();
            this.nAa--;
            dOm = t;
        } else {
            dOm = this.nzX.dOm();
        }
        if (dOm != null) {
            dOm.bN(null);
            dOm.xc(false);
            this.nzX.b(dOm);
        }
        return dOm;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dOh()) {
            if (this.mInfinite || this.nAa < this.nzY) {
                this.nAa++;
                t.bN(this.nzZ);
                t.xc(true);
                this.nzZ = t;
            }
            this.nzX.a(t);
        }
    }
}
