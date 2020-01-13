package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class g {
    private float factor = 1.0f;
    private long nEW;
    public long value;

    public g(long j) {
        this.nEW = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nEW = j;
        this.value = ((float) this.nEW) * this.factor;
    }

    public void bG(float f) {
        if (this.factor != f) {
            this.factor = f;
            this.value = ((float) this.nEW) * f;
        }
    }
}
