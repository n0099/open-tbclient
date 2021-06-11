package d.a.l0.a.h2;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f46382a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f46383b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f46384c;

    public f(boolean z, boolean z2) {
        this.f46382a = true;
        this.f46383b = z;
        this.f46384c = z2;
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
        return (this.f46382a && this.f46383b) ? false : true;
    }

    public boolean b() {
        return this.f46382a ? this.f46383b && this.f46384c : this.f46384c;
    }

    public f(boolean z) {
        this.f46382a = false;
        this.f46383b = true;
        this.f46384c = z;
    }
}
