package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class f {
    public long nEU;
    private long nEV;

    public long hp(long j) {
        this.nEV = j - this.nEU;
        this.nEU = j;
        return this.nEV;
    }

    public long hq(long j) {
        return hp(this.nEU + j);
    }
}
