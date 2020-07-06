package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nTL;
    protected float nTM;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nTA = null;

    public p(g gVar) {
        this.nTh = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
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

    protected float b(m mVar, long j) {
        long dSi = j - dSi();
        return dSi >= this.nTh.value ? -this.nTf : mVar.getWidth() - (((float) dSi) * this.nTM);
    }

    @Override // master.flame.danmaku.danmaku.model.d
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

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSd() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSe() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSf() {
        return this.x + this.nTf;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSg() {
        return this.y + this.nTg;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nTL = (int) (mVar.getWidth() + this.nTf);
        this.nTM = this.nTL / ((float) this.nTh.value);
    }
}
