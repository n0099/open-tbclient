package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final int mLimit;
    private final d<T> pPc;
    private T pPd;
    private int pPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.pPc = dVar;
        this.mLimit = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T eAo() {
        T eAn;
        if (this.pPd != null) {
            T t = this.pPd;
            this.pPd = (T) t.eAk();
            this.pPe--;
            eAn = t;
        } else {
            eAn = this.pPc.eAn();
        }
        if (eAn != null) {
            eAn.bZ(null);
            eAn.AT(false);
            this.pPc.b(eAn);
        }
        return eAn;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.eAi()) {
            if (this.mInfinite || this.pPe < this.mLimit) {
                this.pPe++;
                t.bZ(this.pPd);
                t.AT(true);
                this.pPd = t;
            }
            this.pPc.a(t);
        }
    }
}
