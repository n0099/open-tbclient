package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nyI;
    private boolean nyJ;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nyH = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nyH.f(i, i2, i3, z);
        this.mSize = this.nyH.bitmap.getRowBytes() * this.nyH.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dNR */
    public f get() {
        if (this.nyH.bitmap == null) {
            return null;
        }
        return this.nyH;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nyH != null) {
            this.nyH.recycle();
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
    public void bN(e eVar) {
        this.nyI = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dNS */
    public e dNV() {
        return this.nyI;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dNT() {
        return this.nyJ;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void xa(boolean z) {
        this.nyJ = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dNB() {
        return this.referenceCount > 0;
    }

    public synchronized void dNU() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dNC() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nyH.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nyH.height;
    }
}
