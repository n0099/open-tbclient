package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public abstract class d {
    public int index;
    public boolean mxc;
    public long nEC;
    public String[] nED;
    public float nEE;
    public int nEF;
    public g nEK;
    public n<?> nEP;
    public boolean nEQ;
    public String nER;
    public boolean nES;
    public boolean nEY;
    protected f nEi;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nEB = false;
    public int nEG = 0;
    public float aAz = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nEH = 0;
    public float nEI = -1.0f;
    public float nEJ = -1.0f;
    private int nEL = 0;
    public int nEM = 0;
    public int nEN = 0;
    public int nEO = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nET = 0;
    public int nEU = -1;
    public j nEV = null;
    public int nEW = 0;
    public int nEX = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dKA();

    public abstract float dKB();

    public abstract float dKy();

    public abstract float dKz();

    public abstract int getType();

    public long getDuration() {
        return this.nEK.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dKs() {
        return this.nEI > -1.0f && this.nEJ > -1.0f && this.nEM == this.nEV.nFg;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nEM = this.nEV.nFg;
    }

    public boolean aGB() {
        return this.nEO == this.nEV.nFl;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nEO = this.nEV.nFl;
    }

    public n<?> dKt() {
        return this.nEP;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nEL == this.nEV.nFh;
    }

    public boolean isTimeOut() {
        return this.nEi == null || hm(this.nEi.nEZ);
    }

    public boolean hm(long j) {
        return j - dKD() >= this.nEK.value;
    }

    public boolean dKu() {
        return this.nEi == null || hn(this.nEi.nEZ);
    }

    public boolean hn(long j) {
        long dKD = j - dKD();
        return dKD <= 0 || dKD >= this.nEK.value;
    }

    public boolean dKv() {
        return this.nEi == null || this.nEi.nEZ < dKD();
    }

    public boolean dKw() {
        if (this.nEU != this.nEV.nFi) {
            this.nET = 0;
            return false;
        }
        return true;
    }

    public boolean dKx() {
        return this.nEU == this.nEV.nFi && this.nET != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nEL = this.nEV.nFh;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dKC() {
        return this.nEi;
    }

    public void c(f fVar) {
        this.nEi = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void ho(long j) {
        this.nEC = j;
        this.nEN = this.nEV.nFk;
    }

    public void setTime(long j) {
        this.time = j;
        this.nEC = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dKD() {
        return (this.nEV == null || this.nEV.nFk != this.nEN) ? this.time : this.time + this.nEC;
    }

    public boolean dKE() {
        if (this.nEV == null || this.nEV.nFk != this.nEN) {
            return false;
        }
        return this.nEY;
    }
}
