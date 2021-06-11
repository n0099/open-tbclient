package d.a.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f42571a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42572b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f42572b) {
                this.f42572b = true;
                this.f42571a = d();
            }
        }
        return this.f42571a;
    }
}
