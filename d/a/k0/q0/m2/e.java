package d.a.k0.q0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f58794a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58795b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58796c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f58794a = str.substring(0, 1).contains("1");
            this.f58795b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f58796c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f58794a = false;
        this.f58795b = true;
    }

    public boolean a() {
        return this.f58794a;
    }

    public boolean b() {
        return this.f58795b;
    }

    public boolean c() {
        return this.f58796c;
    }

    public void d(boolean z) {
        this.f58794a = z;
    }

    public void e(boolean z) {
        this.f58795b = z;
    }

    public void f(boolean z) {
        this.f58796c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f58794a ? 1 : 0), Integer.valueOf(this.f58795b ? 1 : 0), Integer.valueOf(this.f58796c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f58794a = z;
        this.f58795b = z2;
    }
}
