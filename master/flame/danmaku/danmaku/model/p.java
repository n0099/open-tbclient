package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class p extends d {
    protected long mLastTime;
    protected int ocx;
    protected float ocy;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] ocl = null;

    public p(g gVar) {
        this.obS = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.obr != null) {
            long j = this.obr.och;
            long dVF = j - dVF();
            if (dVF > 0 && dVF < this.obS.value) {
                this.x = b(mVar, j);
                if (!isShown()) {
                    this.y = f2;
                    setVisibility(true);
                }
                this.mLastTime = j;
                return;
            }
            this.mLastTime = j;
        }
        setVisibility(false);
    }

    protected float b(m mVar, long j) {
        long dVF = j - dVF();
        return dVF >= this.obS.value ? -this.obQ : mVar.getWidth() - (((float) dVF) * this.ocy);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dVu()) {
            return null;
        }
        float b = b(mVar, j);
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
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.ocx = (int) (mVar.getWidth() + this.obQ);
        this.ocy = this.ocx / ((float) this.obS.value);
    }
}
