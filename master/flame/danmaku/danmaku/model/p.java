package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class p extends d {
    protected long mLastTime;
    protected int nFn;
    protected float nFo;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nFc = null;

    public p(g gVar) {
        this.nEK = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nEi != null) {
            long j = this.nEi.nEZ;
            long dKD = j - dKD();
            if (dKD > 0 && dKD < this.nEK.value) {
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
        long dKD = j - dKD();
        return dKD >= this.nEK.value ? -this.nEI : mVar.getWidth() - (((float) dKD) * this.nFo);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dKs()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nFc == null) {
            this.nFc = new float[4];
        }
        this.nFc[0] = b;
        this.nFc[1] = this.y;
        this.nFc[2] = b + this.nEI;
        this.nFc[3] = this.y + this.nEJ;
        return this.nFc;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKy() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKz() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKA() {
        return this.x + this.nEI;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKB() {
        return this.y + this.nEJ;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nFn = (int) (mVar.getWidth() + this.nEI);
        this.nFo = this.nFn / ((float) this.nEK.value);
    }
}
