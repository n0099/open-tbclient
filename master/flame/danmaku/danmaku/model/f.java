package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nTt;
    private long nTu;

    public long gv(long j) {
        this.nTu = j - this.nTt;
        this.nTt = j;
        return this.nTu;
    }

    public long gw(long j) {
        return gv(this.nTt + j);
    }
}
