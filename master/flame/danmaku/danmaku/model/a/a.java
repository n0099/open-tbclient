package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> oIr;
    private final int oIs;
    private T oIt;
    private int oIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.oIr = dVar;
        this.oIs = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T emD() {
        T emC;
        if (this.oIt != null) {
            T t = this.oIt;
            this.oIt = (T) t.emz();
            this.oIu--;
            emC = t;
        } else {
            emC = this.oIr.emC();
        }
        if (emC != null) {
            emC.bS(null);
            emC.ze(false);
            this.oIr.b(emC);
        }
        return emC;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.emx()) {
            if (this.mInfinite || this.oIu < this.oIs) {
                this.oIu++;
                t.bS(this.oIt);
                t.ze(true);
                this.oIt = t;
            }
            this.oIr.a(t);
        }
    }
}
