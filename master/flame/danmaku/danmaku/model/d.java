package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    public boolean mzB;
    public g nHC;
    public n<?> nHH;
    public boolean nHI;
    public String nHJ;
    public boolean nHK;
    public boolean nHQ;
    protected f nHa;
    public long nHu;
    public String[] nHv;
    public float nHw;
    public int nHx;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nHt = false;
    public int nHy = 0;
    public float aFf = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nHz = 0;
    public float nHA = -1.0f;
    public float nHB = -1.0f;
    private int nHD = 0;
    public int nHE = 0;
    public int nHF = 0;
    public int nHG = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nHL = 0;
    public int nHM = -1;
    public j nHN = null;
    public int nHO = 0;
    public int nHP = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dMo();

    public abstract float dMp();

    public abstract float dMq();

    public abstract float dMr();

    public abstract int getType();

    public long getDuration() {
        return this.nHC.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dMi() {
        return this.nHA > -1.0f && this.nHB > -1.0f && this.nHE == this.nHN.nHY;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nHE = this.nHN.nHY;
    }

    public boolean isPrepared() {
        return this.nHG == this.nHN.nId;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nHG = this.nHN.nId;
    }

    public n<?> dMj() {
        return this.nHH;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nHD == this.nHN.nHZ;
    }

    public boolean isTimeOut() {
        return this.nHa == null || hl(this.nHa.nHR);
    }

    public boolean hl(long j) {
        return j - dMt() >= this.nHC.value;
    }

    public boolean dMk() {
        return this.nHa == null || hm(this.nHa.nHR);
    }

    public boolean hm(long j) {
        long dMt = j - dMt();
        return dMt <= 0 || dMt >= this.nHC.value;
    }

    public boolean dMl() {
        return this.nHa == null || this.nHa.nHR < dMt();
    }

    public boolean dMm() {
        if (this.nHM != this.nHN.nIa) {
            this.nHL = 0;
            return false;
        }
        return true;
    }

    public boolean dMn() {
        return this.nHM == this.nHN.nIa && this.nHL != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nHD = this.nHN.nHZ;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dMs() {
        return this.nHa;
    }

    public void c(f fVar) {
        this.nHa = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hn(long j) {
        this.nHu = j;
        this.nHF = this.nHN.nIc;
    }

    public void setTime(long j) {
        this.time = j;
        this.nHu = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dMt() {
        return (this.nHN == null || this.nHN.nIc != this.nHF) ? this.time : this.time + this.nHu;
    }

    public boolean dMu() {
        if (this.nHN == null || this.nHN.nIc != this.nHF) {
            return false;
        }
        return this.nHQ;
    }
}
