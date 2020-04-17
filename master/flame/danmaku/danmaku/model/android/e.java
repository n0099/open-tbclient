package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e ndD;
    private boolean ndE;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f ndC = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.ndC.f(i, i2, i3, z);
        this.mSize = this.ndC.bitmap.getRowBytes() * this.ndC.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dGa */
    public f get() {
        if (this.ndC.bitmap == null) {
            return null;
        }
        return this.ndC;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.ndC != null) {
            this.ndC.recycle();
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
    public void bG(e eVar) {
        this.ndD = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dGb */
    public e dGe() {
        return this.ndD;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dGc() {
        return this.ndE;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wC(boolean z) {
        this.ndE = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dFK() {
        return this.referenceCount > 0;
    }

    public synchronized void dGd() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dFL() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.ndC.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.ndC.height;
    }
}
