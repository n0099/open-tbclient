package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class p extends d {
    protected int eHi;
    protected long mLastTime;
    protected float pWx;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] pWm = null;

    public p(g gVar) {
        this.pVT = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pVs != null) {
            long j = this.pVs.pWi;
            long eDo = j - eDo();
            if (eDo > 0 && eDo < this.pVT.value) {
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
        long eDo = j - eDo();
        return eDo >= this.pVT.value ? -this.pVR : mVar.getWidth() - (((float) eDo) * this.pWx);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!eDc()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.pWm == null) {
            this.pWm = new float[4];
        }
        this.pWm[0] = b;
        this.pWm[1] = this.y;
        this.pWm[2] = b + this.pVR;
        this.pWm[3] = this.y + this.pVS;
        return this.pWm;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDj() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDk() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDl() {
        return this.x + this.pVR;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDm() {
        return this.y + this.pVS;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.eHi = (int) (mVar.getWidth() + this.pVR);
        this.pWx = this.eHi / ((float) this.pVT.value);
    }
}
