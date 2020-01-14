package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes4.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e nHj;
    private boolean nHk;
    private int mSize = 0;
    private int nHl = 0;
    private final f nHi = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.nHi.f(i, i2, i3, z);
        this.mSize = this.nHi.bitmap.getRowBytes() * this.nHi.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dLk */
    public f get() {
        if (this.nHi.bitmap == null) {
            return null;
        }
        return this.nHi;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.nHi != null) {
            this.nHi.recycle();
        }
        this.mSize = 0;
        this.nHl = 0;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int size() {
        return this.mSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: a */
    public void bW(e eVar) {
        this.nHj = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dLl */
    public e dLo() {
        return this.nHj;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dLm() {
        return this.nHk;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wM(boolean z) {
        this.nHk = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dKU() {
        return this.nHl > 0;
    }

    public synchronized void dLn() {
        this.nHl++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dKV() {
        this.nHl--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.nHi.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.nHi.height;
    }
}
