package d.a.n0.r0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62626a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62627b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62628c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f62626a = str.substring(0, 1).contains("1");
            this.f62627b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f62628c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f62626a = false;
        this.f62627b = true;
    }

    public boolean a() {
        return this.f62626a;
    }

    public boolean b() {
        return this.f62627b;
    }

    public boolean c() {
        return this.f62628c;
    }

    public void d(boolean z) {
        this.f62626a = z;
    }

    public void e(boolean z) {
        this.f62627b = z;
    }

    public void f(boolean z) {
        this.f62628c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f62626a ? 1 : 0), Integer.valueOf(this.f62627b ? 1 : 0), Integer.valueOf(this.f62628c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f62626a = z;
        this.f62627b = z2;
    }
}
