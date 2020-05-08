package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nbv;
    private long nbw;

    public long gp(long j) {
        this.nbw = j - this.nbv;
        this.nbv = j;
        return this.nbw;
    }

    public long gq(long j) {
        return gp(this.nbv + j);
    }
}
