package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e oeq;
    private boolean oer;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f oep = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.oep.f(i, i2, i3, z);
        this.mSize = this.oep.bitmap.getRowBytes() * this.oep.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dWl */
    public f get() {
        if (this.oep.bitmap == null) {
            return null;
        }
        return this.oep;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.oep != null) {
            this.oep.recycle();
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
        this.oeq = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dWm */
    public e dWp() {
        return this.oeq;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dWn() {
        return this.oer;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void yc(boolean z) {
        this.oer = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dVV() {
        return this.referenceCount > 0;
    }

    public synchronized void dWo() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dVW() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.oep.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.oep.height;
    }
}
