package d.a.m0.a.f1.d.b;

import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import d.a.m0.n.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Integer> f45620a = new ConcurrentHashMap();

    /* renamed from: d.a.m0.a.f1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0691a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f45621a = new a();
    }

    static {
        boolean z = k.f46983a;
    }

    public static a b() {
        return C0691a.f45621a;
    }

    public void a(String str) {
        this.f45620a.put(str, Integer.valueOf(c(str) + 1));
    }

    public final int c(String str) {
        Integer num = this.f45620a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean d() {
        int i2 = c.b().j().getInt("get_pkg_retry_switch", 0);
        d.g("GetPkgRetryController", "getServerRetrySwitch:" + i2);
        return i2 == 1;
    }

    public String e(String str, String str2) {
        return str + "_" + str2;
    }

    public boolean f(String str) {
        return d() && c(str) < 1;
    }

    public void g(String str) {
        this.f45620a.remove(str);
    }
}
