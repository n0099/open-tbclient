package d.b.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f42556a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42557b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f42557b) {
                this.f42557b = true;
                this.f42556a = d();
            }
        }
        return this.f42556a;
    }
}
