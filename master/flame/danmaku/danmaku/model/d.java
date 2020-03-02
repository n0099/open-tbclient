package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    public boolean mxK;
    public g nFE;
    public n<?> nFJ;
    public boolean nFK;
    public String nFL;
    public boolean nFM;
    public boolean nFS;
    protected f nFc;
    public long nFw;
    public String[] nFx;
    public float nFy;
    public int nFz;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nFv = false;
    public int nFA = 0;
    public float aEQ = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nFB = 0;
    public float nFC = -1.0f;
    public float nFD = -1.0f;
    private int nFF = 0;
    public int nFG = 0;
    public int nFH = 0;
    public int nFI = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nFN = 0;
    public int nFO = -1;
    public j nFP = null;
    public int nFQ = 0;
    public int nFR = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dLN();

    public abstract float dLO();

    public abstract float dLP();

    public abstract float dLQ();

    public abstract int getType();

    public long getDuration() {
        return this.nFE.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dLH() {
        return this.nFC > -1.0f && this.nFD > -1.0f && this.nFG == this.nFP.nGa;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nFG = this.nFP.nGa;
    }

    public boolean isPrepared() {
        return this.nFI == this.nFP.nGf;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nFI = this.nFP.nGf;
    }

    public n<?> dLI() {
        return this.nFJ;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nFF == this.nFP.nGb;
    }

    public boolean isTimeOut() {
        return this.nFc == null || hk(this.nFc.nFT);
    }

    public boolean hk(long j) {
        return j - dLS() >= this.nFE.value;
    }

    public boolean dLJ() {
        return this.nFc == null || hl(this.nFc.nFT);
    }

    public boolean hl(long j) {
        long dLS = j - dLS();
        return dLS <= 0 || dLS >= this.nFE.value;
    }

    public boolean dLK() {
        return this.nFc == null || this.nFc.nFT < dLS();
    }

    public boolean dLL() {
        if (this.nFO != this.nFP.nGc) {
            this.nFN = 0;
            return false;
        }
        return true;
    }

    public boolean dLM() {
        return this.nFO == this.nFP.nGc && this.nFN != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nFF = this.nFP.nGb;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dLR() {
        return this.nFc;
    }

    public void c(f fVar) {
        this.nFc = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hm(long j) {
        this.nFw = j;
        this.nFH = this.nFP.nGe;
    }

    public void setTime(long j) {
        this.time = j;
        this.nFw = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dLS() {
        return (this.nFP == null || this.nFP.nGe != this.nFH) ? this.time : this.time + this.nFw;
    }

    public boolean dLT() {
        if (this.nFP == null || this.nFP.nGe != this.nFH) {
            return false;
        }
        return this.nFS;
    }
}
