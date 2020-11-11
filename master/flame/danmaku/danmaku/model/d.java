package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean laS;
    public Object obj;
    public long pVM;
    public String[] pVN;
    public float pVO;
    public int pVP;
    public g pVT;
    public n<?> pVY;
    public boolean pVZ;
    protected f pVs;
    public String pWa;
    public boolean pWb;
    public boolean pWh;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean pVL = false;
    public int underlineColor = 0;
    public float bMb = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte pVQ = 0;
    public float pVR = -1.0f;
    public float pVS = -1.0f;
    private int pVU = 0;
    public int pVV = 0;
    public int pVW = 0;
    public int pVX = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int pWc = 0;
    public int pWd = -1;
    public j pWe = null;
    public int pWf = 0;
    public int pWg = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float eDj();

    public abstract float eDk();

    public abstract float eDl();

    public abstract float eDm();

    public abstract int getType();

    public long getDuration() {
        return this.pVT.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean eDc() {
        return this.pVR > -1.0f && this.pVS > -1.0f && this.pVV == this.pWe.pWq;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.pVV = this.pWe.pWq;
    }

    public boolean isPrepared() {
        return this.pVX == this.pWe.pWv;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.pVX = this.pWe.pWv;
    }

    public n<?> eDd() {
        return this.pVY;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.pVU == this.pWe.pWr;
    }

    public boolean eDe() {
        return this.pVs == null || im(this.pVs.pWi);
    }

    public boolean im(long j) {
        return j - eDo() >= this.pVT.value;
    }

    public boolean eDf() {
        return this.pVs == null || in(this.pVs.pWi);
    }

    public boolean in(long j) {
        long eDo = j - eDo();
        return eDo <= 0 || eDo >= this.pVT.value;
    }

    public boolean eDg() {
        return this.pVs == null || this.pVs.pWi < eDo();
    }

    public boolean eDh() {
        if (this.pWd != this.pWe.pWs) {
            this.pWc = 0;
            return false;
        }
        return true;
    }

    public boolean eDi() {
        return this.pWd == this.pWe.pWs && this.pWc != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.pVU = this.pWe.pWr;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f eDn() {
        return this.pVs;
    }

    public void c(f fVar) {
        this.pVs = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void io(long j) {
        this.pVM = j;
        this.pVW = this.pWe.pWu;
    }

    public void setTime(long j) {
        this.time = j;
        this.pVM = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long eDo() {
        return (this.pWe == null || this.pWe.pWu != this.pVW) ? this.time : this.time + this.pVM;
    }

    public boolean eDp() {
        if (this.pWe == null || this.pWe.pWu != this.pVW) {
            return false;
        }
        return this.pWh;
    }
}
