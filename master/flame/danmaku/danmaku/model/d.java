package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public abstract class d {
    public int index;
    public boolean jMK;
    protected f nSF;
    public long nSZ;
    public String[] nTa;
    public float nTb;
    public int nTc;
    public g nTh;
    public n<?> nTm;
    public boolean nTn;
    public String nTo;
    public boolean nTp;
    public boolean nTv;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean nSY = false;
    public int nTd = 0;
    public float bnu = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte nTe = 0;
    public float nTf = -1.0f;
    public float nTg = -1.0f;
    private int nTi = 0;
    public int nTj = 0;
    public int nTk = 0;
    public int nTl = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int nTq = 0;
    public int nTr = -1;
    public j nTs = null;
    public int nTt = 0;
    public int nTu = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float dSd();

    public abstract float dSe();

    public abstract float dSf();

    public abstract float dSg();

    public abstract int getType();

    public long getDuration() {
        return this.nTh.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean dRX() {
        return this.nTf > -1.0f && this.nTg > -1.0f && this.nTj == this.nTs.nTE;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.nTj = this.nTs.nTE;
    }

    public boolean isPrepared() {
        return this.nTl == this.nTs.nTJ;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.nTl = this.nTs.nTJ;
    }

    public n<?> dRY() {
        return this.nTm;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.nTi == this.nTs.nTF;
    }

    public boolean isTimeOut() {
        return this.nSF == null || gs(this.nSF.nTw);
    }

    public boolean gs(long j) {
        return j - dSi() >= this.nTh.value;
    }

    public boolean dRZ() {
        return this.nSF == null || gt(this.nSF.nTw);
    }

    public boolean gt(long j) {
        long dSi = j - dSi();
        return dSi <= 0 || dSi >= this.nTh.value;
    }

    public boolean dSa() {
        return this.nSF == null || this.nSF.nTw < dSi();
    }

    public boolean dSb() {
        if (this.nTr != this.nTs.nTG) {
            this.nTq = 0;
            return false;
        }
        return true;
    }

    public boolean dSc() {
        return this.nTr == this.nTs.nTG && this.nTq != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.nTi = this.nTs.nTF;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f dSh() {
        return this.nSF;
    }

    public void c(f fVar) {
        this.nSF = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gu(long j) {
        this.nSZ = j;
        this.nTk = this.nTs.nTI;
    }

    public void setTime(long j) {
        this.time = j;
        this.nSZ = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long dSi() {
        return (this.nTs == null || this.nTs.nTI != this.nTk) ? this.time : this.time + this.nSZ;
    }

    public boolean dSj() {
        if (this.nTs == null || this.nTs.nTI != this.nTk) {
            return false;
        }
        return this.nTv;
    }
}
