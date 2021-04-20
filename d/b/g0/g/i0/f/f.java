package d.b.g0.g.i0.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f48623a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f48624b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f48625c;

    public f(boolean z, boolean z2) {
        this.f48623a = true;
        this.f48624b = z;
        this.f48625c = z2;
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
        return (this.f48623a && this.f48624b) ? false : true;
    }

    public boolean b() {
        return this.f48623a ? this.f48624b && this.f48625c : this.f48625c;
    }

    public f(boolean z) {
        this.f48623a = false;
        this.f48624b = true;
        this.f48625c = z;
    }
}
