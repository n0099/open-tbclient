package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e pOX;
    private boolean pOY;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f pOW = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.pOW.f(i, i2, i3, z);
        this.mSize = this.pOW.bitmap.getRowBytes() * this.pOW.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: eAg */
    public f get() {
        if (this.pOW.bitmap == null) {
            return null;
        }
        return this.pOW;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.pOW != null) {
            this.pOW.recycle();
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
        this.pOX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: eAh */
    public e eAk() {
        return this.pOX;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean eAi() {
        return this.pOY;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void AT(boolean z) {
        this.pOY = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean ezQ() {
        return this.referenceCount > 0;
    }

    public synchronized void eAj() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void ezR() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.pOW.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.pOW.height;
    }
}
