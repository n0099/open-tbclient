package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class p extends d {
    protected long mLastTime;
    protected int owM;
    protected float owN;
    protected float x = 0.0f;
    protected float y = -1.0f;
    protected float[] owB = null;

    public p(g gVar) {
        this.owi = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.ovH != null) {
            long j = this.ovH.owx;
            long ehR = j - ehR();
            if (ehR > 0 && ehR < this.owi.value) {
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
        long ehR = j - ehR();
        return ehR >= this.owi.value ? -this.owg : mVar.getWidth() - (((float) ehR) * this.owN);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!ehF()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.owB == null) {
            this.owB = new float[4];
        }
        this.owB[0] = b;
        this.owB[1] = this.y;
        this.owB[2] = b + this.owg;
        this.owB[3] = this.y + this.owh;
        return this.owB;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehM() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehN() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehO() {
        return this.x + this.owg;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehP() {
        return this.y + this.owh;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, boolean z) {
        super.a(mVar, z);
        this.owM = (int) (mVar.getWidth() + this.owg);
        this.owN = this.owM / ((float) this.owi.value);
    }
}
