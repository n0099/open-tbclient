package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nKa;
    private boolean nKb;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nJZ = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nJZ.f(i, i2, i3, z);
        this.mSize = this.nJZ.bitmap.getRowBytes() * this.nJZ.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dNa */
    public f get() {
        if (this.nJZ.bitmap == null) {
            return null;
        }
        return this.nJZ;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nJZ != null) {
            this.nJZ.recycle();
        }
        this.mSize = 0;
        this.referenceCount = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int size() {
        return this.mSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: a */
    public void bX(e eVar) {
        this.nKa = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dNb */
    public e dNe() {
        return this.nKa;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dNc() {
        return this.nKb;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wX(boolean z) {
        this.nKb = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dMK() {
        return this.referenceCount > 0;
    }

    public synchronized void dNd() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dML() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nJZ.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nJZ.height;
    }
}
