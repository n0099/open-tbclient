package d.a.i0.a.e0;

import android.text.TextUtils;
import d.a.i0.a.k2.g.g;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d.a.i0.a.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0586b extends g {

        /* renamed from: d.a.i0.a.e0.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0586b f41175a = new C0586b();
        }

        public static C0586b e() {
            return a.f41175a;
        }

        public C0586b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0586b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 != null) {
            C0586b.e().putBoolean(a(i2.D()), z);
        }
    }
}
