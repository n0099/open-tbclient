package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nFX;
    private float nFY;
    private int nFZ;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nFW = null;

    public i(g gVar) {
        this.nFE = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFc != null) {
            long dLS = this.nFc.nFT - dLS();
            if (dLS > 0 && dLS < this.nFE.value) {
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
        if (this.nFZ == mVar.getWidth() && this.nFY == this.nFC) {
            return this.nFX;
        }
        float width = (mVar.getWidth() - this.nFC) / 2.0f;
        this.nFZ = mVar.getWidth();
        this.nFY = this.nFC;
        this.nFX = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dLH()) {
            return null;
        }
        float b = b(mVar);
        if (this.nFW == null) {
            this.nFW = new float[4];
        }
        this.nFW[0] = b;
        this.nFW[1] = this.y;
        this.nFW[2] = b + this.nFC;
        this.nFW[3] = this.y + this.nFD;
        return this.nFW;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.x + this.nFC;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.y + this.nFD;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
