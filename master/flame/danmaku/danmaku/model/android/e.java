package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nVG;
    private boolean nVH;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nVF = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nVF.f(i, i2, i3, z);
        this.mSize = this.nVF.bitmap.getRowBytes() * this.nVF.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dSP */
    public f get() {
        if (this.nVF.bitmap == null) {
            return null;
        }
        return this.nVF;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nVF != null) {
            this.nVF.recycle();
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
    public void bO(e eVar) {
        this.nVG = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dSQ */
    public e dST() {
        return this.nVG;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dSR() {
        return this.nVH;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void xx(boolean z) {
        this.nVH = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dSz() {
        return this.referenceCount > 0;
    }

    public synchronized void dSS() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dSA() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nVF.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nVF.height;
    }
}
