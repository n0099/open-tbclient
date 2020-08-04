package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float ocm;
    private float ocn;
    private int oco;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] ocl = null;

    public i(g gVar) {
        this.obS = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.obr != null) {
            long dVF = this.obr.och - dVF();
            if (dVF > 0 && dVF < this.obS.value) {
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
        if (this.oco == mVar.getWidth() && this.ocn == this.obQ) {
            return this.ocm;
        }
        float width = (mVar.getWidth() - this.obQ) / 2.0f;
        this.oco = mVar.getWidth();
        this.ocn = this.obQ;
        this.ocm = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dVu()) {
            return null;
        }
        float b = b(mVar);
        if (this.ocl == null) {
            this.ocl = new float[4];
        }
        this.ocl[0] = b;
        this.ocl[1] = this.y;
        this.ocl[2] = b + this.obQ;
        this.ocl[3] = this.y + this.obR;
        return this.ocl;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVA() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVB() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVC() {
        return this.x + this.obQ;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVD() {
        return this.y + this.obR;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
