package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long och;
    private float oci = 1.0f;
    public long value;

    public g(long j) {
        this.och = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.och = j;
        this.value = ((float) this.och) * this.oci;
    }

    public void aQ(float f) {
        if (this.oci != f) {
            this.oci = f;
            this.value = ((float) this.och) * f;
        }
    }
}
