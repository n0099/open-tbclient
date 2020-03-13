package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    public boolean mxV;
    public long nFH;
    public String[] nFI;
    public float nFJ;
    public int nFK;
    public g nFP;
    public n<?> nFU;
    public boolean nFV;
    public String nFW;
    public boolean nFX;
    protected f nFn;
    public boolean nGd;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nFG = false;
    public int nFL = 0;
    public float aER = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nFM = 0;
    public float nFN = -1.0f;
    public float nFO = -1.0f;
    private int nFQ = 0;
    public int nFR = 0;
    public int nFS = 0;
    public int nFT = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nFY = 0;
    public int nFZ = -1;
    public j nGa = null;
    public int nGb = 0;
    public int nGc = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dLO();

    public abstract float dLP();

    public abstract float dLQ();

    public abstract float dLR();

    public abstract int getType();

    public long getDuration() {
        return this.nFP.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dLI() {
        return this.nFN > -1.0f && this.nFO > -1.0f && this.nFR == this.nGa.nGl;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nFR = this.nGa.nGl;
    }

    public boolean isPrepared() {
        return this.nFT == this.nGa.nGq;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nFT = this.nGa.nGq;
    }

    public n<?> dLJ() {
        return this.nFU;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nFQ == this.nGa.nGm;
    }

    public boolean isTimeOut() {
        return this.nFn == null || hk(this.nFn.nGe);
    }

    public boolean hk(long j) {
        return j - dLT() >= this.nFP.value;
    }

    public boolean dLK() {
        return this.nFn == null || hl(this.nFn.nGe);
    }

    public boolean hl(long j) {
        long dLT = j - dLT();
        return dLT <= 0 || dLT >= this.nFP.value;
    }

    public boolean dLL() {
        return this.nFn == null || this.nFn.nGe < dLT();
    }

    public boolean dLM() {
        if (this.nFZ != this.nGa.nGn) {
            this.nFY = 0;
            return false;
        }
        return true;
    }

    public boolean dLN() {
        return this.nFZ == this.nGa.nGn && this.nFY != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nFQ = this.nGa.nGm;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dLS() {
        return this.nFn;
    }

    public void c(f fVar) {
        this.nFn = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hm(long j) {
        this.nFH = j;
        this.nFS = this.nGa.nGp;
    }

    public void setTime(long j) {
        this.time = j;
        this.nFH = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dLT() {
        return (this.nGa == null || this.nGa.nGp != this.nFS) ? this.time : this.time + this.nFH;
    }

    public boolean dLU() {
        if (this.nGa == null || this.nGa.nGp != this.nFS) {
            return false;
        }
        return this.nGd;
    }
}
