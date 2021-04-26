package d.a.h0.a.c0;

import android.text.TextUtils;
import d.a.h0.a.a2.g.g;
import d.a.h0.a.r1.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d.a.h0.a.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0590b extends g {

        /* renamed from: d.a.h0.a.c0.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0590b f41599a = new C0590b();
        }

        public static C0590b e() {
            return a.f41599a;
        }

        public C0590b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0590b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        e h2 = e.h();
        if (h2 != null) {
            C0590b.e().putBoolean(a(h2.B()), z);
        }
    }
}
