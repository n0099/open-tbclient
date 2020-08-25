package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public abstract class d {
    public int index;
    public boolean kkG;
    public Object obj;
    public long ovJ;
    public String[] ovK;
    public float ovL;
    public int ovM;
    public g ovQ;
    public n<?> ovV;
    public boolean ovW;
    public String ovX;
    public boolean ovY;
    protected f ovp;
    public boolean owe;
    public float rotationY;
    public Object tag;
    public CharSequence text;
    public int textColor;
    private long time;
    public int visibility;
    public boolean ovI = false;
    public int underlineColor = 0;
    public float btB = -1.0f;
    public int borderColor = 0;
    public int padding = 0;
    public byte ovN = 0;
    public float ovO = -1.0f;
    public float ovP = -1.0f;
    private int ovR = 0;
    public int ovS = 0;
    public int ovT = 0;
    public int ovU = -1;
    public int userId = 0;
    protected int alpha = c.MAX;
    public int ovZ = 0;
    public int owa = -1;
    public j owb = null;
    public int owc = 0;
    public int owd = -1;

    public abstract void a(m mVar, float f, float f2);

    public abstract float[] a(m mVar, long j);

    public abstract float ehD();

    public abstract float ehE();

    public abstract float ehF();

    public abstract float ehG();

    public abstract int getType();

    public long getDuration() {
        return this.ovQ.value;
    }

    public int a(m mVar) {
        return mVar.n(this);
    }

    public boolean ehw() {
        return this.ovO > -1.0f && this.ovP > -1.0f && this.ovS == this.owb.own;
    }

    public void a(m mVar, boolean z) {
        mVar.c(this, z);
        this.ovS = this.owb.own;
    }

    public boolean isPrepared() {
        return this.ovU == this.owb.ows;
    }

    public void b(m mVar, boolean z) {
        mVar.b(this, z);
        this.ovU = this.owb.ows;
    }

    public n<?> ehx() {
        return this.ovV;
    }

    public boolean isShown() {
        return this.visibility == 1 && this.ovR == this.owb.owo;
    }

    public boolean ehy() {
        return this.ovp == null || gS(this.ovp.owf);
    }

    public boolean gS(long j) {
        return j - ehI() >= this.ovQ.value;
    }

    public boolean ehz() {
        return this.ovp == null || gT(this.ovp.owf);
    }

    public boolean gT(long j) {
        long ehI = j - ehI();
        return ehI <= 0 || ehI >= this.ovQ.value;
    }

    public boolean ehA() {
        return this.ovp == null || this.ovp.owf < ehI();
    }

    public boolean ehB() {
        if (this.owa != this.owb.owp) {
            this.ovZ = 0;
            return false;
        }
        return true;
    }

    public boolean ehC() {
        return this.owa == this.owb.owp && this.ovZ != 0;
    }

    public void setVisibility(boolean z) {
        if (z) {
            this.ovR = this.owb.owo;
            this.visibility = 1;
            return;
        }
        this.visibility = 0;
    }

    public f ehH() {
        return this.ovp;
    }

    public void c(f fVar) {
        this.ovp = fVar;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void gU(long j) {
        this.ovJ = j;
        this.ovT = this.owb.owr;
    }

    public void setTime(long j) {
        this.time = j;
        this.ovJ = 0L;
    }

    public long getTime() {
        return this.time;
    }

    public long ehI() {
        return (this.owb == null || this.owb.owr != this.ovT) ? this.time : this.time + this.ovJ;
    }

    public boolean ehJ() {
        if (this.owb == null || this.owb.owr != this.ovT) {
            return false;
        }
        return this.owe;
    }
}
