package d.a.b.a.a.a.a;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f39275a;

    /* renamed from: b  reason: collision with root package name */
    public int f39276b;

    public i(int i2, String str, Exception exc) {
        this.f39276b = i2;
        this.f39275a = str;
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
        return this.f39276b == 0;
    }
}
