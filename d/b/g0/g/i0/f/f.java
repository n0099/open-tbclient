package d.b.g0.g.i0.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f48230a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f48231b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f48232c;

    public f(boolean z, boolean z2) {
        this.f48230a = true;
        this.f48231b = z;
        this.f48232c = z2;
    }

    public static f c(boolean z) {
        return new f(z);
    }

    public static f d(boolean z, boolean z2) {
        return new f(z, z2);
    }

    public static f e() {
        return new f(true, true);
    }

    public boolean a() {
        return (this.f48230a && this.f48231b) ? false : true;
    }

    public boolean b() {
        return this.f48230a ? this.f48231b && this.f48232c : this.f48232c;
    }

    public f(boolean z) {
        this.f48230a = false;
        this.f48231b = true;
        this.f48232c = z;
    }
}
