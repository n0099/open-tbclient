package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final int mLimit;
    private final d<T> oXG;
    private T oXH;
    private int oXI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.oXG = dVar;
        this.mLimit = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T eqq() {
        T eqp;
        if (this.oXH != null) {
            T t = this.oXH;
            this.oXH = (T) t.eqm();
            this.oXI--;
            eqp = t;
        } else {
            eqp = this.oXG.eqp();
        }
        if (eqp != null) {
            eqp.bV(null);
            eqp.zL(false);
            this.oXG.b(eqp);
        }
        return eqp;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.eqk()) {
            if (this.mInfinite || this.oXI < this.mLimit) {
                this.oXI++;
                t.bV(this.oXH);
                t.zL(true);
                this.oXH = t;
            }
            this.oXG.a(t);
        }
    }
}
