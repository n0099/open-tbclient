package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class p extends d {
    protected long mLastTime;
    protected int nFi;
    protected float nFj;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nEX = null;

    public p(g gVar) {
        this.nEF = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nEd != null) {
            long j = this.nEd.nEU;
            long dKB = j - dKB();
            if (dKB > 0 && dKB < this.nEF.value) {
                this.x = b(mVar, j);
                if (!isShown()) {
                    this.y = f2;
                    setVisibility(true);
                }
                this.mLastTime = j;
                return;
            }
            this.mLastTime = j;
        }
        setVisibility(false);
    }

    protected float b(m mVar, long j) {
        long dKB = j - dKB();
        return dKB >= this.nEF.value ? -this.nED : mVar.getWidth() - (((float) dKB) * this.nFj);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dKq()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nEX == null) {
            this.nEX = new float[4];
        }
        this.nEX[0] = b;
        this.nEX[1] = this.y;
        this.nEX[2] = b + this.nED;
        this.nEX[3] = this.y + this.nEE;
        return this.nEX;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKw() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKx() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKy() {
        return this.x + this.nED;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKz() {
        return this.y + this.nEE;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nFi = (int) (mVar.getWidth() + this.nED);
        this.nFj = this.nFi / ((float) this.nEF.value);
    }
}
