package d.a.i0.a.j2;

import androidx.annotation.NonNull;
import com.baidu.swan.ubc.Flow;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static a a(String str) {
        return new a(g() ? d.a.i0.a.c1.a.q0().beginFlow(str) : null, d.a.i0.r.e.d(str));
    }

    public static void b(@NonNull a aVar) {
        if (g()) {
            d.a.i0.a.c1.a.q0().b(aVar.b());
        }
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.c();
        }
    }

    public static void c(@NonNull a aVar) {
        if (g()) {
            d.a.i0.a.c1.a.q0().c(aVar.b());
        }
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.d();
        }
    }

    public static void d(@NonNull a aVar, String str, String str2) {
        if (g()) {
            d.a.i0.a.c1.a.q0().a(aVar.b(), str, str2);
        }
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.a(str, str2);
        }
    }

    public static void e(@NonNull a aVar, String str, String str2, long j) {
        if (g()) {
            d.a.i0.a.c1.a.q0().g(aVar.b(), str, str2, j);
        }
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.b(str, str2, j);
        }
    }

    public static void f(@NonNull a aVar, String str) {
        if (g()) {
            d.a.i0.a.c1.a.q0().h(aVar.b(), str);
        }
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.o(str);
        }
    }

    public static boolean g() {
        return d.a.i0.a.c1.a.q0().e();
    }

    public static void h(String str, String str2) {
        if (g()) {
            d.a.i0.a.c1.a.q0().i(str, str2);
        }
        d.a.i0.r.e.i(str, str2);
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        if (g()) {
            d.a.i0.a.c1.a.q0().f(str, jSONObject);
        }
        d.a.i0.r.e.m(str2, jSONObject);
    }

    public static void j(String str, Map<String, String> map) {
        if (g()) {
            d.a.i0.a.c1.a.q0().d(str, map);
        }
        d.a.i0.r.e.k(str, map);
    }

    public static void k(String str, JSONObject jSONObject) {
        if (g()) {
            d.a.i0.a.c1.a.q0().f(str, jSONObject);
        }
        d.a.i0.r.e.m(str, jSONObject);
    }

    public static void l(String str, String str2) {
        d.a.i0.a.c1.a.q0().i(str, str2);
    }

    public static void m(String str, JSONObject jSONObject) {
        d.a.i0.a.c1.a.q0().f(str, jSONObject);
    }
}
