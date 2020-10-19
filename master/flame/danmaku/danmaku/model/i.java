package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float oVx;
    private float oVy;
    private int oVz;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] oVw = null;

    public i(g gVar) {
        this.oVd = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.oUC != null) {
            long epB = this.oUC.oVs - epB();
            if (epB > 0 && epB < this.oVd.value) {
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
        if (this.oVz == mVar.getWidth() && this.oVy == this.oVb) {
            return this.oVx;
        }
        float width = (mVar.getWidth() - this.oVb) / 2.0f;
        this.oVz = mVar.getWidth();
        this.oVy = this.oVb;
        this.oVx = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!epp()) {
            return null;
        }
        float b = b(mVar);
        if (this.oVw == null) {
            this.oVw = new float[4];
        }
        this.oVw[0] = b;
        this.oVw[1] = this.y;
        this.oVw[2] = b + this.oVb;
        this.oVw[3] = this.y + this.oVc;
        return this.oVw;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epw() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epx() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epy() {
        return this.x + this.oVb;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epz() {
        return this.y + this.oVc;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
