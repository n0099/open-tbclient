package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final int mLimit;
    private final d<T> pZZ;
    private T qaa;
    private int qab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.pZZ = dVar;
        this.mLimit = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T eEe() {
        T eEd;
        if (this.qaa != null) {
            T t = this.qaa;
            this.qaa = (T) t.eEa();
            this.qab--;
            eEd = t;
        } else {
            eEd = this.pZZ.eEd();
        }
        if (eEd != null) {
            eEd.ca(null);
            eEd.Bl(false);
            this.pZZ.b(eEd);
        }
        return eEd;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.eDY()) {
            if (this.mInfinite || this.qab < this.mLimit) {
                this.qab++;
                t.ca(this.qaa);
                t.Bl(true);
                this.qaa = t;
            }
            this.pZZ.a(t);
        }
    }
}
