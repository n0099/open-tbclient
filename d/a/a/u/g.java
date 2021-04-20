package d.a.a.u;
/* loaded from: classes.dex */
public class g {

    /* renamed from: d  reason: collision with root package name */
    public static String f41647d = "\r";

    /* renamed from: a  reason: collision with root package name */
    public final String f41648a;

    /* renamed from: b  reason: collision with root package name */
    public final float f41649b;

    /* renamed from: c  reason: collision with root package name */
    public final float f41650c;

    public g(String str, float f2, float f3) {
        this.f41648a = str;
        this.f41650c = f3;
        this.f41649b = f2;
    }

    public boolean a(String str) {
        if (this.f41648a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f41648a.endsWith(f41647d)) {
            String str2 = this.f41648a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
