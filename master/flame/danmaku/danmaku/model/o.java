package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nSF != null) {
            long j = this.nSF.nTw;
            long dSi = j - dSi();
            if (dSi > 0 && dSi < this.nTh.value) {
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
        if (!dRX()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nTA == null) {
            this.nTA = new float[4];
        }
        this.nTA[0] = b;
        this.nTA[1] = this.y;
        this.nTA[2] = b + this.nTf;
        this.nTA[3] = this.y + this.nTg;
        return this.nTA;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long dSi = j - dSi();
        if (dSi >= this.nTh.value) {
            return mVar.getWidth();
        }
        return (((float) dSi) * this.nTM) - this.nTf;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSd() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSe() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSf() {
        return this.x + this.nTf;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dSg() {
        return this.y + this.nTg;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
