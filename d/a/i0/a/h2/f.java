package d.a.i0.a.h2;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f42532a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f42533b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f42534c;

    public f(boolean z, boolean z2) {
        this.f42532a = true;
        this.f42533b = z;
        this.f42534c = z2;
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
        return (this.f42532a && this.f42533b) ? false : true;
    }

    public boolean b() {
        return this.f42532a ? this.f42533b && this.f42534c : this.f42534c;
    }

    public f(boolean z) {
        this.f42532a = false;
        this.f42533b = true;
        this.f42534c = z;
    }
}
