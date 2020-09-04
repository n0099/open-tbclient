package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e oyH;
    private boolean oyI;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f oyG = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.oyG.f(i, i2, i3, z);
        this.mSize = this.oyG.bitmap.getRowBytes() * this.oyG.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: eiy */
    public f get() {
        if (this.oyG.bitmap == null) {
            return null;
        }
        return this.oyG;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.oyG != null) {
            this.oyG.recycle();
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
        this.oyH = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: eiz */
    public e eiC() {
        return this.oyH;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean eiA() {
        return this.oyI;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void yW(boolean z) {
        this.oyI = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean eii() {
        return this.referenceCount > 0;
    }

    public synchronized void eiB() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void eij() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.oyG.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.oyG.height;
    }
}
