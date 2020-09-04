package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long owx;
    private long owy;

    public long gX(long j) {
        this.owy = j - this.owx;
        this.owx = j;
        return this.owy;
    }

    public long gY(long j) {
        return gX(this.owx + j);
    }
}
