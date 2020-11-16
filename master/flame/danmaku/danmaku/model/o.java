package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pWV != null) {
            long j = this.pWV.pXL;
            long eDp = j - eDp();
            if (eDp > 0 && eDp < this.pXw.value) {
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
        if (!eDd()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.pXP == null) {
            this.pXP = new float[4];
        }
        this.pXP[0] = b;
        this.pXP[1] = this.y;
        this.pXP[2] = b + this.pXu;
        this.pXP[3] = this.y + this.pXv;
        return this.pXP;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long eDp = j - eDp();
        if (eDp >= this.pXw.value) {
            return mVar.getWidth();
        }
        return (((float) eDp) * this.pYa) - this.pXu;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float eDk() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float eDl() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float eDm() {
        return this.x + this.pXu;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float eDn() {
        return this.y + this.pXv;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
