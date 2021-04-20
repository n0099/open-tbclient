package d.b.i0.q0.m2;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f59553a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59554b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59555c;

    public e(String str) {
        if (str != null && str.matches("\\d{1}_\\d{1}.*")) {
            this.f59553a = str.substring(0, 1).contains("1");
            this.f59554b = str.substring(2, 3).contains("1");
            if (str.length() >= 5) {
                this.f59555c = str.substring(4, 5).contains("1");
                return;
            }
            return;
        }
        this.f59553a = false;
        this.f59554b = true;
    }

    public boolean a() {
        return this.f59553a;
    }

    public boolean b() {
        return this.f59554b;
    }

    public boolean c() {
        return this.f59555c;
    }

    public void d(boolean z) {
        this.f59553a = z;
    }

    public void e(boolean z) {
        this.f59554b = z;
    }

    public void f(boolean z) {
        this.f59555c = z;
    }

    public String toString() {
        return String.format("%s_%s_%s", Integer.valueOf(this.f59553a ? 1 : 0), Integer.valueOf(this.f59554b ? 1 : 0), Integer.valueOf(this.f59555c ? 1 : 0));
    }

    public e(boolean z, boolean z2) {
        this.f59553a = z;
        this.f59554b = z2;
    }
}
