package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class g {
    private float factor = 1.0f;
    private long nFb;
    public long value;

    public g(long j) {
        this.nFb = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nFb = j;
        this.value = ((float) this.nFb) * this.factor;
    }

    public void bG(float f) {
        if (this.factor != f) {
            this.factor = f;
            this.value = ((float) this.nFb) * f;
        }
    }
}
