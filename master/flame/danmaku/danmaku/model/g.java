package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class g {
    private long oVu;
    private float oVv = 1.0f;
    public long value;

    public g(long j) {
        this.oVu = j;
        this.value = j;
    }

    public void setValue(long j) {
        this.oVu = j;
        this.value = ((float) this.oVu) * this.oVv;
    }

    public void bc(float f) {
        if (this.oVv != f) {
            this.oVv = f;
            this.value = ((float) this.oVu) * f;
        }
    }
}
