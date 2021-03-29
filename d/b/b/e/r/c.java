package d.b.b.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f42059a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42060b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f42060b) {
                this.f42060b = true;
                this.f42059a = d();
            }
        }
        return this.f42059a;
    }
}
