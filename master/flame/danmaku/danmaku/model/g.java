package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private long nwA;
    private float nwB = 1.0f;
    public long value;

    public g(long j) {
        this.nwA = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nwA = j;
        this.value = ((float) this.nwA) * this.nwB;
    }

    public void aL(float f) {
        if (this.nwB != f) {
            this.nwB = f;
            this.value = ((float) this.nwA) * f;
        }
    }
}
