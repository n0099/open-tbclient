package d.h.c.a;

import com.google.common.base.JdkPattern;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final l f67096a;

    /* loaded from: classes6.dex */
    public static final class b implements l {
        public b() {
        }

        @Override // d.h.c.a.l
        public e a(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        @Override // d.h.c.a.l
        public boolean b() {
            return true;
        }
    }

    static {
        Logger.getLogger(m.class.getName());
        f67096a = c();
    }

    public static e a(String str) {
        n.p(str);
        return f67096a.a(str);
    }

    public static String b(double d2) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d2));
    }

    public static l c() {
        return new b();
    }

    public static boolean d() {
        return f67096a.b();
    }

    public static boolean e(String str) {
        return str == null || str.isEmpty();
    }

    public static long f() {
        return System.nanoTime();
    }
}
