package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e oXB;
    private boolean oXC;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f oXA = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.oXA.f(i, i2, i3, z);
        this.mSize = this.oXA.bitmap.getRowBytes() * this.oXA.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: eqi */
    public f get() {
        if (this.oXA.bitmap == null) {
            return null;
        }
        return this.oXA;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.oXA != null) {
            this.oXA.recycle();
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
    public void bV(e eVar) {
        this.oXB = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: eqj */
    public e eqm() {
        return this.oXB;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean eqk() {
        return this.oXC;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void zL(boolean z) {
        this.oXC = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean epS() {
        return this.referenceCount > 0;
    }

    public synchronized void eql() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void epT() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.oXA.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.oXA.height;
    }
}
