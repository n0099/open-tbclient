package d.b.m0.a;

import com.baidu.ubs.analytics.SampleResult;
import d.b.m0.a.c;
import d.b.m0.a.e.e;
import d.b.m0.a.e.g;
import d.b.m0.a.e.j;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64029a = false;

    public static SampleResult a(String str) {
        if (f64029a) {
            return c.a.f64050a.f(str);
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
        if (f64029a && str != null) {
            j.a(str, str2, str3, map);
        }
    }

    public static void d(String str) {
        if (f64029a) {
            e.a().b(str);
        }
    }

    public static void e(String str) {
        if (f64029a) {
            e.a().c(str);
        }
    }

    public static void f(boolean z) {
        f64029a = z;
    }
}
