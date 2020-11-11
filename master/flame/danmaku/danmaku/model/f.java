package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long pWi;
    private long pWj;

    public long ip(long j) {
        this.pWj = j - this.pWi;
        this.pWi = j;
        return this.pWj;
    }

    public long iq(long j) {
        return ip(this.pWi + j);
    }
}
