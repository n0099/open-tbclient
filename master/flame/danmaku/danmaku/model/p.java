package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class p extends d {
    protected int eFA;
    protected long mLastTime;
    protected float pYa;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] pXP = null;

    public p(g gVar) {
        this.pXw = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.pWV != null) {
            long j = this.pWV.pXL;
            long eDp = j - eDp();
            if (eDp > 0 && eDp < this.pXw.value) {
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
        long eDp = j - eDp();
        return eDp >= this.pXw.value ? -this.pXu : mVar.getWidth() - (((float) eDp) * this.pYa);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!eDd()) {
            return null;
        }
        float b = b(mVar, j);
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
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.eFA = (int) (mVar.getWidth() + this.pXu);
        this.pYa = this.eFA / ((float) this.pXw.value);
    }
}
