package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class i extends d {
    private float nbx;
    private float nby;
    private int nbz;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nbw = null;

    public i(g gVar) {
        this.nbc = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.naA != null) {
            long dFt = this.naA.nbs - dFt();
            if (dFt > 0 && dFt < this.nbc.value) {
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
        if (this.nbz == mVar.getWidth() && this.nby == this.nba) {
            return this.nbx;
        }
        float width = (mVar.getWidth() - this.nba) / 2.0f;
        this.nbz = mVar.getWidth();
        this.nby = this.nba;
        this.nbx = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dFi()) {
            return null;
        }
        float b = b(mVar);
        if (this.nbw == null) {
            this.nbw = new float[4];
        }
        this.nbw[0] = b;
        this.nbw[1] = this.y;
        this.nbw[2] = b + this.nba;
        this.nbw[3] = this.y + this.nbb;
        return this.nbw;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFo() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFp() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFq() {
        return this.x + this.nba;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFr() {
        return this.y + this.nbb;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
