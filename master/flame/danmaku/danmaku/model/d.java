package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    protected f naD;
    public long naX;
    public String[] naY;
    public float naZ;
    public int nba;
    public g nbf;
    public n<?> nbk;
    public boolean nbl;
    public boolean nbm;
    public String nbn;
    public boolean nbo;
    public boolean nbu;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean naW = false;
    public int nbb = 0;
    public float baR = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nbc = 0;
    public float nbd = -1.0f;
    public float nbe = -1.0f;
    private int nbg = 0;
    public int nbh = 0;
    public int nbi = 0;
    public int nbj = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nbp = 0;
    public int nbq = -1;
    public j nbr = null;
    public int nbs = 0;
    public int nbt = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dFk();

    public abstract float dFl();

    public abstract float dFm();

    public abstract float dFn();

    public abstract int getType();

    public long getDuration() {
        return this.nbf.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dFe() {
        return this.nbd > -1.0f && this.nbe > -1.0f && this.nbh == this.nbr.nbD;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nbh = this.nbr.nbD;
    }

    public boolean isPrepared() {
        return this.nbj == this.nbr.nbI;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nbj = this.nbr.nbI;
    }

    public n<?> dFf() {
        return this.nbk;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nbg == this.nbr.nbE;
    }

    public boolean isTimeOut() {
        return this.naD == null || gm(this.naD.nbv);
    }

    public boolean gm(long j) {
        return j - dFp() >= this.nbf.value;
    }

    public boolean dFg() {
        return this.naD == null || gn(this.naD.nbv);
    }

    public boolean gn(long j) {
        long dFp = j - dFp();
        return dFp <= 0 || dFp >= this.nbf.value;
    }

    public boolean dFh() {
        return this.naD == null || this.naD.nbv < dFp();
    }

    public boolean dFi() {
        if (this.nbq != this.nbr.nbF) {
            this.nbp = 0;
            return false;
        }
        return true;
    }

    public boolean dFj() {
        return this.nbq == this.nbr.nbF && this.nbp != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nbg = this.nbr.nbE;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dFo() {
        return this.naD;
    }

    public void c(f fVar) {
        this.naD = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void go(long j) {
        this.naX = j;
        this.nbi = this.nbr.nbH;
    }

    public void setTime(long j) {
        this.time = j;
        this.naX = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dFp() {
        return (this.nbr == null || this.nbr.nbH != this.nbi) ? this.time : this.time + this.naX;
    }

    public boolean dFq() {
        if (this.nbr == null || this.nbr.nbH != this.nbi) {
            return false;
        }
        return this.nbu;
    }
}
