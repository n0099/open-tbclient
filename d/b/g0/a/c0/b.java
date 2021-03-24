package d.b.g0.a.c0;

import android.text.TextUtils;
import d.b.g0.a.a2.g.g;
import d.b.g0.a.r1.e;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d.b.g0.a.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0618b extends g {

        /* renamed from: d.b.g0.a.c0.b$b$a */
        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0618b f43593a = new C0618b();
        }

        public static C0618b e() {
            return a.f43593a;
        }

        public C0618b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0618b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        e y = e.y();
        if (y != null) {
            C0618b.e().putBoolean(a(y.B()), z);
        }
    }
}
