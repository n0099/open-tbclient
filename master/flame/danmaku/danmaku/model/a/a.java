package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nKf;
    private final int nKg;
    private T nKh;
    private int nKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nKf = dVar;
        this.nKg = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dNi() {
        T dNh;
        if (this.nKh != null) {
            T t = this.nKh;
            this.nKh = (T) t.dNe();
            this.nKi--;
            dNh = t;
        } else {
            dNh = this.nKf.dNh();
        }
        if (dNh != null) {
            dNh.bX(null);
            dNh.wX(false);
            this.nKf.b(dNh);
        }
        return dNh;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dNc()) {
            if (this.mInfinite || this.nKi < this.nKg) {
                this.nKi++;
                t.bX(this.nKh);
                t.wX(true);
                this.nKh = t;
            }
            this.nKf.a(t);
        }
    }
}
