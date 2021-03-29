package d.b.g0.g.i0.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f48231a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f48232b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f48233c;

    public f(boolean z, boolean z2) {
        this.f48231a = true;
        this.f48232b = z;
        this.f48233c = z2;
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
        return (this.f48231a && this.f48232b) ? false : true;
    }

    public boolean b() {
        return this.f48231a ? this.f48232b && this.f48233c : this.f48233c;
    }

    public f(boolean z) {
        this.f48231a = false;
        this.f48232b = true;
        this.f48233c = z;
    }
}
