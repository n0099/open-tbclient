package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nGe;
    private long nGf;

    public long hn(long j) {
        this.nGf = j - this.nGe;
        this.nGe = j;
        return this.nGf;
    }

    public long ho(long j) {
        return hn(this.nGe + j);
    }
}
