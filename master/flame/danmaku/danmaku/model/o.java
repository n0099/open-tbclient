package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.naD != null) {
            long j = this.naD.nbv;
            long dFq = j - dFq();
            if (dFq > 0 && dFq < this.nbf.value) {
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
        if (!dFf()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nbz == null) {
            this.nbz = new float[4];
        }
        this.nbz[0] = b;
        this.nbz[1] = this.y;
        this.nbz[2] = b + this.nbd;
        this.nbz[3] = this.y + this.nbe;
        return this.nbz;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long dFq = j - dFq();
        if (dFq >= this.nbf.value) {
            return mVar.getWidth();
        }
        return (((float) dFq) * this.nbL) - this.nbd;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFl() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFm() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFn() {
        return this.x + this.nbd;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFo() {
        return this.y + this.nbe;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
