package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nGi;
    private float nGj;
    private int nGk;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nGh = null;

    public i(g gVar) {
        this.nFP = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFn != null) {
            long dLT = this.nFn.nGe - dLT();
            if (dLT > 0 && dLT < this.nFP.value) {
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
        if (this.nGk == mVar.getWidth() && this.nGj == this.nFN) {
            return this.nGi;
        }
        float width = (mVar.getWidth() - this.nFN) / 2.0f;
        this.nGk = mVar.getWidth();
        this.nGj = this.nFN;
        this.nGi = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dLI()) {
            return null;
        }
        float b = b(mVar);
        if (this.nGh == null) {
            this.nGh = new float[4];
        }
        this.nGh[0] = b;
        this.nGh[1] = this.y;
        this.nGh[2] = b + this.nFN;
        this.nGh[3] = this.y + this.nFO;
        return this.nGh;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.x + this.nFN;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLR() {
        return this.y + this.nFO;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
