package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean jVk;
    public long obL;
    public String[] obM;
    public float obN;
    public int obO;
    public g obS;
    public n<?> obX;
    public boolean obY;
    public String obZ;
    public Object obj;
    protected f obr;
    public boolean oca;
    public boolean ocg;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean obK = false;
    public int underlineColor = 0;
    public float bnP = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte obP = 0;
    public float obQ = -1.0f;
    public float obR = -1.0f;
    private int obT = 0;
    public int obU = 0;
    public int obV = 0;
    public int obW = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int ocb = 0;
    public int occ = -1;
    public j ocd = null;
    public int oce = 0;
    public int ocf = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dVA();

    public abstract float dVB();

    public abstract float dVC();

    public abstract float dVD();

    public abstract int getType();

    public long getDuration() {
        return this.obS.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dVu() {
        return this.obQ > -1.0f && this.obR > -1.0f && this.obU == this.ocd.ocp;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.obU = this.ocd.ocp;
    }

    public boolean isPrepared() {
        return this.obW == this.ocd.ocv;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.obW = this.ocd.ocv;
    }

    public n<?> dVv() {
        return this.obX;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.obT == this.ocd.ocq;
    }

    public boolean isTimeOut() {
        return this.obr == null || gF(this.obr.och);
    }

    public boolean gF(long j) {
        return j - dVF() >= this.obS.value;
    }

    public boolean dVw() {
        return this.obr == null || gG(this.obr.och);
    }

    public boolean gG(long j) {
        long dVF = j - dVF();
        return dVF <= 0 || dVF >= this.obS.value;
    }

    public boolean dVx() {
        return this.obr == null || this.obr.och < dVF();
    }

    public boolean dVy() {
        if (this.occ != this.ocd.ocs) {
            this.ocb = 0;
            return false;
        }
        return true;
    }

    public boolean dVz() {
        return this.occ == this.ocd.ocs && this.ocb != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.obT = this.ocd.ocq;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dVE() {
        return this.obr;
    }

    public void c(f fVar) {
        this.obr = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gH(long j) {
        this.obL = j;
        this.obV = this.ocd.ocu;
    }

    public void setTime(long j) {
        this.time = j;
        this.obL = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dVF() {
        return (this.ocd == null || this.ocd.ocu != this.obV) ? this.time : this.time + this.obL;
    }

    public boolean dVG() {
        if (this.ocd == null || this.ocd.ocu != this.obV) {
            return false;
        }
        return this.ocg;
    }
}
