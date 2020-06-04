package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nxI;
    private long nxJ;

    public long gq(long j) {
        this.nxJ = j - this.nxI;
        this.nxI = j;
        return this.nxJ;
    }

    public long gr(long j) {
        return gq(this.nxI + j);
    }
}
