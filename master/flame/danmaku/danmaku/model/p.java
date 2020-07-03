package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nTI;
    protected float nTJ;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nTx = null;

    public p(g gVar) {
        this.nTe = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nSC != null) {
            long j = this.nSC.nTt;
            long dSe = j - dSe();
            if (dSe > 0 && dSe < this.nTe.value) {
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
        long dSe = j - dSe();
        return dSe >= this.nTe.value ? -this.nTc : mVar.getWidth() - (((float) dSe) * this.nTJ);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dRT()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nTx == null) {
            this.nTx = new float[4];
        }
        this.nTx[0] = b;
        this.nTx[1] = this.y;
        this.nTx[2] = b + this.nTc;
        this.nTx[3] = this.y + this.nTd;
        return this.nTx;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dRZ() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSa() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSb() {
        return this.x + this.nTc;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSc() {
        return this.y + this.nTd;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nTI = (int) (mVar.getWidth() + this.nTc);
        this.nTJ = this.nTI / ((float) this.nTe.value);
    }
}
