package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pLY != null) {
            long j = this.pLY.pMO;
            long ezz = j - ezz();
            if (ezz > 0 && ezz < this.pMz.value) {
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
        if (!ezn()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.pMS == null) {
            this.pMS = new float[4];
        }
        this.pMS[0] = b;
        this.pMS[1] = this.y;
        this.pMS[2] = b + this.pMx;
        this.pMS[3] = this.y + this.pMy;
        return this.pMS;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long ezz = j - ezz();
        if (ezz >= this.pMz.value) {
            return mVar.getWidth();
        }
        return (((float) ezz) * this.pNd) - this.pMx;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ezu() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ezv() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ezw() {
        return this.x + this.pMx;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ezx() {
        return this.y + this.pMy;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
