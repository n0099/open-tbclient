package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nFR;
    private long nFS;

    public long hn(long j) {
        this.nFS = j - this.nFR;
        this.nFR = j;
        return this.nFS;
    }

    public long ho(long j) {
        return hn(this.nFR + j);
    }
}
