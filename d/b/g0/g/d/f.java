package d.b.g0.g.d;

import android.util.Log;
import com.baidu.swan.games.bdtls.model.Bdtls$Alert;
import d.b.g0.a.z1.h;
import d.b.g0.g.d.g.g;
/* loaded from: classes3.dex */
public class f {
    public static void a(String str) {
        if (a.f48028a) {
            Log.d("BDTLS", "bdtls success");
        }
        g k = e.l().k();
        if (k == null) {
            if (a.f48028a) {
                Log.d("BDTLS", "bdtls ubc data is null");
                return;
            }
            return;
        }
        try {
            int intValue = k.d() != null ? k.d().intValue() : -1;
            int intValue2 = k.f() != null ? k.f().intValue() : -1;
            int intValue3 = k.e() != null ? k.e().intValue() : -1;
            int intValue4 = k.g() != null ? k.g().intValue() : -1;
            if (a.f48028a) {
                Log.d("BDTLS", "bdtls ubc get data");
            }
            d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
            fVar.f47252b = str;
            fVar.a("dh_group_id", Integer.valueOf(intValue));
            fVar.a("dh_secret", Integer.valueOf(intValue2));
            fVar.a("dh_pub_c", Integer.valueOf(intValue3));
            fVar.a("dh_pub_s", Integer.valueOf(intValue4));
            if (a.f48028a) {
                Log.d("BDTLS", "bdtls ubc create event");
            }
            h.f(fVar);
        } catch (Exception e2) {
            if (a.f48028a) {
                Log.d("BDTLS", "bdtls ubc exception=" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public static void b(g gVar, Bdtls$Alert bdtls$Alert) {
        if (a.f48028a) {
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
                if (a.f48028a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
                fVar.f47252b = "alert";
                fVar.f47254d = str;
                fVar.a("dh_group_id", Integer.valueOf(intValue));
                fVar.a("dh_secret", Integer.valueOf(intValue2));
                fVar.a("dh_pub_c", Integer.valueOf(intValue3));
                fVar.a("dh_pub_s", Integer.valueOf(intValue4));
                fVar.a("alert_msg", str2);
                if (a.f48028a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                h.f(fVar);
            } catch (Exception e2) {
                if (a.f48028a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        } else if (a.f48028a) {
            Log.d("BDTLS", "bdtls ubc data is null");
        }
    }
}
