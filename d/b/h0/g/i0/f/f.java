package d.b.h0.g.i0.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f48952a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f48953b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f48954c;

    public f(boolean z, boolean z2) {
        this.f48952a = true;
        this.f48953b = z;
        this.f48954c = z2;
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
        return (this.f48952a && this.f48953b) ? false : true;
    }

    public boolean b() {
        return this.f48952a ? this.f48953b && this.f48954c : this.f48954c;
    }

    public f(boolean z) {
        this.f48952a = false;
        this.f48953b = true;
        this.f48954c = z;
    }
}
