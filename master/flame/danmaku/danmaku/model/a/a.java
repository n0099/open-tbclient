package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nIh;
    private final int nIi;
    private T nIj;
    private int nIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nIh = dVar;
        this.nIi = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dMH() {
        T dMG;
        if (this.nIj != null) {
            T t = this.nIj;
            this.nIj = (T) t.dMD();
            this.nIk--;
            dMG = t;
        } else {
            dMG = this.nIh.dMG();
        }
        if (dMG != null) {
            dMG.bX(null);
            dMG.wP(false);
            this.nIh.b(dMG);
        }
        return dMG;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dMB()) {
            if (this.mInfinite || this.nIk < this.nIi) {
                this.nIk++;
                t.bX(this.nIj);
                t.wP(true);
                this.nIj = t;
            }
            this.nIh.a(t);
        }
    }
}
