package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private float factor = 1.0f;
    private long nFT;
    public long value;

    public g(long j) {
        this.nFT = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nFT = j;
        this.value = ((float) this.nFT) * this.factor;
    }

    public void bF(float f) {
        if (this.factor != f) {
            this.factor = f;
            this.value = ((float) this.nFT) * f;
        }
    }
}
