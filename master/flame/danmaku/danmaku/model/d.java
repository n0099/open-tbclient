package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean lbl;
    public Object obj;
    protected f pWV;
    public n<?> pXB;
    public boolean pXC;
    public String pXD;
    public boolean pXE;
    public boolean pXK;
    public long pXp;
    public String[] pXq;
    public float pXr;
    public int pXs;
    public g pXw;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean pXo = false;
    public int underlineColor = 0;
    public float bKr = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte pXt = 0;
    public float pXu = -1.0f;
    public float pXv = -1.0f;
    private int pXx = 0;
    public int pXy = 0;
    public int pXz = 0;
    public int pXA = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int pXF = 0;
    public int pXG = -1;
    public j pXH = null;
    public int pXI = 0;
    public int pXJ = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float eDk();

    public abstract float eDl();

    public abstract float eDm();

    public abstract float eDn();

    public abstract int getType();

    public long getDuration() {
        return this.pXw.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean eDd() {
        return this.pXu > -1.0f && this.pXv > -1.0f && this.pXy == this.pXH.pXT;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.pXy = this.pXH.pXT;
    }

    public boolean isPrepared() {
        return this.pXA == this.pXH.pXY;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.pXA = this.pXH.pXY;
    }

    public n<?> eDe() {
        return this.pXB;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.pXx == this.pXH.pXU;
    }

    public boolean eDf() {
        return this.pWV == null || ip(this.pWV.pXL);
    }

    public boolean ip(long j) {
        return j - eDp() >= this.pXw.value;
    }

    public boolean eDg() {
        return this.pWV == null || iq(this.pWV.pXL);
    }

    public boolean iq(long j) {
        long eDp = j - eDp();
        return eDp <= 0 || eDp >= this.pXw.value;
    }

    public boolean eDh() {
        return this.pWV == null || this.pWV.pXL < eDp();
    }

    public boolean eDi() {
        if (this.pXG != this.pXH.pXV) {
            this.pXF = 0;
            return false;
        }
        return true;
    }

    public boolean eDj() {
        return this.pXG == this.pXH.pXV && this.pXF != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.pXx = this.pXH.pXU;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f eDo() {
        return this.pWV;
    }

    public void c(f fVar) {
        this.pWV = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void ir(long j) {
        this.pXp = j;
        this.pXz = this.pXH.pXX;
    }

    public void setTime(long j) {
        this.time = j;
        this.pXp = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long eDp() {
        return (this.pXH == null || this.pXH.pXX != this.pXz) ? this.time : this.time + this.pXp;
    }

    public boolean eDq() {
        if (this.pXH == null || this.pXH.pXX != this.pXz) {
            return false;
        }
        return this.pXK;
    }
}
