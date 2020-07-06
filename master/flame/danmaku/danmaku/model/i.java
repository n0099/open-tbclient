package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nTB;
    private float nTC;
    private int nTD;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nTA = null;

    public i(g gVar) {
        this.nTh = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nSF != null) {
            long dSi = this.nSF.nTw - dSi();
            if (dSi > 0 && dSi < this.nTh.value) {
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
        if (this.nTD == mVar.getWidth() && this.nTC == this.nTf) {
            return this.nTB;
        }
        float width = (mVar.getWidth() - this.nTf) / 2.0f;
        this.nTD = mVar.getWidth();
        this.nTC = this.nTf;
        this.nTB = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dRX()) {
            return null;
        }
        float b = b(mVar);
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
        return 5;
    }
}
