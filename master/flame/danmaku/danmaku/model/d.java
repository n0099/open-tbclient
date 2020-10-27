package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean kUV;
    public Object obj;
    protected f pLY;
    public n<?> pME;
    public boolean pMF;
    public String pMG;
    public boolean pMH;
    public boolean pMN;
    public long pMs;
    public String[] pMt;
    public float pMu;
    public int pMv;
    public g pMz;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean pMr = false;
    public int underlineColor = 0;
    public float bGw = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte pMw = 0;
    public float pMx = -1.0f;
    public float pMy = -1.0f;
    private int pMA = 0;
    public int pMB = 0;
    public int pMC = 0;
    public int pMD = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int pMI = 0;
    public int pMJ = -1;
    public j pMK = null;
    public int pML = 0;
    public int pMM = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float ezu();

    public abstract float ezv();

    public abstract float ezw();

    public abstract float ezx();

    public abstract int getType();

    public long getDuration() {
        return this.pMz.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean ezn() {
        return this.pMx > -1.0f && this.pMy > -1.0f && this.pMB == this.pMK.pMW;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.pMB = this.pMK.pMW;
    }

    public boolean isPrepared() {
        return this.pMD == this.pMK.pNb;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.pMD = this.pMK.pNb;
    }

    public n<?> ezo() {
        return this.pME;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.pMA == this.pMK.pMX;
    }

    public boolean ezp() {
        return this.pLY == null || hQ(this.pLY.pMO);
    }

    public boolean hQ(long j) {
        return j - ezz() >= this.pMz.value;
    }

    public boolean ezq() {
        return this.pLY == null || hR(this.pLY.pMO);
    }

    public boolean hR(long j) {
        long ezz = j - ezz();
        return ezz <= 0 || ezz >= this.pMz.value;
    }

    public boolean ezr() {
        return this.pLY == null || this.pLY.pMO < ezz();
    }

    public boolean ezs() {
        if (this.pMJ != this.pMK.pMY) {
            this.pMI = 0;
            return false;
        }
        return true;
    }

    public boolean ezt() {
        return this.pMJ == this.pMK.pMY && this.pMI != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.pMA = this.pMK.pMX;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f ezy() {
        return this.pLY;
    }

    public void c(f fVar) {
        this.pLY = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hS(long j) {
        this.pMs = j;
        this.pMC = this.pMK.pNa;
    }

    public void setTime(long j) {
        this.time = j;
        this.pMs = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long ezz() {
        return (this.pMK == null || this.pMK.pNa != this.pMC) ? this.time : this.time + this.pMs;
    }

    public boolean ezA() {
        if (this.pMK == null || this.pMK.pNa != this.pMC) {
            return false;
        }
        return this.pMN;
    }
}
