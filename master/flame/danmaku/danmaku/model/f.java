package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class f {
    public long nTw;
    private long nTx;

    public long gv(long j) {
        this.nTx = j - this.nTw;
        this.nTw = j;
        return this.nTx;
    }

    public long gw(long j) {
        return gv(this.nTw + j);
    }
}
