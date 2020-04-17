package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    protected f naA;
    public long naU;
    public String[] naV;
    public float naW;
    public int naX;
    public g nbc;
    public n<?> nbh;
    public boolean nbi;
    public boolean nbj;
    public String nbk;
    public boolean nbl;
    public boolean nbr;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean naT = false;
    public int naY = 0;
    public float baM = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte naZ = 0;
    public float nba = -1.0f;
    public float nbb = -1.0f;
    private int nbd = 0;
    public int nbe = 0;
    public int nbf = 0;
    public int nbg = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nbm = 0;
    public int nbn = -1;
    public j nbo = null;
    public int nbp = 0;
    public int nbq = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dFo();

    public abstract float dFp();

    public abstract float dFq();

    public abstract float dFr();

    public abstract int getType();

    public long getDuration() {
        return this.nbc.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dFi() {
        return this.nba > -1.0f && this.nbb > -1.0f && this.nbe == this.nbo.nbA;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nbe = this.nbo.nbA;
    }

    public boolean isPrepared() {
        return this.nbg == this.nbo.nbF;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nbg = this.nbo.nbF;
    }

    public n<?> dFj() {
        return this.nbh;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nbd == this.nbo.nbB;
    }

    public boolean isTimeOut() {
        return this.naA == null || gm(this.naA.nbs);
    }

    public boolean gm(long j) {
        return j - dFt() >= this.nbc.value;
    }

    public boolean dFk() {
        return this.naA == null || gn(this.naA.nbs);
    }

    public boolean gn(long j) {
        long dFt = j - dFt();
        return dFt <= 0 || dFt >= this.nbc.value;
    }

    public boolean dFl() {
        return this.naA == null || this.naA.nbs < dFt();
    }

    public boolean dFm() {
        if (this.nbn != this.nbo.nbC) {
            this.nbm = 0;
            return false;
        }
        return true;
    }

    public boolean dFn() {
        return this.nbn == this.nbo.nbC && this.nbm != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nbd = this.nbo.nbB;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dFs() {
        return this.naA;
    }

    public void c(f fVar) {
        this.naA = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void go(long j) {
        this.naU = j;
        this.nbf = this.nbo.nbE;
    }

    public void setTime(long j) {
        this.time = j;
        this.naU = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dFt() {
        return (this.nbo == null || this.nbo.nbE != this.nbf) ? this.time : this.time + this.naU;
    }

    public boolean dFu() {
        if (this.nbo == null || this.nbo.nbE != this.nbf) {
            return false;
        }
        return this.nbr;
    }
}
