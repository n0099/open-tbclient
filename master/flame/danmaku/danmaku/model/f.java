package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nFT;
    private long nFU;

    public long hn(long j) {
        this.nFU = j - this.nFT;
        this.nFT = j;
        return this.nFU;
    }

    public long ho(long j) {
        return hn(this.nFT + j);
    }
}
