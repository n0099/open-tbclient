package d.a.n0.r0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f58935a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58936b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58937c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f58935a = str.substring(0, 1).contains("1");
            this.f58936b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f58937c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f58935a = false;
        this.f58936b = true;
    }

    public boolean a() {
        return this.f58935a;
    }

    public boolean b() {
        return this.f58936b;
    }

    public boolean c() {
        return this.f58937c;
    }

    public void d(boolean z) {
        this.f58935a = z;
    }

    public void e(boolean z) {
        this.f58936b = z;
    }

    public void f(boolean z) {
        this.f58937c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f58935a ? 1 : 0), Integer.valueOf(this.f58936b ? 1 : 0), Integer.valueOf(this.f58937c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f58935a = z;
        this.f58936b = z2;
    }
}
