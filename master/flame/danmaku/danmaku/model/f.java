package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long ocf;
    private long ocg;

    public long gI(long j) {
        this.ocg = j - this.ocf;
        this.ocf = j;
        return this.ocg;
    }

    public long gJ(long j) {
        return gI(this.ocf + j);
    }
}
