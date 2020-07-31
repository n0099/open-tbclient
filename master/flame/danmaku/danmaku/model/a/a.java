package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> oev;
    private final int oew;
    private T oex;
    private int oey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.oev = dVar;
        this.oew = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T dWt() {
        T dWs;
        if (this.oex != null) {
            T t = this.oex;
            this.oex = (T) t.dWp();
            this.oey--;
            dWs = t;
        } else {
            dWs = this.oev.dWs();
        }
        if (dWs != null) {
            dWs.bO(null);
            dWs.yc(false);
            this.oev.b(dWs);
        }
        return dWs;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.dWn()) {
            if (this.mInfinite || this.oey < this.oew) {
                this.oey++;
                t.bO(this.oex);
                t.yc(true);
                this.oex = t;
            }
            this.oev.a(t);
        }
    }
}
