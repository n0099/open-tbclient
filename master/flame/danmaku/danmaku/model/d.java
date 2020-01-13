package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public abstract class d {
    public int index;
    public boolean mwX;
    public int nEA;
    public g nEF;
    public n<?> nEK;
    public boolean nEL;
    public String nEM;
    public boolean nEN;
    public boolean nET;
    protected f nEd;
    public long nEx;
    public String[] nEy;
    public float nEz;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nEw = false;
    public int nEB = 0;
    public float aAz = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nEC = 0;
    public float nED = -1.0f;
    public float nEE = -1.0f;
    private int nEG = 0;
    public int nEH = 0;
    public int nEI = 0;
    public int nEJ = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nEO = 0;
    public int nEP = -1;
    public j nEQ = null;
    public int nER = 0;
    public int nES = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dKw();

    public abstract float dKx();

    public abstract float dKy();

    public abstract float dKz();

    public abstract int getType();

    public long getDuration() {
        return this.nEF.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dKq() {
        return this.nED > -1.0f && this.nEE > -1.0f && this.nEH == this.nEQ.nFb;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nEH = this.nEQ.nFb;
    }

    public boolean aGB() {
        return this.nEJ == this.nEQ.nFg;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nEJ = this.nEQ.nFg;
    }

    public n<?> dKr() {
        return this.nEK;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nEG == this.nEQ.nFc;
    }

    public boolean isTimeOut() {
        return this.nEd == null || hm(this.nEd.nEU);
    }

    public boolean hm(long j) {
        return j - dKB() >= this.nEF.value;
    }

    public boolean dKs() {
        return this.nEd == null || hn(this.nEd.nEU);
    }

    public boolean hn(long j) {
        long dKB = j - dKB();
        return dKB <= 0 || dKB >= this.nEF.value;
    }

    public boolean dKt() {
        return this.nEd == null || this.nEd.nEU < dKB();
    }

    public boolean dKu() {
        if (this.nEP != this.nEQ.nFd) {
            this.nEO = 0;
            return false;
        }
        return true;
    }

    public boolean dKv() {
        return this.nEP == this.nEQ.nFd && this.nEO != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nEG = this.nEQ.nFc;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dKA() {
        return this.nEd;
    }

    public void c(f fVar) {
        this.nEd = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void ho(long j) {
        this.nEx = j;
        this.nEI = this.nEQ.nFf;
    }

    public void setTime(long j) {
        this.time = j;
        this.nEx = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dKB() {
        return (this.nEQ == null || this.nEQ.nFf != this.nEI) ? this.time : this.time + this.nEx;
    }

    public boolean dKC() {
        if (this.nEQ == null || this.nEQ.nFf != this.nEI) {
            return false;
        }
        return this.nET;
    }
}
