package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long pWk;
    private float pWl = 1.0f;
    public long value;

    public g(long j) {
        this.pWk = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.pWk = j;
        this.value = ((float) this.pWk) * this.pWl;
    }

    public void bv(float f) {
        if (this.pWl != f) {
            this.pWl = f;
            this.value = ((float) this.pWk) * f;
        }
    }
}
