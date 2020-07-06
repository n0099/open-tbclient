package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nVL;
    private final int nVM;
    private T nVN;
    private int nVO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nVL = dVar;
        this.nVM = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dSX() {
        T dSW;
        if (this.nVN != null) {
            T t = this.nVN;
            this.nVN = (T) t.dST();
            this.nVO--;
            dSW = t;
        } else {
            dSW = this.nVL.dSW();
        }
        if (dSW != null) {
            dSW.bO(null);
            dSW.xx(false);
            this.nVL.b(dSW);
        }
        return dSW;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dSR()) {
            if (this.mInfinite || this.nVO < this.nVM) {
                this.nVO++;
                t.bO(this.nVN);
                t.xx(true);
                this.nVN = t;
            }
            this.nVL.a(t);
        }
    }
}
