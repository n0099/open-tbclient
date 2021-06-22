package d.a.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f42674a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42675b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f42675b) {
                this.f42675b = true;
                this.f42674a = d();
            }
        }
        return this.f42674a;
    }
}
