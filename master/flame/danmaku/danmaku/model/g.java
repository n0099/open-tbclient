package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private float owA = 1.0f;
    private long owz;
    public long value;

    public g(long j) {
        this.owz = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.owz = j;
        this.value = ((float) this.owz) * this.owA;
    }

    public void aW(float f) {
        if (this.owA != f) {
            this.owA = f;
            this.value = ((float) this.owz) * f;
        }
    }
}
