package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class g {
    private long nbx;
    private float nby = 1.0f;
    public long value;

    public g(long j) {
        this.nbx = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.nbx = j;
        this.value = ((float) this.nbx) * this.nby;
    }

    public void aM(float f) {
        if (this.nby != f) {
            this.nby = f;
            this.value = ((float) this.nbx) * f;
        }
    }
}
