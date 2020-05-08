package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> ndL;
    private final int ndM;
    private T ndN;
    private int ndO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.ndL = dVar;
        this.ndM = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dGe() {
        T dGd;
        if (this.ndN != null) {
            T t = this.ndN;
            this.ndN = (T) t.dGa();
            this.ndO--;
            dGd = t;
        } else {
            dGd = this.ndL.dGd();
        }
        if (dGd != null) {
            dGd.bH(null);
            dGd.wC(false);
            this.ndL.b(dGd);
        }
        return dGd;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dFY()) {
            if (this.mInfinite || this.ndO < this.ndM) {
                this.ndO++;
                t.bH(this.ndN);
                t.wC(true);
                this.ndN = t;
            }
            this.ndL.a(t);
        }
    }
}
