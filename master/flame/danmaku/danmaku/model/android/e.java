package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e pZU;
    private boolean pZV;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f pZT = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.pZT.f(i, i2, i3, z);
        this.mSize = this.pZT.bitmap.getRowBytes() * this.pZT.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: eDW */
    public f get() {
        if (this.pZT.bitmap == null) {
            return null;
        }
        return this.pZT;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.pZT != null) {
            this.pZT.recycle();
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
    public void ca(e eVar) {
        this.pZU = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: eDX */
    public e eEa() {
        return this.pZU;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean eDY() {
        return this.pZV;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void Bl(boolean z) {
        this.pZV = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean eDG() {
        return this.referenceCount > 0;
    }

    public synchronized void eDZ() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void eDH() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.pZT.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.pZT.height;
    }
}
