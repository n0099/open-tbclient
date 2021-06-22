package d.a.m0.c.a;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import d.a.m0.a.j2.k;
/* loaded from: classes3.dex */
public class f {
    public static void a(String str) {
        if (a.f50231a) {
            Log.d("BDTLS", "bdtls success");
        }
        d.a.m0.c.a.i.g m = g.l().m();
        if (m == null) {
            if (a.f50231a) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = m.d() != null ? m.d().intValue() : -1;
            int intValue2 = m.f() != null ? m.f().intValue() : -1;
            int intValue3 = m.e() != null ? m.e().intValue() : -1;
            int intValue4 = m.g() != null ? m.g().intValue() : -1;
            if (a.f50231a) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
            fVar.f46970b = str;
            fVar.a("dh_group_id", Integer.valueOf(intValue));
            fVar.a("dh_secret", Integer.valueOf(intValue2));
            fVar.a("dh_pub_c", Integer.valueOf(intValue3));
            fVar.a("dh_pub_s", Integer.valueOf(intValue4));
            if (a.f50231a) {
                Log.d("BDTLS", "bdtls ubc create event");
            }
            k.d(fVar);
        } catch (Exception e2) {
            if (a.f50231a) {
                Log.d("BDTLS", "bdtls ubc exception=" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public static void b(d.a.m0.c.a.i.g gVar, Bdtls$Alert bdtls$Alert) {
        if (a.f50231a) {
            Log.d("BDTLS", "bdtls ubc");
        }
        if (gVar != null && bdtls$Alert != null) {
            try {
                String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                int intValue = gVar.d() != null ? gVar.d().intValue() : -1;
                int intValue2 = gVar.f() != null ? gVar.f().intValue() : -1;
                int intValue3 = gVar.e() != null ? gVar.e().intValue() : -1;
                int intValue4 = gVar.g() != null ? gVar.g().intValue() : -1;
                String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                if (a.f50231a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
                fVar.f46970b = "alert";
                fVar.f46973e = str;
                fVar.a("dh_group_id", Integer.valueOf(intValue));
                fVar.a("dh_secret", Integer.valueOf(intValue2));
                fVar.a("dh_pub_c", Integer.valueOf(intValue3));
                fVar.a("dh_pub_s", Integer.valueOf(intValue4));
                fVar.a("alert_msg", str2);
                if (a.f50231a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                k.d(fVar);
            } catch (Exception e2) {
                if (a.f50231a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        } else if (a.f50231a) {
            Log.d("BDTLS", "bdtls ubc data is null");
        }
    }
}
