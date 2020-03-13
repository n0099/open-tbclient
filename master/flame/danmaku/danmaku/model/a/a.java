package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nIs;
    private final int nIt;
    private T nIu;
    private int nIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nIs = dVar;
        this.nIt = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dMI() {
        T dMH;
        if (this.nIu != null) {
            T t = this.nIu;
            this.nIu = (T) t.dME();
            this.nIv--;
            dMH = t;
        } else {
            dMH = this.nIs.dMH();
        }
        if (dMH != null) {
            dMH.bX(null);
            dMH.wP(false);
            this.nIs.b(dMH);
        }
        return dMH;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dMC()) {
            if (this.mInfinite || this.nIv < this.nIt) {
                this.nIv++;
                t.bX(this.nIu);
                t.wP(true);
                this.nIu = t;
            }
            this.nIs.a(t);
        }
    }
}
