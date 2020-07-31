package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean jVi;
    public long obJ;
    public String[] obK;
    public float obL;
    public int obM;
    public g obQ;
    public n<?> obV;
    public boolean obW;
    public String obX;
    public boolean obY;
    public Object obj;
    protected f obp;
    public boolean oce;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean obI = false;
    public int underlineColor = 0;
    public float bnP = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte obN = 0;
    public float obO = -1.0f;
    public float obP = -1.0f;
    private int obR = 0;
    public int obS = 0;
    public int obT = 0;
    public int obU = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int obZ = 0;
    public int oca = -1;
    public j ocb = null;
    public int occ = 0;
    public int ocd = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dVA();

    public abstract float dVB();

    public abstract float dVC();

    public abstract float dVz();

    public abstract int getType();

    public long getDuration() {
        return this.obQ.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dVt() {
        return this.obO > -1.0f && this.obP > -1.0f && this.obS == this.ocb.ocn;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.obS = this.ocb.ocn;
    }

    public boolean isPrepared() {
        return this.obU == this.ocb.oct;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.obU = this.ocb.oct;
    }

    public n<?> dVu() {
        return this.obV;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.obR == this.ocb.oco;
    }

    public boolean isTimeOut() {
        return this.obp == null || gF(this.obp.ocf);
    }

    public boolean gF(long j) {
        return j - dVE() >= this.obQ.value;
    }

    public boolean dVv() {
        return this.obp == null || gG(this.obp.ocf);
    }

    public boolean gG(long j) {
        long dVE = j - dVE();
        return dVE <= 0 || dVE >= this.obQ.value;
    }

    public boolean dVw() {
        return this.obp == null || this.obp.ocf < dVE();
    }

    public boolean dVx() {
        if (this.oca != this.ocb.ocp) {
            this.obZ = 0;
            return false;
        }
        return true;
    }

    public boolean dVy() {
        return this.oca == this.ocb.ocp && this.obZ != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.obR = this.ocb.oco;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dVD() {
        return this.obp;
    }

    public void c(f fVar) {
        this.obp = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gH(long j) {
        this.obJ = j;
        this.obT = this.ocb.ocs;
    }

    public void setTime(long j) {
        this.time = j;
        this.obJ = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dVE() {
        return (this.ocb == null || this.ocb.ocs != this.obT) ? this.time : this.time + this.obJ;
    }

    public boolean dVF() {
        if (this.ocb == null || this.ocb.ocs != this.obT) {
            return false;
        }
        return this.oce;
    }
}
