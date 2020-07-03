package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private long nTv;
    private float nTw = 1.0f;
    public long value;

    public g(long j) {
        this.nTv = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nTv = j;
        this.value = ((float) this.nTv) * this.nTw;
    }

    public void aR(float f) {
        if (this.nTw != f) {
            this.nTw = f;
            this.value = ((float) this.nTv) * f;
        }
    }
}
