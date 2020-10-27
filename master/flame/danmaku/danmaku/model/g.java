package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long pMQ;
    private float pMR = 1.0f;
    public long value;

    public g(long j) {
        this.pMQ = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.pMQ = j;
        this.value = ((float) this.pMQ) * this.pMR;
    }

    public void bt(float f) {
        if (this.pMR != f) {
            this.pMR = f;
            this.value = ((float) this.pMQ) * f;
        }
    }
}
