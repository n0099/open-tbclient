package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class p extends d {
    protected int egN;
    protected long mLastTime;
    protected float oGs;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] oGh = null;

    public p(g gVar) {
        this.oFO = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.oFn != null) {
            long j = this.oFn.oGd;
            long elO = j - elO();
            if (elO > 0 && elO < this.oFO.value) {
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
        long elO = j - elO();
        return elO >= this.oFO.value ? -this.oFM : mVar.getWidth() - (((float) elO) * this.oGs);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!elC()) {
            return null;
        }
        float b = b(mVar, j);
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
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.egN = (int) (mVar.getWidth() + this.oFM);
        this.oGs = this.egN / ((float) this.oFO.value);
    }
}
