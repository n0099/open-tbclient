package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nHR;
    private long nHS;

    public long ho(long j) {
        this.nHS = j - this.nHR;
        this.nHR = j;
        return this.nHS;
    }

    public long hp(long j) {
        return ho(this.nHR + j);
    }
}
