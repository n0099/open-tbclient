package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private int oeA;
    private final d<T> oex;
    private final int oey;
    private T oez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.oex = dVar;
        this.oey = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dWu() {
        T dWt;
        if (this.oez != null) {
            T t = this.oez;
            this.oez = (T) t.dWq();
            this.oeA--;
            dWt = t;
        } else {
            dWt = this.oex.dWt();
        }
        if (dWt != null) {
            dWt.bO(null);
            dWt.yc(false);
            this.oex.b(dWt);
        }
        return dWt;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dWo()) {
            if (this.mInfinite || this.oeA < this.oey) {
                this.oeA++;
                t.bO(this.oez);
                t.yc(true);
                this.oez = t;
            }
            this.oex.a(t);
        }
    }
}
