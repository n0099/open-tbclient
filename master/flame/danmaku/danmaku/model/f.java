package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long oGd;
    private long oGe;

    public long hl(long j) {
        this.oGe = j - this.oGd;
        this.oGd = j;
        return this.oGe;
    }

    public long hm(long j) {
        return hl(this.oGd + j);
    }
}
