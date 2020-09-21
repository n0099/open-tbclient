package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long oGf;
    private float oGg = 1.0f;
    public long value;

    public g(long j) {
        this.oGf = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.oGf = j;
        this.value = ((float) this.oGf) * this.oGg;
    }

    public void aW(float f) {
        if (this.oGg != f) {
            this.oGg = f;
            this.value = ((float) this.oGf) * f;
        }
    }
}
