package d.b.h0.a.c0;

import android.text.TextUtils;
import d.b.h0.a.a2.g.g;
import d.b.h0.a.r1.e;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d.b.h0.a.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0651b extends g {

        /* renamed from: d.b.h0.a.c0.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0651b f44315a = new C0651b();
        }

        public static C0651b e() {
            return a.f44315a;
        }

        public C0651b() {
            super("searchbox_sconsole_sp");
        }
    }

    public static String a(String str) {
        return "consoleSwitch" + str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && C0651b.e().getBoolean(a(str), false);
    }

    public static void c(boolean z) {
        e y = e.y();
        if (y != null) {
            C0651b.e().putBoolean(a(y.B()), z);
        }
    }
}
