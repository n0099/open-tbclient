package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nIn;
    private boolean nIo;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nIm = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nIm.f(i, i2, i3, z);
        this.mSize = this.nIm.bitmap.getRowBytes() * this.nIm.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dMA */
    public f get() {
        if (this.nIm.bitmap == null) {
            return null;
        }
        return this.nIm;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nIm != null) {
            this.nIm.recycle();
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
        this.nIn = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dMB */
    public e dME() {
        return this.nIn;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dMC() {
        return this.nIo;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wP(boolean z) {
        this.nIo = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dMk() {
        return this.referenceCount > 0;
    }

    public synchronized void dMD() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dMl() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nIm.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nIm.height;
    }
}
