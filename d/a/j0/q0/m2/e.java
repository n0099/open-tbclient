package d.a.j0.q0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f58052a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58053b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58054c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f58052a = str.substring(0, 1).contains("1");
            this.f58053b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f58054c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f58052a = false;
        this.f58053b = true;
    }

    public boolean a() {
        return this.f58052a;
    }

    public boolean b() {
        return this.f58053b;
    }

    public boolean c() {
        return this.f58054c;
    }

    public void d(boolean z) {
        this.f58052a = z;
    }

    public void e(boolean z) {
        this.f58053b = z;
    }

    public void f(boolean z) {
        this.f58054c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f58052a ? 1 : 0), Integer.valueOf(this.f58053b ? 1 : 0), Integer.valueOf(this.f58054c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f58052a = z;
        this.f58053b = z2;
    }
}
