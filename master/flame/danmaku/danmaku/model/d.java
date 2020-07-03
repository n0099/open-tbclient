package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    public boolean jMK;
    protected f nSC;
    public long nSW;
    public String[] nSX;
    public float nSY;
    public int nSZ;
    public g nTe;
    public n<?> nTj;
    public boolean nTk;
    public String nTl;
    public boolean nTm;
    public boolean nTs;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nSV = false;
    public int nTa = 0;
    public float bnu = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nTb = 0;
    public float nTc = -1.0f;
    public float nTd = -1.0f;
    private int nTf = 0;
    public int nTg = 0;
    public int nTh = 0;
    public int nTi = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nTn = 0;
    public int nTo = -1;
    public j nTp = null;
    public int nTq = 0;
    public int nTr = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dRZ();

    public abstract float dSa();

    public abstract float dSb();

    public abstract float dSc();

    public abstract int getType();

    public long getDuration() {
        return this.nTe.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dRT() {
        return this.nTc > -1.0f && this.nTd > -1.0f && this.nTg == this.nTp.nTB;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nTg = this.nTp.nTB;
    }

    public boolean isPrepared() {
        return this.nTi == this.nTp.nTG;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nTi = this.nTp.nTG;
    }

    public n<?> dRU() {
        return this.nTj;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nTf == this.nTp.nTC;
    }

    public boolean isTimeOut() {
        return this.nSC == null || gs(this.nSC.nTt);
    }

    public boolean gs(long j) {
        return j - dSe() >= this.nTe.value;
    }

    public boolean dRV() {
        return this.nSC == null || gt(this.nSC.nTt);
    }

    public boolean gt(long j) {
        long dSe = j - dSe();
        return dSe <= 0 || dSe >= this.nTe.value;
    }

    public boolean dRW() {
        return this.nSC == null || this.nSC.nTt < dSe();
    }

    public boolean dRX() {
        if (this.nTo != this.nTp.nTD) {
            this.nTn = 0;
            return false;
        }
        return true;
    }

    public boolean dRY() {
        return this.nTo == this.nTp.nTD && this.nTn != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nTf = this.nTp.nTC;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dSd() {
        return this.nSC;
    }

    public void c(f fVar) {
        this.nSC = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gu(long j) {
        this.nSW = j;
        this.nTh = this.nTp.nTF;
    }

    public void setTime(long j) {
        this.time = j;
        this.nSW = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dSe() {
        return (this.nTp == null || this.nTp.nTF != this.nTh) ? this.time : this.time + this.nSW;
    }

    public boolean dSf() {
        if (this.nTp == null || this.nTp.nTF != this.nTh) {
            return false;
        }
        return this.nTs;
    }
}
