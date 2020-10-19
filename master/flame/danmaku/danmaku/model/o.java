package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.oUC != null) {
            long j = this.oUC.oVs;
            long epB = j - epB();
            if (epB > 0 && epB < this.oVd.value) {
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

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!epp()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.oVw == null) {
            this.oVw = new float[4];
        }
        this.oVw[0] = b;
        this.oVw[1] = this.y;
        this.oVw[2] = b + this.oVb;
        this.oVw[3] = this.y + this.oVc;
        return this.oVw;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long epB = j - epB();
        if (epB >= this.oVd.value) {
            return mVar.getWidth();
        }
        return (((float) epB) * this.oVH) - this.oVb;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float epw() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float epx() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float epy() {
        return this.x + this.oVb;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float epz() {
        return this.y + this.oVc;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
