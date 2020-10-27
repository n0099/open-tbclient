package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float pMT;
    private float pMU;
    private int pMV;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] pMS = null;

    public i(g gVar) {
        this.pMz = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pLY != null) {
            long ezz = this.pLY.pMO - ezz();
            if (ezz > 0 && ezz < this.pMz.value) {
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
        if (this.pMV == mVar.getWidth() && this.pMU == this.pMx) {
            return this.pMT;
        }
        float width = (mVar.getWidth() - this.pMx) / 2.0f;
        this.pMV = mVar.getWidth();
        this.pMU = this.pMx;
        this.pMT = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!ezn()) {
            return null;
        }
        float b = b(mVar);
        if (this.pMS == null) {
            this.pMS = new float[4];
        }
        this.pMS[0] = b;
        this.pMS[1] = this.y;
        this.pMS[2] = b + this.pMx;
        this.pMS[3] = this.y + this.pMy;
        return this.pMS;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezu() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezv() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezw() {
        return this.x + this.pMx;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezx() {
        return this.y + this.pMy;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
