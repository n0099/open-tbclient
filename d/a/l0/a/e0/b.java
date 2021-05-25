package d.a.l0.a.e0;

import android.text.TextUtils;
import d.a.l0.a.k2.g.g;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d.a.l0.a.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0597b extends g {

        /* renamed from: d.a.l0.a.e0.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0597b f41349a = new C0597b();
        }

        public static C0597b e() {
            return a.f41349a;
        }

        public C0597b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0597b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 != null) {
            C0597b.e().putBoolean(a(i2.D()), z);
        }
    }
}
