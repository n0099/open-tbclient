package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class i extends d {
    private float nFd;
    private float nFe;
    private int nFf;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nFc = null;

    public i(g gVar) {
        this.nEK = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nEi != null) {
            long dKD = this.nEi.nEZ - dKD();
            if (dKD > 0 && dKD < this.nEK.value) {
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
        if (this.nFf == mVar.getWidth() && this.nFe == this.nEI) {
            return this.nFd;
        }
        float width = (mVar.getWidth() - this.nEI) / 2.0f;
        this.nFf = mVar.getWidth();
        this.nFe = this.nEI;
        this.nFd = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dKs()) {
            return null;
        }
        float b = b(mVar);
        if (this.nFc == null) {
            this.nFc = new float[4];
        }
        this.nFc[0] = b;
        this.nFc[1] = this.y;
        this.nFc[2] = b + this.nEI;
        this.nFc[3] = this.y + this.nEJ;
        return this.nFc;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKy() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKz() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKA() {
        return this.x + this.nEI;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKB() {
        return this.y + this.nEJ;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
