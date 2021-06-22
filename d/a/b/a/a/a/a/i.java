package d.a.b.a.a.a.a;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f42031a;

    /* renamed from: b  reason: collision with root package name */
    public int f42032b;

    public i(int i2, String str, Exception exc) {
        this.f42032b = i2;
        this.f42031a = str;
    }

    public static i a(int i2) {
        return new i(i2, null, null);
    }

    public static i b(int i2, Exception exc) {
        return new i(i2, null, exc);
    }

    public static i c(String str) {
        return new i(0, str, null);
    }

    public boolean d() {
        return this.f42032b == 0;
    }
}
