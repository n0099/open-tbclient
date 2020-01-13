package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes4.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nHk;
    private final int nHl;
    private T nHm;
    private int nHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nHk = dVar;
        this.nHl = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dLq() {
        T dLp;
        if (this.nHm != null) {
            T t = this.nHm;
            this.nHm = (T) t.dLm();
            this.nHn--;
            dLp = t;
        } else {
            dLp = this.nHk.dLp();
        }
        if (dLp != null) {
            dLp.bW(null);
            dLp.wM(false);
            this.nHk.b(dLp);
        }
        return dLp;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dLk()) {
            if (this.mInfinite || this.nHn < this.nHl) {
                this.nHn++;
                t.bW(this.nHm);
                t.wM(true);
                this.nHm = t;
            }
            this.nHk.a(t);
        }
    }
}
