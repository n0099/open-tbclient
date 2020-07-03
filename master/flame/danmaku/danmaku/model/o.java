package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
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

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
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

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long dSe = j - dSe();
        if (dSe >= this.nTe.value) {
            return mVar.getWidth();
        }
        return (((float) dSe) * this.nTJ) - this.nTc;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dRZ() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSa() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSb() {
        return this.x + this.nTc;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSc() {
        return this.y + this.nTd;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
