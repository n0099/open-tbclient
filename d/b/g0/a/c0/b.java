package d.b.g0.a.c0;

import android.text.TextUtils;
import d.b.g0.a.a2.g.g;
import d.b.g0.a.r1.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d.b.g0.a.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0619b extends g {

        /* renamed from: d.b.g0.a.c0.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0619b f43594a = new C0619b();
        }

        public static C0619b e() {
            return a.f43594a;
        }

        public C0619b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0619b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        e y = e.y();
        if (y != null) {
            C0619b.e().putBoolean(a(y.B()), z);
        }
    }
}
