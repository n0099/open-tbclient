package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long pXL;
    private long pXM;

    public long is(long j) {
        this.pXM = j - this.pXL;
        this.pXL = j;
        return this.pXM;
    }

    public long it(long j) {
        return is(this.pXL + j);
    }
}
