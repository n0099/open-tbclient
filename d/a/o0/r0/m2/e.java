package d.a.o0.r0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62751a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62752b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62753c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f62751a = str.substring(0, 1).contains("1");
            this.f62752b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f62753c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f62751a = false;
        this.f62752b = true;
    }

    public boolean a() {
        return this.f62751a;
    }

    public boolean b() {
        return this.f62752b;
    }

    public boolean c() {
        return this.f62753c;
    }

    public void d(boolean z) {
        this.f62751a = z;
    }

    public void e(boolean z) {
        this.f62752b = z;
    }

    public void f(boolean z) {
        this.f62753c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f62751a ? 1 : 0), Integer.valueOf(this.f62752b ? 1 : 0), Integer.valueOf(this.f62753c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f62751a = z;
        this.f62752b = z2;
    }
}
