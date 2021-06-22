package d.a.m0.a.h2;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f46490a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f46491b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f46492c;

    public f(boolean z, boolean z2) {
        this.f46490a = true;
        this.f46491b = z;
        this.f46492c = z2;
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
        return (this.f46490a && this.f46491b) ? false : true;
    }

    public boolean b() {
        return this.f46490a ? this.f46491b && this.f46492c : this.f46492c;
    }

    public f(boolean z) {
        this.f46490a = false;
        this.f46491b = true;
        this.f46492c = z;
    }
}
