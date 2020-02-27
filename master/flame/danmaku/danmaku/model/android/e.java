package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nIa;
    private boolean nIb;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nHZ = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nHZ.f(i, i2, i3, z);
        this.mSize = this.nHZ.bitmap.getRowBytes() * this.nHZ.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dMx */
    public f get() {
        if (this.nHZ.bitmap == null) {
            return null;
        }
        return this.nHZ;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nHZ != null) {
            this.nHZ.recycle();
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
        this.nIa = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dMy */
    public e dMB() {
        return this.nIa;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dMz() {
        return this.nIb;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wP(boolean z) {
        this.nIb = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dMh() {
        return this.referenceCount > 0;
    }

    public synchronized void dMA() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dMi() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nHZ.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nHZ.height;
    }
}
