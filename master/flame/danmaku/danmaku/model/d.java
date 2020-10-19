package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean kIy;
    protected f oUC;
    public long oUW;
    public String[] oUX;
    public float oUY;
    public int oUZ;
    public g oVd;
    public n<?> oVi;
    public boolean oVj;
    public String oVk;
    public boolean oVl;
    public boolean oVr;
    public Object obj;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean oUV = false;
    public int underlineColor = 0;
    public float bDA = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte oVa = 0;
    public float oVb = -1.0f;
    public float oVc = -1.0f;
    private int oVe = 0;
    public int oVf = 0;
    public int oVg = 0;
    public int oVh = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int oVm = 0;
    public int oVn = -1;
    public j oVo = null;
    public int oVp = 0;
    public int oVq = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float epw();

    public abstract float epx();

    public abstract float epy();

    public abstract float epz();

    public abstract int getType();

    public long getDuration() {
        return this.oVd.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean epp() {
        return this.oVb > -1.0f && this.oVc > -1.0f && this.oVf == this.oVo.oVA;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.oVf = this.oVo.oVA;
    }

    public boolean isPrepared() {
        return this.oVh == this.oVo.oVF;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.oVh = this.oVo.oVF;
    }

    public n<?> epq() {
        return this.oVi;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.oVe == this.oVo.oVB;
    }

    public boolean epr() {
        return this.oUC == null || hA(this.oUC.oVs);
    }

    public boolean hA(long j) {
        return j - epB() >= this.oVd.value;
    }

    public boolean eps() {
        return this.oUC == null || hB(this.oUC.oVs);
    }

    public boolean hB(long j) {
        long epB = j - epB();
        return epB <= 0 || epB >= this.oVd.value;
    }

    public boolean ept() {
        return this.oUC == null || this.oUC.oVs < epB();
    }

    public boolean epu() {
        if (this.oVn != this.oVo.oVC) {
            this.oVm = 0;
            return false;
        }
        return true;
    }

    public boolean epv() {
        return this.oVn == this.oVo.oVC && this.oVm != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.oVe = this.oVo.oVB;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f epA() {
        return this.oUC;
    }

    public void c(f fVar) {
        this.oUC = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void hC(long j) {
        this.oUW = j;
        this.oVg = this.oVo.oVE;
    }

    public void setTime(long j) {
        this.time = j;
        this.oUW = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long epB() {
        return (this.oVo == null || this.oVo.oVE != this.oVg) ? this.time : this.time + this.oUW;
    }

    public boolean epC() {
        if (this.oVo == null || this.oVo.oVE != this.oVg) {
            return false;
        }
        return this.oVr;
    }
}
