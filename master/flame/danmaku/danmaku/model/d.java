package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean ktm;
    public long oFH;
    public String[] oFI;
    public float oFJ;
    public int oFK;
    public g oFO;
    public n<?> oFT;
    public boolean oFU;
    public String oFV;
    public boolean oFW;
    protected f oFn;
    public boolean oGc;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean oFG = false;
    public int underlineColor = 0;
    public float bwX = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte oFL = 0;
    public float oFM = -1.0f;
    public float oFN = -1.0f;
    private int oFP = 0;
    public int oFQ = 0;
    public int oFR = 0;
    public int oFS = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int oFX = 0;
    public int oFY = -1;
    public j oFZ = null;
    public int oGa = 0;
    public int oGb = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float elJ();

    public abstract float elK();

    public abstract float elL();

    public abstract float elM();

    public abstract int getType();

    public long getDuration() {
        return this.oFO.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean elC() {
        return this.oFM > -1.0f && this.oFN > -1.0f && this.oFQ == this.oFZ.oGl;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.oFQ = this.oFZ.oGl;
    }

    public boolean isPrepared() {
        return this.oFS == this.oFZ.oGq;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.oFS = this.oFZ.oGq;
    }

    public n<?> elD() {
        return this.oFT;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.oFP == this.oFZ.oGm;
    }

    public boolean elE() {
        return this.oFn == null || hi(this.oFn.oGd);
    }

    public boolean hi(long j) {
        return j - elO() >= this.oFO.value;
    }

    public boolean elF() {
        return this.oFn == null || hj(this.oFn.oGd);
    }

    public boolean hj(long j) {
        long elO = j - elO();
        return elO <= 0 || elO >= this.oFO.value;
    }

    public boolean elG() {
        return this.oFn == null || this.oFn.oGd < elO();
    }

    public boolean elH() {
        if (this.oFY != this.oFZ.oGn) {
            this.oFX = 0;
            return false;
        }
        return true;
    }

    public boolean elI() {
        return this.oFY == this.oFZ.oGn && this.oFX != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.oFP = this.oFZ.oGm;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f elN() {
        return this.oFn;
    }

    public void c(f fVar) {
        this.oFn = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hk(long j) {
        this.oFH = j;
        this.oFR = this.oFZ.oGp;
    }

    public void setTime(long j) {
        this.time = j;
        this.oFH = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long elO() {
        return (this.oFZ == null || this.oFZ.oGp != this.oFR) ? this.time : this.time + this.oFH;
    }

    public boolean elP() {
        if (this.oFZ == null || this.oFZ.oGp != this.oFR) {
            return false;
        }
        return this.oGc;
    }
}
