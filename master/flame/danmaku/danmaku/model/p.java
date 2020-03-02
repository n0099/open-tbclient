package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nGh;
    protected float nGi;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nFW = null;

    public p(g gVar) {
        this.nFE = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFc != null) {
            long j = this.nFc.nFT;
            long dLS = j - dLS();
            if (dLS > 0 && dLS < this.nFE.value) {
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
        long dLS = j - dLS();
        return dLS >= this.nFE.value ? -this.nFC : mVar.getWidth() - (((float) dLS) * this.nGi);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dLH()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nFW == null) {
            this.nFW = new float[4];
        }
        this.nFW[0] = b;
        this.nFW[1] = this.y;
        this.nFW[2] = b + this.nFC;
        this.nFW[3] = this.y + this.nFD;
        return this.nFW;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.x + this.nFC;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.y + this.nFD;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nGh = (int) (mVar.getWidth() + this.nFC);
        this.nGi = this.nGh / ((float) this.nFE.value);
    }
}
