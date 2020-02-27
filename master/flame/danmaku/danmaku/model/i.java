package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nFV;
    private float nFW;
    private int nFX;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nFU = null;

    public i(g gVar) {
        this.nFC = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFa != null) {
            long dLQ = this.nFa.nFR - dLQ();
            if (dLQ > 0 && dLQ < this.nFC.value) {
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
        if (this.nFX == mVar.getWidth() && this.nFW == this.nFA) {
            return this.nFV;
        }
        float width = (mVar.getWidth() - this.nFA) / 2.0f;
        this.nFX = mVar.getWidth();
        this.nFW = this.nFA;
        this.nFV = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dLF()) {
            return null;
        }
        float b = b(mVar);
        if (this.nFU == null) {
            this.nFU = new float[4];
        }
        this.nFU[0] = b;
        this.nFU[1] = this.y;
        this.nFU[2] = b + this.nFA;
        this.nFU[3] = this.y + this.nFB;
        return this.nFU;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLL() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLM() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.x + this.nFA;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.y + this.nFB;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
