package d.b.b.a.a.a.a;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f41927a;

    /* renamed from: b  reason: collision with root package name */
    public int f41928b;

    public i(int i, String str, Exception exc) {
        this.f41928b = i;
        this.f41927a = str;
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
        return this.f41928b == 0;
    }
}
