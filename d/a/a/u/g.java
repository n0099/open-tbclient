package d.a.a.u;
/* loaded from: classes.dex */
public class g {

    /* renamed from: d  reason: collision with root package name */
    public static String f41742d = "\r";

    /* renamed from: a  reason: collision with root package name */
    public final String f41743a;

    /* renamed from: b  reason: collision with root package name */
    public final float f41744b;

    /* renamed from: c  reason: collision with root package name */
    public final float f41745c;

    public g(String str, float f2, float f3) {
        this.f41743a = str;
        this.f41745c = f3;
        this.f41744b = f2;
    }

    public boolean a(String str) {
        if (this.f41743a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f41743a.endsWith(f41742d)) {
            String str2 = this.f41743a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
