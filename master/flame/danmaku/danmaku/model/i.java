package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class i extends d {
    private float nEY;
    private float nEZ;
    private int nFa;
    private float x = 0.0f;
    protected float y = -1.0f;
    private float[] nEX = null;

    public i(g gVar) {
        this.nEF = gVar;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        if (this.nEd != null) {
            long dKB = this.nEd.nEU - dKB();
            if (dKB > 0 && dKB < this.nEF.value) {
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
        if (this.nFa == mVar.getWidth() && this.nEZ == this.nED) {
            return this.nEY;
        }
        float width = (mVar.getWidth() - this.nED) / 2.0f;
        this.nFa = mVar.getWidth();
        this.nEZ = this.nED;
        this.nEY = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        if (!dKq()) {
            return null;
        }
        float b = b(mVar);
        if (this.nEX == null) {
            this.nEX = new float[4];
        }
        this.nEX[0] = b;
        this.nEX[1] = this.y;
        this.nEX[2] = b + this.nED;
        this.nEX[3] = this.y + this.nEE;
        return this.nEX;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKw() {
        return this.x;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKx() {
        return this.y;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKy() {
        return this.x + this.nED;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKz() {
        return this.y + this.nEE;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }
}
