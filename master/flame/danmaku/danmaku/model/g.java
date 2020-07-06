package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private long nTy;
    private float nTz = 1.0f;
    public long value;

    public g(long j) {
        this.nTy = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nTy = j;
        this.value = ((float) this.nTy) * this.nTz;
    }

    public void aR(float f) {
        if (this.nTz != f) {
            this.nTz = f;
            this.value = ((float) this.nTy) * f;
        }
    }
}
