package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nVI;
    private final int nVJ;
    private T nVK;
    private int nVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nVI = dVar;
        this.nVJ = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dST() {
        T dSS;
        if (this.nVK != null) {
            T t = this.nVK;
            this.nVK = (T) t.dSP();
            this.nVL--;
            dSS = t;
        } else {
            dSS = this.nVI.dSS();
        }
        if (dSS != null) {
            dSS.bO(null);
            dSS.xx(false);
            this.nVI.b(dSS);
        }
        return dSS;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dSN()) {
            if (this.mInfinite || this.nVL < this.nVJ) {
                this.nVL++;
                t.bO(this.nVK);
                t.xx(true);
                this.nVK = t;
            }
            this.nVI.a(t);
        }
    }
}
