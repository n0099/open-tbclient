package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.naA != null) {
            long j = this.naA.nbs;
            long dFt = j - dFt();
            if (dFt > 0 && dFt < this.nbc.value) {
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
        if (!dFi()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nbw == null) {
            this.nbw = new float[4];
        }
        this.nbw[0] = b;
        this.nbw[1] = this.y;
        this.nbw[2] = b + this.nba;
        this.nbw[3] = this.y + this.nbb;
        return this.nbw;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long dFt = j - dFt();
        if (dFt >= this.nbc.value) {
            return mVar.getWidth();
        }
        return (((float) dFt) * this.nbI) - this.nba;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFo() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFp() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFq() {
        return this.x + this.nba;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dFr() {
        return this.y + this.nbb;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
