package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float pXQ;
    private float pXR;
    private int pXS;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] pXP = null;

    public i(g gVar) {
        this.pXw = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pWV != null) {
            long eDp = this.pWV.pXL - eDp();
            if (eDp > 0 && eDp < this.pXw.value) {
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
        if (this.pXS == mVar.getWidth() && this.pXR == this.pXu) {
            return this.pXQ;
        }
        float width = (mVar.getWidth() - this.pXu) / 2.0f;
        this.pXS = mVar.getWidth();
        this.pXR = this.pXu;
        this.pXQ = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!eDd()) {
            return null;
        }
        float b = b(mVar);
        if (this.pXP == null) {
            this.pXP = new float[4];
        }
        this.pXP[0] = b;
        this.pXP[1] = this.y;
        this.pXP[2] = b + this.pXu;
        this.pXP[3] = this.y + this.pXv;
        return this.pXP;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDk() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDl() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDm() {
        return this.x + this.pXu;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDn() {
        return this.y + this.pXv;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
