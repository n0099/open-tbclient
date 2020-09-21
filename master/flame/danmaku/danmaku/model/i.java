package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float oGi;
    private float oGj;
    private int oGk;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] oGh = null;

    public i(g gVar) {
        this.oFO = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.oFn != null) {
            long elO = this.oFn.oGd - elO();
            if (elO > 0 && elO < this.oFO.value) {
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
        if (this.oGk == mVar.getWidth() && this.oGj == this.oFM) {
            return this.oGi;
        }
        float width = (mVar.getWidth() - this.oFM) / 2.0f;
        this.oGk = mVar.getWidth();
        this.oGj = this.oFM;
        this.oGi = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!elC()) {
            return null;
        }
        float b = b(mVar);
        if (this.oGh == null) {
            this.oGh = new float[4];
        }
        this.oGh[0] = b;
        this.oGh[1] = this.y;
        this.oGh[2] = b + this.oFM;
        this.oGh[3] = this.y + this.oFN;
        return this.oGh;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elJ() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elK() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elL() {
        return this.x + this.oFM;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elM() {
        return this.y + this.oFN;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
