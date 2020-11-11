package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e pYr;
    private boolean pYs;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f pYq = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.pYq.f(i, i2, i3, z);
        this.mSize = this.pYq.bitmap.getRowBytes() * this.pYq.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: eDV */
    public f get() {
        if (this.pYq.bitmap == null) {
            return null;
        }
        return this.pYq;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.pYq != null) {
            this.pYq.recycle();
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
    public void bZ(e eVar) {
        this.pYr = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: eDW */
    public e eDZ() {
        return this.pYr;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean eDX() {
        return this.pYs;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void Be(boolean z) {
        this.pYs = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean eDF() {
        return this.referenceCount > 0;
    }

    public synchronized void eDY() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void eDG() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.pYq.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.pYq.height;
    }
}
