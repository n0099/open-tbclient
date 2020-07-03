package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private int nTA;
    private float nTy;
    private float nTz;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nTx = null;

    public i(g gVar) {
        this.nTe = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nSC != null) {
            long dSe = this.nSC.nTt - dSe();
            if (dSe > 0 && dSe < this.nTe.value) {
                if (!isShown()) {
                    this.x = b(mVar);
                    this.y = f2;
                    setVisibility(true);
                    return;
                }
                return;
            }
            setVisibility(false);
            this.y = -1.0f;
            this.x = mVar.getWidth();
        }
    }

    protected float b(m mVar) {
        if (this.nTA == mVar.getWidth() && this.nTz == this.nTc) {
            return this.nTy;
        }
        float width = (mVar.getWidth() - this.nTc) / 2.0f;
        this.nTA = mVar.getWidth();
        this.nTz = this.nTc;
        this.nTy = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dRT()) {
            return null;
        }
        float b = b(mVar);
        if (this.nTx == null) {
            this.nTx = new float[4];
        }
        this.nTx[0] = b;
        this.nTx[1] = this.y;
        this.nTx[2] = b + this.nTc;
        this.nTx[3] = this.y + this.nTd;
        return this.nTx;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dRZ() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSa() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSb() {
        return this.x + this.nTc;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSc() {
        return this.y + this.nTd;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
