package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    protected f nwQ;
    public String nxA;
    public boolean nxB;
    public boolean nxH;
    public long nxk;
    public String[] nxl;
    public float nxm;
    public int nxn;
    public g nxs;
    public n<?> nxx;
    public boolean nxy;
    public boolean nxz;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nxj = false;
    public int nxo = 0;
    public float bir = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nxp = 0;
    public float nxq = -1.0f;
    public float nxr = -1.0f;
    private int nxt = 0;
    public int nxu = 0;
    public int nxv = 0;
    public int nxw = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nxC = 0;
    public int nxD = -1;
    public j nxE = null;
    public int nxF = 0;
    public int nxG = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dNt();

    public abstract float dNu();

    public abstract float dNv();

    public abstract float dNw();

    public abstract int getType();

    public long getDuration() {
        return this.nxs.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dNn() {
        return this.nxq > -1.0f && this.nxr > -1.0f && this.nxu == this.nxE.nxQ;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nxu = this.nxE.nxQ;
    }

    public boolean isPrepared() {
        return this.nxw == this.nxE.nxV;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nxw = this.nxE.nxV;
    }

    public n<?> dNo() {
        return this.nxx;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nxt == this.nxE.nxR;
    }

    public boolean isTimeOut() {
        return this.nwQ == null || gn(this.nwQ.nxI);
    }

    public boolean gn(long j) {
        return j - dNy() >= this.nxs.value;
    }

    public boolean dNp() {
        return this.nwQ == null || go(this.nwQ.nxI);
    }

    public boolean go(long j) {
        long dNy = j - dNy();
        return dNy <= 0 || dNy >= this.nxs.value;
    }

    public boolean dNq() {
        return this.nwQ == null || this.nwQ.nxI < dNy();
    }

    public boolean dNr() {
        if (this.nxD != this.nxE.nxS) {
            this.nxC = 0;
            return false;
        }
        return true;
    }

    public boolean dNs() {
        return this.nxD == this.nxE.nxS && this.nxC != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nxt = this.nxE.nxR;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dNx() {
        return this.nwQ;
    }

    public void c(f fVar) {
        this.nwQ = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gp(long j) {
        this.nxk = j;
        this.nxv = this.nxE.nxU;
    }

    public void setTime(long j) {
        this.time = j;
        this.nxk = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dNy() {
        return (this.nxE == null || this.nxE.nxU != this.nxv) ? this.time : this.time + this.nxk;
    }

    public boolean dNz() {
        if (this.nxE == null || this.nxE.nxU != this.nxv) {
            return false;
        }
        return this.nxH;
    }
}
