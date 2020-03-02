package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFc != null) {
            long j = this.nFc.nFT;
            long dLS = j - dLS();
            if (dLS > 0 && dLS < this.nFE.value) {
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
        if (!dLH()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nFW == null) {
            this.nFW = new float[4];
        }
        this.nFW[0] = b;
        this.nFW[1] = this.y;
        this.nFW[2] = b + this.nFC;
        this.nFW[3] = this.y + this.nFD;
        return this.nFW;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long dLS = j - dLS();
        if (dLS >= this.nFE.value) {
            return mVar.getWidth();
        }
        return (((float) dLS) * this.nGi) - this.nFC;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.x + this.nFC;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.y + this.nFD;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
