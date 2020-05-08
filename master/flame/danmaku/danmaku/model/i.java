package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nbA;
    private float nbB;
    private int nbC;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nbz = null;

    public i(g gVar) {
        this.nbf = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.naD != null) {
            long dFp = this.naD.nbv - dFp();
            if (dFp > 0 && dFp < this.nbf.value) {
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
        if (this.nbC == mVar.getWidth() && this.nbB == this.nbd) {
            return this.nbA;
        }
        float width = (mVar.getWidth() - this.nbd) / 2.0f;
        this.nbC = mVar.getWidth();
        this.nbB = this.nbd;
        this.nbA = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dFe()) {
            return null;
        }
        float b = b(mVar);
        if (this.nbz == null) {
            this.nbz = new float[4];
        }
        this.nbz[0] = b;
        this.nbz[1] = this.y;
        this.nbz[2] = b + this.nbd;
        this.nbz[3] = this.y + this.nbe;
        return this.nbz;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFk() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFl() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFm() {
        return this.x + this.nbd;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFn() {
        return this.y + this.nbe;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
