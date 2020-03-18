package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nIf;
    protected float nIg;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nHU = null;

    public p(g gVar) {
        this.nHC = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nHa != null) {
            long j = this.nHa.nHR;
            long dMt = j - dMt();
            if (dMt > 0 && dMt < this.nHC.value) {
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
        long dMt = j - dMt();
        return dMt >= this.nHC.value ? -this.nHA : mVar.getWidth() - (((float) dMt) * this.nIg);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dMi()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nHU == null) {
            this.nHU = new float[4];
        }
        this.nHU[0] = b;
        this.nHU[1] = this.y;
        this.nHU[2] = b + this.nHA;
        this.nHU[3] = this.y + this.nHB;
        return this.nHU;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMo() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMp() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMq() {
        return this.x + this.nHA;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMr() {
        return this.y + this.nHB;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nIf = (int) (mVar.getWidth() + this.nHA);
        this.nIg = this.nIf / ((float) this.nHC.value);
    }
}
