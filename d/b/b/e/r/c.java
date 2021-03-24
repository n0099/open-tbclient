package d.b.b.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f42058a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42059b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f42059b) {
                this.f42059b = true;
                this.f42058a = d();
            }
        }
        return this.f42058a;
    }
}
