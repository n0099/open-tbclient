package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float ock;
    private float ocl;
    private int ocm;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] ocj = null;

    public i(g gVar) {
        this.obQ = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.obp != null) {
            long dVE = this.obp.ocf - dVE();
            if (dVE > 0 && dVE < this.obQ.value) {
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
        if (this.ocm == mVar.getWidth() && this.ocl == this.obO) {
            return this.ock;
        }
        float width = (mVar.getWidth() - this.obO) / 2.0f;
        this.ocm = mVar.getWidth();
        this.ocl = this.obO;
        this.ock = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dVt()) {
            return null;
        }
        float b = b(mVar);
        if (this.ocj == null) {
            this.ocj = new float[4];
        }
        this.ocj[0] = b;
        this.ocj[1] = this.y;
        this.ocj[2] = b + this.obO;
        this.ocj[3] = this.y + this.obP;
        return this.ocj;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVz() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVA() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVB() {
        return this.x + this.obO;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVC() {
        return this.y + this.obP;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
