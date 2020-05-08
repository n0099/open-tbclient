package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e ndG;
    private boolean ndH;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f ndF = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.ndF.f(i, i2, i3, z);
        this.mSize = this.ndF.bitmap.getRowBytes() * this.ndF.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: dFW */
    public f get() {
        if (this.ndF.bitmap == null) {
            return null;
        }
        return this.ndF;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.ndF != null) {
            this.ndF.recycle();
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
    public void bH(e eVar) {
        this.ndG = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: dFX */
    public e dGa() {
        return this.ndG;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean dFY() {
        return this.ndH;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void wC(boolean z) {
        this.ndH = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean dFG() {
        return this.referenceCount > 0;
    }

    public synchronized void dFZ() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void dFH() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.ndF.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.ndF.height;
    }
}
