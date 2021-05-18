package d.a.b.a.a.a.a;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f38520a;

    /* renamed from: b  reason: collision with root package name */
    public int f38521b;

    public i(int i2, String str, Exception exc) {
        this.f38521b = i2;
        this.f38520a = str;
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
        return this.f38521b == 0;
    }
}
