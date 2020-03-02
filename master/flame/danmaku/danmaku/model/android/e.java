package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nIc;
    private boolean nId;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nIb = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nIb.f(i, i2, i3, z);
        this.mSize = this.nIb.bitmap.getRowBytes() * this.nIb.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dMz */
    public f get() {
        if (this.nIb.bitmap == null) {
            return null;
        }
        return this.nIb;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nIb != null) {
            this.nIb.recycle();
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
        this.nIc = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dMA */
    public e dMD() {
        return this.nIc;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dMB() {
        return this.nId;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wP(boolean z) {
        this.nId = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dMj() {
        return this.referenceCount > 0;
    }

    public synchronized void dMC() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dMk() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nIb.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nIb.height;
    }
}
