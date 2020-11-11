package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float pWn;
    private float pWo;
    private int pWp;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] pWm = null;

    public i(g gVar) {
        this.pVT = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pVs != null) {
            long eDo = this.pVs.pWi - eDo();
            if (eDo > 0 && eDo < this.pVT.value) {
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
        if (this.pWp == mVar.getWidth() && this.pWo == this.pVR) {
            return this.pWn;
        }
        float width = (mVar.getWidth() - this.pVR) / 2.0f;
        this.pWp = mVar.getWidth();
        this.pWo = this.pVR;
        this.pWn = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!eDc()) {
            return null;
        }
        float b = b(mVar);
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
        return 5;
    }
}
