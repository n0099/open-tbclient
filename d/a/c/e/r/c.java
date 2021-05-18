package d.a.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f39254a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39255b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f39255b) {
                this.f39255b = true;
                this.f39254a = d();
            }
        }
        return this.f39254a;
    }
}
