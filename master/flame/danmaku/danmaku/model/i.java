package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nxN;
    private float nxO;
    private int nxP;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nxM = null;

    public i(g gVar) {
        this.nxs = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nwQ != null) {
            long dNy = this.nwQ.nxI - dNy();
            if (dNy > 0 && dNy < this.nxs.value) {
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
        if (this.nxP == mVar.getWidth() && this.nxO == this.nxq) {
            return this.nxN;
        }
        float width = (mVar.getWidth() - this.nxq) / 2.0f;
        this.nxP = mVar.getWidth();
        this.nxO = this.nxq;
        this.nxN = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dNn()) {
            return null;
        }
        float b = b(mVar);
        if (this.nxM == null) {
            this.nxM = new float[4];
        }
        this.nxM[0] = b;
        this.nxM[1] = this.y;
        this.nxM[2] = b + this.nxq;
        this.nxM[3] = this.y + this.nxr;
        return this.nxM;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNt() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNu() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNv() {
        return this.x + this.nxq;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNw() {
        return this.y + this.nxr;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
