package d.b.h0.a.z1;

import android.text.TextUtils;
import d.b.h0.a.i2.i0;
import d.b.h0.a.k;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static int f47936a;

    static {
        boolean z = k.f45772a;
        f47936a = 0;
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
        return f47936a;
    }

    public static void c(int i) {
        f47936a = i;
    }

    public static <EvenT extends d.b.h0.a.z1.k.e> EvenT d(EvenT event, String str, Object obj) {
        if (event != null && !TextUtils.isEmpty(str)) {
            event.a(str, obj);
        }
        return event;
    }

    public static <EvenT extends d.b.h0.a.z1.k.e> EvenT e(EvenT event) {
        d(event, "isDownloading", Integer.valueOf(d.b.h0.a.r1.d.e().s().n0() ? 1 : 0));
        return event;
    }

    public static <EvenT extends d.b.h0.a.z1.k.e> EvenT f(EvenT event) {
        d(event, "packageState", Integer.valueOf(d.b.h0.a.r1.d.e().s().m0()));
        return event;
    }

    public static <EvenT extends d.b.h0.a.z1.k.e> EvenT g(EvenT event) {
        d(event, "coreState", Integer.valueOf(d.b.h0.a.e0.w.d.k0()));
        return event;
    }
}
