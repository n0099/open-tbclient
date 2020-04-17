package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nbs;
    private long nbt;

    public long gp(long j) {
        this.nbt = j - this.nbs;
        this.nbs = j;
        return this.nbt;
    }

    public long gq(long j) {
        return gp(this.nbs + j);
    }
}
