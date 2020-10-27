package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long pMO;
    private long pMP;

    public long hT(long j) {
        this.pMP = j - this.pMO;
        this.pMO = j;
        return this.pMP;
    }

    public long hU(long j) {
        return hT(this.pMO + j);
    }
}
