package d.a.h0.g.i0.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f46427a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f46428b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f46429c;

    public f(boolean z, boolean z2) {
        this.f46427a = true;
        this.f46428b = z;
        this.f46429c = z2;
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
        return (this.f46427a && this.f46428b) ? false : true;
    }

    public boolean b() {
        return this.f46427a ? this.f46428b && this.f46429c : this.f46429c;
    }

    public f(boolean z) {
        this.f46427a = false;
        this.f46428b = true;
        this.f46429c = z;
    }
}
