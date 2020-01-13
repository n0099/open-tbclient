package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes4.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nHe;
    private boolean nHf;
    private int mSize = 0;
    private int nHg = 0;
    private final f nHd = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nHd.f(i, i2, i3, z);
        this.mSize = this.nHd.bitmap.getRowBytes() * this.nHd.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dLi */
    public f get() {
        if (this.nHd.bitmap == null) {
            return null;
        }
        return this.nHd;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nHd != null) {
            this.nHd.recycle();
        }
        this.mSize = 0;
        this.nHg = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int size() {
        return this.mSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: a */
    public void bW(e eVar) {
        this.nHe = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dLj */
    public e dLm() {
        return this.nHe;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dLk() {
        return this.nHf;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wM(boolean z) {
        this.nHf = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dKS() {
        return this.nHg > 0;
    }

    public synchronized void dLl() {
        this.nHg++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dKT() {
        this.nHg--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nHd.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nHd.height;
    }
}
