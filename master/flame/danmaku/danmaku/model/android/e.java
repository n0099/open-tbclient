package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nzS;
    private boolean nzT;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f nzR = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nzR.f(i, i2, i3, z);
        this.mSize = this.nzR.bitmap.getRowBytes() * this.nzR.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dOf */
    public f get() {
        if (this.nzR.bitmap == null) {
            return null;
        }
        return this.nzR;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nzR != null) {
            this.nzR.recycle();
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
        this.nzS = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dOg */
    public e dOj() {
        return this.nzS;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dOh() {
        return this.nzT;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void xc(boolean z) {
        this.nzT = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dNP() {
        return this.referenceCount > 0;
    }

    public synchronized void dOi() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dNQ() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nzR.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nzR.height;
    }
}
