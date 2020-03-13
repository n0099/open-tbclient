package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nGs;
    protected float nGt;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nGh = null;

    public p(g gVar) {
        this.nFP = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFn != null) {
            long j = this.nFn.nGe;
            long dLT = j - dLT();
            if (dLT > 0 && dLT < this.nFP.value) {
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
        long dLT = j - dLT();
        return dLT >= this.nFP.value ? -this.nFN : mVar.getWidth() - (((float) dLT) * this.nGt);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dLI()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nGh == null) {
            this.nGh = new float[4];
        }
        this.nGh[0] = b;
        this.nGh[1] = this.y;
        this.nGh[2] = b + this.nFN;
        this.nGh[3] = this.y + this.nFO;
        return this.nGh;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.x + this.nFN;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLR() {
        return this.y + this.nFO;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nGs = (int) (mVar.getWidth() + this.nFN);
        this.nGt = this.nGs / ((float) this.nFP.value);
    }
}
