package d.b.i0.p0.l2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f57843a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57844b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57845c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f57843a = str.substring(0, 1).contains("1");
            this.f57844b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f57845c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f57843a = false;
        this.f57844b = true;
    }

    public boolean a() {
        return this.f57843a;
    }

    public boolean b() {
        return this.f57844b;
    }

    public boolean c() {
        return this.f57845c;
    }

    public void d(boolean z) {
        this.f57843a = z;
    }

    public void e(boolean z) {
        this.f57844b = z;
    }

    public void f(boolean z) {
        this.f57845c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f57843a ? 1 : 0), Integer.valueOf(this.f57844b ? 1 : 0), Integer.valueOf(this.f57845c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f57843a = z;
        this.f57844b = z2;
    }
}
