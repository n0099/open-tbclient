package d.a.i0.a.j2;

import android.text.TextUtils;
import d.a.i0.a.v2.o0;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static int f42958a;

    static {
        boolean z = d.a.i0.a.k.f43025a;
        f42958a = 0;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String o = o0.o(str);
        if (TextUtils.isEmpty(o)) {
            return str;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("bduss");
        hashSet.add("bduss".toUpperCase());
        String i2 = o0.i(o, hashSet);
        String f2 = o0.f(str);
        return f2 + "?" + i2;
    }

    public static int b() {
        return f42958a;
    }

    public static void c(int i2) {
        f42958a = i2;
    }

    public static <EvenT extends d.a.i0.a.j2.p.e> EvenT d(EvenT event, String str, Object obj) {
        if (event != null && !TextUtils.isEmpty(str)) {
            event.a(str, obj);
        }
        return event;
    }

    public static <EvenT extends d.a.i0.a.j2.p.e> EvenT e(EvenT event) {
        d(event, "isDownloading", String.valueOf(d.a.i0.a.a2.d.g().r().s0() ? 1 : 0));
        return event;
    }

    public static <EvenT extends d.a.i0.a.j2.p.e> EvenT f(EvenT event) {
        d(event, "launchType", b() == 2 ? "2" : "1");
        return event;
    }

    public static <EvenT extends d.a.i0.a.j2.p.e> EvenT g(EvenT event) {
        d(event, "packageState", String.valueOf(d.a.i0.a.a2.d.g().r().r0()));
        return event;
    }

    public static <EvenT extends d.a.i0.a.j2.p.e> EvenT h(EvenT event) {
        d(event, "coreState", String.valueOf(d.a.i0.a.h0.u.g.r0()));
        return event;
    }
}
