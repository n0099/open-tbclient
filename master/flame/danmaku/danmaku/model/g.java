package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long pXN;
    private float pXO = 1.0f;
    public long value;

    public g(long j) {
        this.pXN = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.pXN = j;
        this.value = ((float) this.pXN) * this.pXO;
    }

    public void bD(float f) {
        if (this.pXO != f) {
            this.pXO = f;
            this.value = ((float) this.pXN) * f;
        }
    }
}
