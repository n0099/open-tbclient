package d.b.g0.a.z1;

import androidx.annotation.NonNull;
import com.baidu.swan.ubc.Flow;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static a a(String str) {
        return new a(d.b.g0.n.e.c(str));
    }

    public static void b(@NonNull a aVar) {
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.c();
        }
    }

    public static void c(@NonNull a aVar) {
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.d();
        }
    }

    public static void d(@NonNull a aVar, String str, String str2) {
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.a(str, str2);
        }
    }

    public static void e(@NonNull a aVar, String str, String str2, long j) {
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.b(str, str2, j);
        }
    }

    public static void f(@NonNull a aVar, String str) {
        Flow a2 = aVar.a();
        if (a2 != null) {
            a2.o(str);
        }
    }

    public static void g(String str, String str2) {
        d.b.g0.n.e.h(str, str2);
    }

    public static void h(String str, String str2, JSONObject jSONObject) {
        d.b.g0.n.e.l(str2, jSONObject);
    }

    public static void i(String str, Map<String, String> map) {
        d.b.g0.n.e.j(str, map);
    }

    public static void j(String str, JSONObject jSONObject) {
        d.b.g0.n.e.l(str, jSONObject);
    }
}
