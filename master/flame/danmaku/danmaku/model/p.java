package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class p extends d {
    protected long mLastTime;
    protected int ocv;
    protected float ocw;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] ocj = null;

    public p(g gVar) {
        this.obQ = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.obp != null) {
            long j = this.obp.ocf;
            long dVE = j - dVE();
            if (dVE > 0 && dVE < this.obQ.value) {
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
        long dVE = j - dVE();
        return dVE >= this.obQ.value ? -this.obO : mVar.getWidth() - (((float) dVE) * this.ocw);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dVt()) {
            return null;
        }
        float b = b(mVar, j);
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
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.ocv = (int) (mVar.getWidth() + this.obO);
        this.ocw = this.ocv / ((float) this.obQ.value);
    }
}
