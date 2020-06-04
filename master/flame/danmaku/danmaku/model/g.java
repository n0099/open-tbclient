package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private long nxK;
    private float nxL = 1.0f;
    public long value;

    public g(long j) {
        this.nxK = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nxK = j;
        this.value = ((float) this.nxK) * this.nxL;
    }

    public void aL(float f) {
        if (this.nxL != f) {
            this.nxL = f;
            this.value = ((float) this.nxK) * f;
        }
    }
}
