package d.o.a.d.f.f;

import d.o.a.d.f.c;
import d.o.a.d.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static void a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        j.c.a().t("lp_compliance_error", jSONObject, c.g.e().v(j));
    }

    public static void b(int i, c.f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        j.c.a().t("lp_compliance_error", jSONObject, fVar);
    }

    public static void c(String str, long j) {
        c.f v = c.g.e().v(j);
        if (v.w()) {
            return;
        }
        v.f66545c.a(str);
        j.c.a().n("lp_app_dialog_click", v);
    }

    public static void d(String str, c.f fVar) {
        j.c.a().n(str, fVar);
    }

    public static void e(String str, JSONObject jSONObject, long j) {
        j.c.a().t(str, jSONObject, c.g.e().v(j));
    }

    public static void f(String str, long j) {
        e(str, null, j);
    }
}
