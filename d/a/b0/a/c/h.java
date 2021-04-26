package d.a.b0.a.c;

import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class h {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    }

    public static boolean a(int i2) {
        d.a.b0.d.a.f fVar = new d.a.b0.d.a.f(d.a.b0.a.b.a.f39288a.get().o());
        if (fVar.b()) {
            return true;
        }
        return fVar.a() && i2 == 0;
    }
}
