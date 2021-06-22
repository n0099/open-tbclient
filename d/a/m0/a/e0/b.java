package d.a.m0.a.e0;

import android.text.TextUtils;
import d.a.m0.a.k2.g.g;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d.a.m0.a.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0656b extends g {

        /* renamed from: d.a.m0.a.e0.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0656b f45133a = new C0656b();
        }

        public static C0656b e() {
            return a.f45133a;
        }

        public C0656b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0656b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 != null) {
            C0656b.e().putBoolean(a(i2.D()), z);
        }
    }
}
