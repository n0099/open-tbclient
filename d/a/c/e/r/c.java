package d.a.c.e.r;
/* loaded from: classes.dex */
public abstract class c implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f38918a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38919b = false;

    public abstract byte[] d();

    public byte[] e() {
        synchronized (this) {
            if (!this.f38919b) {
                this.f38919b = true;
                this.f38918a = d();
            }
        }
        return this.f38918a;
    }
}
