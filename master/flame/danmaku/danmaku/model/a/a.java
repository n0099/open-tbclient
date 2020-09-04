package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> oyM;
    private final int oyN;
    private T oyO;
    private int oyP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.oyM = dVar;
        this.oyN = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T eiG() {
        T eiF;
        if (this.oyO != null) {
            T t = this.oyO;
            this.oyO = (T) t.eiC();
            this.oyP--;
            eiF = t;
        } else {
            eiF = this.oyM.eiF();
        }
        if (eiF != null) {
            eiF.bQ(null);
            eiF.yW(false);
            this.oyM.b(eiF);
        }
        return eiF;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.eiA()) {
            if (this.mInfinite || this.oyP < this.oyN) {
                this.oyP++;
                t.bQ(this.oyO);
                t.yW(true);
                this.oyO = t;
            }
            this.oyM.a(t);
        }
    }
}
