package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes5.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> nyN;
    private final int nyO;
    private T nyP;
    private int nyQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.nyN = dVar;
        this.nyO = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dNZ() {
        T dNY;
        if (this.nyP != null) {
            T t = this.nyP;
            this.nyP = (T) t.dNV();
            this.nyQ--;
            dNY = t;
        } else {
            dNY = this.nyN.dNY();
        }
        if (dNY != null) {
            dNY.bN(null);
            dNY.xa(false);
            this.nyN.b(dNY);
        }
        return dNY;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dNT()) {
            if (this.mInfinite || this.nyQ < this.nyO) {
                this.nyQ++;
                t.bN(this.nyP);
                t.xa(true);
                this.nyP = t;
            }
            this.nyN.a(t);
        }
    }
}
