package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes4.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nHp;
    private final int nHq;
    private T nHr;
    private int nHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nHp = dVar;
        this.nHq = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dLs() {
        T dLr;
        if (this.nHr != null) {
            T t = this.nHr;
            this.nHr = (T) t.dLo();
            this.nHs--;
            dLr = t;
        } else {
            dLr = this.nHp.dLr();
        }
        if (dLr != null) {
            dLr.bW(null);
            dLr.wM(false);
            this.nHp.b(dLr);
        }
        return dLr;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dLm()) {
            if (this.mInfinite || this.nHs < this.nHq) {
                this.nHs++;
                t.bW(this.nHr);
                t.wM(true);
                this.nHr = t;
            }
            this.nHp.a(t);
        }
    }
}
