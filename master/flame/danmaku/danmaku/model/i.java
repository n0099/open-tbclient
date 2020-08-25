package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float owk;
    private float owl;
    private int owm;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] owj = null;

    public i(g gVar) {
        this.ovQ = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.ovp != null) {
            long ehI = this.ovp.owf - ehI();
            if (ehI > 0 && ehI < this.ovQ.value) {
                if (!isShown()) {
                    this.x = b(mVar);
                    this.y = f2;
                    setVisibility(true);
                    return;
                }
                return;
            }
            setVisibility(false);
            this.y = -1.0f;
            this.x = mVar.getWidth();
        }
    }

    protected float b(m mVar) {
        if (this.owm == mVar.getWidth() && this.owl == this.ovO) {
            return this.owk;
        }
        float width = (mVar.getWidth() - this.ovO) / 2.0f;
        this.owm = mVar.getWidth();
        this.owl = this.ovO;
        this.owk = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!ehw()) {
            return null;
        }
        float b = b(mVar);
        if (this.owj == null) {
            this.owj = new float[4];
        }
        this.owj[0] = b;
        this.owj[1] = this.y;
        this.owj[2] = b + this.ovO;
        this.owj[3] = this.y + this.ovP;
        return this.owj;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehD() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehE() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehF() {
        return this.x + this.ovO;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehG() {
        return this.y + this.ovP;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
