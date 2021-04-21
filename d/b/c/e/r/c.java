package d.b.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f42796a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42797b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f42797b) {
                this.f42797b = true;
                this.f42796a = d();
            }
        }
        return this.f42796a;
    }
}
