package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    protected f nvG;
    public long nwa;
    public String[] nwb;
    public float nwc;
    public int nwd;
    public g nwi;
    public n<?> nwn;
    public boolean nwo;
    public boolean nwp;
    public String nwq;
    public boolean nwr;
    public boolean nwx;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nvZ = false;
    public int nwe = 0;
    public float bir = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nwf = 0;
    public float nwg = -1.0f;
    public float nwh = -1.0f;
    private int nwj = 0;
    public int nwk = 0;
    public int nwl = 0;
    public int nwm = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nws = 0;
    public int nwt = -1;
    public j nwu = null;
    public int nwv = 0;
    public int nww = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dNf();

    public abstract float dNg();

    public abstract float dNh();

    public abstract float dNi();

    public abstract int getType();

    public long getDuration() {
        return this.nwi.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dMZ() {
        return this.nwg > -1.0f && this.nwh > -1.0f && this.nwk == this.nwu.nwG;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nwk = this.nwu.nwG;
    }

    public boolean isPrepared() {
        return this.nwm == this.nwu.nwL;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nwm = this.nwu.nwL;
    }

    public n<?> dNa() {
        return this.nwn;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nwj == this.nwu.nwH;
    }

    public boolean isTimeOut() {
        return this.nvG == null || gn(this.nvG.nwy);
    }

    public boolean gn(long j) {
        return j - dNk() >= this.nwi.value;
    }

    public boolean dNb() {
        return this.nvG == null || go(this.nvG.nwy);
    }

    public boolean go(long j) {
        long dNk = j - dNk();
        return dNk <= 0 || dNk >= this.nwi.value;
    }

    public boolean dNc() {
        return this.nvG == null || this.nvG.nwy < dNk();
    }

    public boolean dNd() {
        if (this.nwt != this.nwu.nwI) {
            this.nws = 0;
            return false;
        }
        return true;
    }

    public boolean dNe() {
        return this.nwt == this.nwu.nwI && this.nws != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nwj = this.nwu.nwH;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dNj() {
        return this.nvG;
    }

    public void c(f fVar) {
        this.nvG = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gp(long j) {
        this.nwa = j;
        this.nwl = this.nwu.nwK;
    }

    public void setTime(long j) {
        this.time = j;
        this.nwa = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dNk() {
        return (this.nwu == null || this.nwu.nwK != this.nwl) ? this.time : this.time + this.nwa;
    }

    public boolean dNl() {
        if (this.nwu == null || this.nwu.nwK != this.nwl) {
            return false;
        }
        return this.nwx;
    }
}
