package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nIf;
    private final int nIg;
    private T nIh;
    private int nIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nIf = dVar;
        this.nIg = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dMF() {
        T dME;
        if (this.nIh != null) {
            T t = this.nIh;
            this.nIh = (T) t.dMB();
            this.nIi--;
            dME = t;
        } else {
            dME = this.nIf.dME();
        }
        if (dME != null) {
            dME.bX(null);
            dME.wP(false);
            this.nIf.b(dME);
        }
        return dME;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dMz()) {
            if (this.mInfinite || this.nIi < this.nIg) {
                this.nIi++;
                t.bX(this.nIh);
                t.wP(true);
                this.nIh = t;
            }
            this.nIf.a(t);
        }
    }
}
