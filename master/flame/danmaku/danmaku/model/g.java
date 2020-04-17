package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private long nbu;
    private float nbv = 1.0f;
    public long value;

    public g(long j) {
        this.nbu = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nbu = j;
        this.value = ((float) this.nbu) * this.nbv;
    }

    public void aM(float f) {
        if (this.nbv != f) {
            this.nbv = f;
            this.value = ((float) this.nbu) * f;
        }
    }
}
