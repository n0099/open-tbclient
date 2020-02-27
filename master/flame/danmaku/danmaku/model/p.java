package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nGf;
    protected float nGg;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nFU = null;

    public p(g gVar) {
        this.nFC = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nFa != null) {
            long j = this.nFa.nFR;
            long dLQ = j - dLQ();
            if (dLQ > 0 && dLQ < this.nFC.value) {
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
        long dLQ = j - dLQ();
        return dLQ >= this.nFC.value ? -this.nFA : mVar.getWidth() - (((float) dLQ) * this.nGg);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dLF()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nFU == null) {
            this.nFU = new float[4];
        }
        this.nFU[0] = b;
        this.nFU[1] = this.y;
        this.nFU[2] = b + this.nFA;
        this.nFU[3] = this.y + this.nFB;
        return this.nFU;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLL() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLM() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.x + this.nFA;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.y + this.nFB;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nGf = (int) (mVar.getWidth() + this.nFA);
        this.nGg = this.nGf / ((float) this.nFC.value);
    }
}
