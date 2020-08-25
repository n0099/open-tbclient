package master.flame.danmaku.danmaku.model.a;

import master.flame.danmaku.danmaku.model.a.c;
/* loaded from: classes6.dex */
class a<T extends c<T>> implements b<T> {
    private final boolean mInfinite;
    private final d<T> oyu;
    private final int oyv;
    private T oyw;
    private int oyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d<T> dVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.oyu = dVar;
        this.oyv = i;
        this.mInfinite = false;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public T eix() {
        T eiw;
        if (this.oyw != null) {
            T t = this.oyw;
            this.oyw = (T) t.eit();
            this.oyx--;
            eiw = t;
        } else {
            eiw = this.oyu.eiw();
        }
        if (eiw != null) {
            eiw.bQ(null);
            eiw.yU(false);
            this.oyu.b(eiw);
        }
        return eiw;
    }

    @Override // master.flame.danmaku.danmaku.model.a.b
    public void c(T t) {
        if (!t.eir()) {
            if (this.mInfinite || this.oyx < this.oyv) {
                this.oyx++;
                t.bQ(this.oyw);
                t.yU(true);
                this.oyw = t;
            }
            this.oyu.a(t);
        }
    }
}
