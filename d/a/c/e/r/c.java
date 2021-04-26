package d.a.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f40009a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f40010b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f40010b) {
                this.f40010b = true;
                this.f40009a = d();
            }
        }
        return this.f40009a;
    }
}
