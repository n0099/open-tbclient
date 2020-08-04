package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e oes;
    private boolean oet;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f oer = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.oer.f(i, i2, i3, z);
        this.mSize = this.oer.bitmap.getRowBytes() * this.oer.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dWm */
    public f get() {
        if (this.oer.bitmap == null) {
            return null;
        }
        return this.oer;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.oer != null) {
            this.oer.recycle();
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
        this.oes = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dWn */
    public e dWq() {
        return this.oes;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dWo() {
        return this.oet;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void yc(boolean z) {
        this.oet = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dVW() {
        return this.referenceCount > 0;
    }

    public synchronized void dWp() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dVX() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.oer.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.oer.height;
    }
}
