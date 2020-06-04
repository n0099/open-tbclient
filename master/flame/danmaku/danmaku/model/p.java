package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class p extends d {
    protected long mLastTime;
    protected int nxX;
    protected float nxY;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] nxM = null;

    public p(g gVar) {
        this.nxs = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nwQ != null) {
            long j = this.nwQ.nxI;
            long dNy = j - dNy();
            if (dNy > 0 && dNy < this.nxs.value) {
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
        long dNy = j - dNy();
        return dNy >= this.nxs.value ? -this.nxq : mVar.getWidth() - (((float) dNy) * this.nxY);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dNn()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.nxM == null) {
            this.nxM = new float[4];
        }
        this.nxM[0] = b;
        this.nxM[1] = this.y;
        this.nxM[2] = b + this.nxq;
        this.nxM[3] = this.y + this.nxr;
        return this.nxM;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNt() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNu() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNv() {
        return this.x + this.nxq;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNw() {
        return this.y + this.nxr;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.nxX = (int) (mVar.getWidth() + this.nxq);
        this.nxY = this.nxX / ((float) this.nxs.value);
    }
}
