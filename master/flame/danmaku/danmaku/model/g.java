package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long ocj;
    private float ock = 1.0f;
    public long value;

    public g(long j) {
        this.ocj = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.ocj = j;
        this.value = ((float) this.ocj) * this.ock;
    }

    public void aQ(float f) {
        if (this.ock != f) {
            this.ock = f;
            this.value = ((float) this.ocj) * f;
        }
    }
}
