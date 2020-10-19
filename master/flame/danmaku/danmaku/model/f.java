package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long oVs;
    private long oVt;

    public long hD(long j) {
        this.oVt = j - this.oVs;
        this.oVs = j;
        return this.oVt;
    }

    public long hE(long j) {
        return hD(this.oVs + j);
    }
}
