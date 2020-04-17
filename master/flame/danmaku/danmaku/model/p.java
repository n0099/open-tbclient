package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nbH;
    protected float nbI;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nbw = null;

    public p(g gVar) {
        this.nbc = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.naA != null) {
            long j = this.naA.nbs;
            long dFt = j - dFt();
            if (dFt > 0 && dFt < this.nbc.value) {
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
        long dFt = j - dFt();
        return dFt >= this.nbc.value ? -this.nba : mVar.getWidth() - (((float) dFt) * this.nbI);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dFi()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nbw == null) {
            this.nbw = new float[4];
        }
        this.nbw[0] = b;
        this.nbw[1] = this.y;
        this.nbw[2] = b + this.nba;
        this.nbw[3] = this.y + this.nbb;
        return this.nbw;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFo() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFp() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFq() {
        return this.x + this.nba;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFr() {
        return this.y + this.nbb;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nbH = (int) (mVar.getWidth() + this.nba);
        this.nbI = this.nbH / ((float) this.nbc.value);
    }
}
