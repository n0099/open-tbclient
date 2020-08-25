package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class o extends p {
    public o(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.ovp != null) {
            long j = this.ovp.owf;
            long ehI = j - ehI();
            if (ehI > 0 && ehI < this.ovQ.value) {
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
        if (!ehw()) {
            return null;
        }
        float b = b(mVar, j);
        if (this.owj == null) {
            this.owj = new float[4];
        }
        this.owj[0] = b;
        this.owj[1] = this.y;
        this.owj[2] = b + this.ovO;
        this.owj[3] = this.y + this.ovP;
        return this.owj;
    }

    @Override // master.flame.danmaku.danmaku.model.p
    protected float b(m mVar, long j) {
        long ehI = j - ehI();
        if (ehI >= this.ovQ.value) {
            return mVar.getWidth();
        }
        return (((float) ehI) * this.owv) - this.ovO;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ehD() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ehE() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ehF() {
        return this.x + this.ovO;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public float ehG() {
        return this.y + this.ovP;
    }

    @Override // master.flame.danmaku.danmaku.model.p, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }
}
