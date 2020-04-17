package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> ndI;
    private final int ndJ;
    private T ndK;
    private int ndL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.ndI = dVar;
        this.ndJ = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dGi() {
        T dGh;
        if (this.ndK != null) {
            T t = this.ndK;
            this.ndK = (T) t.dGe();
            this.ndL--;
            dGh = t;
        } else {
            dGh = this.ndI.dGh();
        }
        if (dGh != null) {
            dGh.bG(null);
            dGh.wC(false);
            this.ndI.b(dGh);
        }
        return dGh;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dGc()) {
            if (this.mInfinite || this.ndL < this.ndJ) {
                this.ndL++;
                t.bG(this.ndK);
                t.wC(true);
                this.ndK = t;
            }
            this.ndI.a(t);
        }
    }
}
