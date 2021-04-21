package d.b.j0.q0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f59974a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59975b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59976c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f59974a = str.substring(0, 1).contains("1");
            this.f59975b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f59976c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f59974a = false;
        this.f59975b = true;
    }

    public boolean a() {
        return this.f59974a;
    }

    public boolean b() {
        return this.f59975b;
    }

    public boolean c() {
        return this.f59976c;
    }

    public void d(boolean z) {
        this.f59974a = z;
    }

    public void e(boolean z) {
        this.f59975b = z;
    }

    public void f(boolean z) {
        this.f59976c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f59974a ? 1 : 0), Integer.valueOf(this.f59975b ? 1 : 0), Integer.valueOf(this.f59976c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f59974a = z;
        this.f59975b = z2;
    }
}
