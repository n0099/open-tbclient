package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class i extends d {
    private float owC;
    private float owD;
    private int owE;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] owB = null;

    public i(g gVar) {
        this.owi = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.ovH != null) {
            long ehR = this.ovH.owx - ehR();
            if (ehR > 0 && ehR < this.owi.value) {
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
        if (this.owE == mVar.getWidth() && this.owD == this.owg) {
            return this.owC;
        }
        float width = (mVar.getWidth() - this.owg) / 2.0f;
        this.owE = mVar.getWidth();
        this.owD = this.owg;
        this.owC = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!ehF()) {
            return null;
        }
        float b = b(mVar);
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
        return 5;
    }
}
