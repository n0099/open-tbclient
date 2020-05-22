package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nwN;
    protected float nwO;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nwC = null;

    public p(g gVar) {
        this.nwi = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nvG != null) {
            long j = this.nvG.nwy;
            long dNk = j - dNk();
            if (dNk > 0 && dNk < this.nwi.value) {
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
        long dNk = j - dNk();
        return dNk >= this.nwi.value ? -this.nwg : mVar.getWidth() - (((float) dNk) * this.nwO);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dMZ()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nwC == null) {
            this.nwC = new float[4];
        }
        this.nwC[0] = b;
        this.nwC[1] = this.y;
        this.nwC[2] = b + this.nwg;
        this.nwC[3] = this.y + this.nwh;
        return this.nwC;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNf() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNg() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNh() {
        return this.x + this.nwg;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNi() {
        return this.y + this.nwh;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nwN = (int) (mVar.getWidth() + this.nwg);
        this.nwO = this.nwN / ((float) this.nwi.value);
    }
}
