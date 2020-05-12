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
    public T dGf() {
        T dGe;
        if (this.ndN != null) {
            T t = this.ndN;
            this.ndN = (T) t.dGb();
            this.ndO--;
            dGe = t;
        } else {
            dGe = this.ndL.dGe();
        }
        if (dGe != null) {
            dGe.bH(null);
            dGe.wC(false);
            this.ndL.b(dGe);
        }
        return dGe;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dFZ()) {
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
