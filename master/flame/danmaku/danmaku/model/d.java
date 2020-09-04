package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean kkN;
    public Object obj;
    protected f ovH;
    public long owb;
    public String[] owc;
    public float owd;
    public int owe;
    public g owi;
    public n<?> own;
    public boolean owo;
    public String owp;
    public boolean owq;
    public boolean oww;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean owa = false;
    public int underlineColor = 0;
    public float btE = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte owf = 0;
    public float owg = -1.0f;
    public float owh = -1.0f;
    private int owj = 0;
    public int owk = 0;
    public int owl = 0;
    public int owm = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int owr = 0;
    public int ows = -1;
    public j owt = null;
    public int owu = 0;
    public int owv = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float ehM();

    public abstract float ehN();

    public abstract float ehO();

    public abstract float ehP();

    public abstract int getType();

    public long getDuration() {
        return this.owi.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean ehF() {
        return this.owg > -1.0f && this.owh > -1.0f && this.owk == this.owt.owF;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.owk = this.owt.owF;
    }

    public boolean isPrepared() {
        return this.owm == this.owt.owK;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.owm = this.owt.owK;
    }

    public n<?> ehG() {
        return this.own;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.owj == this.owt.owG;
    }

    public boolean ehH() {
        return this.ovH == null || gU(this.ovH.owx);
    }

    public boolean gU(long j) {
        return j - ehR() >= this.owi.value;
    }

    public boolean ehI() {
        return this.ovH == null || gV(this.ovH.owx);
    }

    public boolean gV(long j) {
        long ehR = j - ehR();
        return ehR <= 0 || ehR >= this.owi.value;
    }

    public boolean ehJ() {
        return this.ovH == null || this.ovH.owx < ehR();
    }

    public boolean ehK() {
        if (this.ows != this.owt.owH) {
            this.owr = 0;
            return false;
        }
        return true;
    }

    public boolean ehL() {
        return this.ows == this.owt.owH && this.owr != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.owj = this.owt.owG;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f ehQ() {
        return this.ovH;
    }

    public void c(f fVar) {
        this.ovH = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gW(long j) {
        this.owb = j;
        this.owl = this.owt.owJ;
    }

    public void setTime(long j) {
        this.time = j;
        this.owb = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long ehR() {
        return (this.owt == null || this.owt.owJ != this.owl) ? this.time : this.time + this.owb;
    }

    public boolean ehS() {
        if (this.owt == null || this.owt.owJ != this.owl) {
            return false;
        }
        return this.oww;
    }
}
