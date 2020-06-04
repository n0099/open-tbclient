package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nwQ != null) {
            long j = this.nwQ.nxI;
            long dNy = j - dNy();
            if (dNy > 0 && dNy < this.nxs.value) {
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
        if (!dNn()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nxM == null) {
            this.nxM = new float[4];
        }
        this.nxM[0] = b;
        this.nxM[1] = this.y;
        this.nxM[2] = b + this.nxq;
        this.nxM[3] = this.y + this.nxr;
        return this.nxM;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long dNy = j - dNy();
        if (dNy >= this.nxs.value) {
            return mVar.getWidth();
        }
        return (((float) dNy) * this.nxY) - this.nxq;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dNt() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dNu() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dNv() {
        return this.x + this.nxq;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float dNw() {
        return this.y + this.nxr;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
