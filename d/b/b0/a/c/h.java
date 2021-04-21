package d.b.b0.a.c;

import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class h {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    }

    public static boolean a(int i) {
        d.b.b0.d.a.f fVar = new d.b.b0.d.a.f(d.b.b0.a.b.a.f42106a.get().y());
        if (fVar.b()) {
            return true;
        }
        return fVar.a() && i == 0;
    }
}
