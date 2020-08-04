package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class f {
    public long och;
    private long oci;

    public long gI(long j) {
        this.oci = j - this.och;
        this.och = j;
        return this.oci;
    }

    public long gJ(long j) {
        return gI(this.och + j);
    }
}
