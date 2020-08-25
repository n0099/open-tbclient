package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long owf;
    private long owg;

    public long gV(long j) {
        this.owg = j - this.owf;
        this.owf = j;
        return this.owg;
    }

    public long gW(long j) {
        return gV(this.owf + j);
    }
}
