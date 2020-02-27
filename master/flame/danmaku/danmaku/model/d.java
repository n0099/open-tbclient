package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    public boolean mxI;
    public g nFC;
    public n<?> nFH;
    public boolean nFI;
    public String nFJ;
    public boolean nFK;
    public boolean nFQ;
    protected f nFa;
    public long nFu;
    public String[] nFv;
    public float nFw;
    public int nFx;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nFt = false;
    public int nFy = 0;
    public float aEP = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nFz = 0;
    public float nFA = -1.0f;
    public float nFB = -1.0f;
    private int nFD = 0;
    public int nFE = 0;
    public int nFF = 0;
    public int nFG = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nFL = 0;
    public int nFM = -1;
    public j nFN = null;
    public int nFO = 0;
    public int nFP = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dLL();

    public abstract float dLM();

    public abstract float dLN();

    public abstract float dLO();

    public abstract int getType();

    public long getDuration() {
        return this.nFC.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dLF() {
        return this.nFA > -1.0f && this.nFB > -1.0f && this.nFE == this.nFN.nFY;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nFE = this.nFN.nFY;
    }

    public boolean isPrepared() {
        return this.nFG == this.nFN.nGd;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nFG = this.nFN.nGd;
    }

    public n<?> dLG() {
        return this.nFH;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nFD == this.nFN.nFZ;
    }

    public boolean isTimeOut() {
        return this.nFa == null || hk(this.nFa.nFR);
    }

    public boolean hk(long j) {
        return j - dLQ() >= this.nFC.value;
    }

    public boolean dLH() {
        return this.nFa == null || hl(this.nFa.nFR);
    }

    public boolean hl(long j) {
        long dLQ = j - dLQ();
        return dLQ <= 0 || dLQ >= this.nFC.value;
    }

    public boolean dLI() {
        return this.nFa == null || this.nFa.nFR < dLQ();
    }

    public boolean dLJ() {
        if (this.nFM != this.nFN.nGa) {
            this.nFL = 0;
            return false;
        }
        return true;
    }

    public boolean dLK() {
        return this.nFM == this.nFN.nGa && this.nFL != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nFD = this.nFN.nFZ;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dLP() {
        return this.nFa;
    }

    public void c(f fVar) {
        this.nFa = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hm(long j) {
        this.nFu = j;
        this.nFF = this.nFN.nGc;
    }

    public void setTime(long j) {
        this.time = j;
        this.nFu = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dLQ() {
        return (this.nFN == null || this.nFN.nGc != this.nFF) ? this.time : this.time + this.nFu;
    }

    public boolean dLR() {
        if (this.nFN == null || this.nFN.nGc != this.nFF) {
            return false;
        }
        return this.nFQ;
    }
}
