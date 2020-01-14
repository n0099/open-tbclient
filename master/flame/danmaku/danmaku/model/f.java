package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class f {
    public long nEZ;
    private long nFa;

    public long hp(long j) {
        this.nFa = j - this.nEZ;
        this.nEZ = j;
        return this.nFa;
    }

    public long hq(long j) {
        return hp(this.nEZ + j);
    }
}
