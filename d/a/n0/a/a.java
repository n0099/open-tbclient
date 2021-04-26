package d.a.n0.a;

import com.baidu.ubs.analytics.SampleResult;
import d.a.n0.a.c;
import d.a.n0.a.e.e;
import d.a.n0.a.e.g;
import d.a.n0.a.e.j;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63336a = false;

    public static SampleResult a(String str) {
        if (f63336a) {
            return c.a.f63357a.f(str);
        }
        return SampleResult.OTHERE;
    }

    public static void b(b bVar) {
        if (bVar == null) {
            return;
        }
        g.b(bVar);
    }

    public static void c(String str, String str2, String str3, Map<String, String> map) {
        if (f63336a && str != null) {
            j.a(str, str2, str3, map);
        }
    }

    public static void d(String str) {
        if (f63336a) {
            e.a().b(str);
        }
    }

    public static void e(String str) {
        if (f63336a) {
            e.a().c(str);
        }
    }

    public static void f(boolean z) {
        f63336a = z;
    }
}
