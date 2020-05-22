package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nwy;
    private long nwz;

    public long gq(long j) {
        this.nwz = j - this.nwy;
        this.nwy = j;
        return this.nwz;
    }

    public long gr(long j) {
        return gq(this.nwy + j);
    }
}
