package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final int mLimit;
    private final d<T> pYw;
    private T pYx;
    private int pYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.pYw = dVar;
        this.mLimit = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T eEd() {
        T eEc;
        if (this.pYx != null) {
            T t = this.pYx;
            this.pYx = (T) t.eDZ();
            this.pYy--;
            eEc = t;
        } else {
            eEc = this.pYw.eEc();
        }
        if (eEc != null) {
            eEc.bZ(null);
            eEc.Be(false);
            this.pYw.b(eEc);
        }
        return eEc;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.eDX()) {
            if (this.mInfinite || this.pYy < this.mLimit) {
                this.pYy++;
                t.bZ(this.pYx);
                t.Be(true);
                this.pYx = t;
            }
            this.pYw.a(t);
        }
    }
}
