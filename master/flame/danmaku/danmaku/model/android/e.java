package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nVD;
    private boolean nVE;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nVC = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nVC.f(i, i2, i3, z);
        this.mSize = this.nVC.bitmap.getRowBytes() * this.nVC.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dSL */
    public f get() {
        if (this.nVC.bitmap == null) {
            return null;
        }
        return this.nVC;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nVC != null) {
            this.nVC.recycle();
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
        this.nVD = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dSM */
    public e dSP() {
        return this.nVD;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dSN() {
        return this.nVE;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void xx(boolean z) {
        this.nVE = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dSv() {
        return this.referenceCount > 0;
    }

    public synchronized void dSO() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dSw() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nVC.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nVC.height;
    }
}
