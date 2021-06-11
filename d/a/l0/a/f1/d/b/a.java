package d.a.l0.a.f1.d.b;

import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.n.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Integer> f45512a = new ConcurrentHashMap();

    /* renamed from: d.a.l0.a.f1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0688a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f45513a = new a();
    }

    static {
        boolean z = k.f46875a;
    }

    public static a b() {
        return C0688a.f45513a;
    }

    public void a(String str) {
        this.f45512a.put(str, Integer.valueOf(c(str) + 1));
    }

    public final int c(String str) {
        Integer num = this.f45512a.get(str);
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
        this.f45512a.remove(str);
    }
}
