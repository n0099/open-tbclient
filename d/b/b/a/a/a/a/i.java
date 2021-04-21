package d.b.b.a.a.a.a;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f42093a;

    /* renamed from: b  reason: collision with root package name */
    public int f42094b;

    public i(int i, String str, Exception exc) {
        this.f42094b = i;
        this.f42093a = str;
    }

    public static i a(int i) {
        return new i(i, null, null);
    }

    public static i b(int i, Exception exc) {
        return new i(i, null, exc);
    }

    public static i c(String str) {
        return new i(0, str, null);
    }

    public boolean d() {
        return this.f42094b == 0;
    }
}
