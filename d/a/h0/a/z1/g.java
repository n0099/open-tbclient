package d.a.h0.a.z1;

import android.text.TextUtils;
import d.a.h0.a.i2.i0;
import d.a.h0.a.k;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static int f45372a;

    static {
        boolean z = k.f43101a;
        f45372a = 0;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String n = i0.n(str);
        if (TextUtils.isEmpty(n)) {
            return str;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("bduss");
        hashSet.add("bduss".toUpperCase());
        String h2 = i0.h(n, hashSet);
        String d2 = i0.d(str);
        return d2 + "?" + h2;
    }

    public static int b() {
        return f45372a;
    }

    public static void c(int i2) {
        f45372a = i2;
    }

    public static <EvenT extends d.a.h0.a.z1.k.e> EvenT d(EvenT event, String str, Object obj) {
        if (event != null && !TextUtils.isEmpty(str)) {
            event.a(str, obj);
        }
        return event;
    }

    public static <EvenT extends d.a.h0.a.z1.k.e> EvenT e(EvenT event) {
        d(event, "isDownloading", Integer.valueOf(d.a.h0.a.r1.d.e().p().n0() ? 1 : 0));
        return event;
    }

    public static <EvenT extends d.a.h0.a.z1.k.e> EvenT f(EvenT event) {
        d(event, "packageState", Integer.valueOf(d.a.h0.a.r1.d.e().p().m0()));
        return event;
    }

    public static <EvenT extends d.a.h0.a.z1.k.e> EvenT g(EvenT event) {
        d(event, "coreState", Integer.valueOf(d.a.h0.a.e0.w.d.k0()));
        return event;
    }
}
