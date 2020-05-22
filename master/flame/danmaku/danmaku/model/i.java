package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nwD;
    private float nwE;
    private int nwF;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nwC = null;

    public i(g gVar) {
        this.nwi = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nvG != null) {
            long dNk = this.nvG.nwy - dNk();
            if (dNk > 0 && dNk < this.nwi.value) {
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
        if (this.nwF == mVar.getWidth() && this.nwE == this.nwg) {
            return this.nwD;
        }
        float width = (mVar.getWidth() - this.nwg) / 2.0f;
        this.nwF = mVar.getWidth();
        this.nwE = this.nwg;
        this.nwD = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dMZ()) {
            return null;
        }
        float b = b(mVar);
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
        return 5;
    }
}
