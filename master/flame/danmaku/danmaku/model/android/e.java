package master.flame.danmaku.danmaku.model.android;

import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes6.dex */
public class e implements master.flame.danmaku.danmaku.model.a.c<e>, n<f> {
    private e oIm;
    private boolean oIn;
    private int mSize = 0;
    private int referenceCount = 0;
    private final f oIl = new f();

    public void e(int i, int i2, int i3, boolean z) {
        this.oIl.f(i, i2, i3, z);
        this.mSize = this.oIl.bitmap.getRowBytes() * this.oIl.bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.n
    /* renamed from: emv */
    public f get() {
        if (this.oIl.bitmap == null) {
            return null;
        }
        return this.oIl;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void destroy() {
        if (this.oIl != null) {
            this.oIl.recycle();
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
    public void bS(e eVar) {
        this.oIm = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // master.flame.danmaku.danmaku.model.a.c
    /* renamed from: emw */
    public e emz() {
        return this.oIm;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public boolean emx() {
        return this.oIn;
    }

    @Override // master.flame.danmaku.danmaku.model.a.c
    public void ze(boolean z) {
        this.oIn = z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized boolean emf() {
        return this.referenceCount > 0;
    }

    public synchronized void emy() {
        this.referenceCount++;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public synchronized void emg() {
        this.referenceCount--;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int width() {
        return this.oIl.width;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int height() {
        return this.oIl.height;
    }
}
