package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e oyp;
    private boolean oyq;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f oyo = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.oyo.f(i, i2, i3, z);
        this.mSize = this.oyo.bitmap.getRowBytes() * this.oyo.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: eip */
    public f get() {
        if (this.oyo.bitmap == null) {
            return null;
        }
        return this.oyo;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.oyo != null) {
            this.oyo.recycle();
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
    public void bQ(e eVar) {
        this.oyp = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: eiq */
    public e eit() {
        return this.oyp;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean eir() {
        return this.oyq;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void yU(boolean z) {
        this.oyq = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean ehZ() {
        return this.referenceCount > 0;
    }

    public synchronized void eis() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void eia() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.oyo.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.oyo.height;
    }
}
