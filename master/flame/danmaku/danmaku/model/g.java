package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long owh;
    private float owi = 1.0f;
    public long value;

    public g(long j) {
        this.owh = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.owh = j;
        this.value = ((float) this.owh) * this.owi;
    }

    public void aW(float f) {
        if (this.owi != f) {
            this.owi = f;
            this.value = ((float) this.owh) * f;
        }
    }
}
