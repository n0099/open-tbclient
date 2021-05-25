package d.a.l0.a.h2;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f42706a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f42707b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f42708c;

    public f(boolean z, boolean z2) {
        this.f42706a = true;
        this.f42707b = z;
        this.f42708c = z2;
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
        return (this.f42706a && this.f42707b) ? false : true;
    }

    public boolean b() {
        return this.f42706a ? this.f42707b && this.f42708c : this.f42708c;
    }

    public f(boolean z) {
        this.f42706a = false;
        this.f42707b = true;
        this.f42708c = z;
    }
}
