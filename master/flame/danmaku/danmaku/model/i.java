package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nHV;
    private float nHW;
    private int nHX;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nHU = null;

    public i(g gVar) {
        this.nHC = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nHa != null) {
            long dMt = this.nHa.nHR - dMt();
            if (dMt > 0 && dMt < this.nHC.value) {
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
        if (this.nHX == mVar.getWidth() && this.nHW == this.nHA) {
            return this.nHV;
        }
        float width = (mVar.getWidth() - this.nHA) / 2.0f;
        this.nHX = mVar.getWidth();
        this.nHW = this.nHA;
        this.nHV = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dMi()) {
            return null;
        }
        float b = b(mVar);
        if (this.nHU == null) {
            this.nHU = new float[4];
        }
        this.nHU[0] = b;
        this.nHU[1] = this.y;
        this.nHU[2] = b + this.nHA;
        this.nHU[3] = this.y + this.nHB;
        return this.nHU;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMo() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMp() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMq() {
        return this.x + this.nHA;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMr() {
        return this.y + this.nHB;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
