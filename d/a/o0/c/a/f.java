package d.a.o0.c.a;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.j2.k;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (a.f49579a) {
                Log.d("BDTLS", "bdtls success");
            }
            d.a.o0.c.a.i.g m = g.l().m();
            if (m == null) {
                if (a.f49579a) {
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
                if (a.f49579a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                d.a.o0.a.j2.p.f fVar = new d.a.o0.a.j2.p.f();
                fVar.f46322b = str;
                fVar.a("dh_group_id", Integer.valueOf(intValue));
                fVar.a("dh_secret", Integer.valueOf(intValue2));
                fVar.a("dh_pub_c", Integer.valueOf(intValue3));
                fVar.a("dh_pub_s", Integer.valueOf(intValue4));
                if (a.f49579a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                k.d(fVar);
            } catch (Exception e2) {
                if (a.f49579a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(d.a.o0.c.a.i.g gVar, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gVar, bdtls$Alert) == null) {
            if (a.f49579a) {
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
                    if (a.f49579a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    d.a.o0.a.j2.p.f fVar = new d.a.o0.a.j2.p.f();
                    fVar.f46322b = "alert";
                    fVar.f46325e = str;
                    fVar.a("dh_group_id", Integer.valueOf(intValue));
                    fVar.a("dh_secret", Integer.valueOf(intValue2));
                    fVar.a("dh_pub_c", Integer.valueOf(intValue3));
                    fVar.a("dh_pub_s", Integer.valueOf(intValue4));
                    fVar.a("alert_msg", str2);
                    if (a.f49579a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    k.d(fVar);
                } catch (Exception e2) {
                    if (a.f49579a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            } else if (a.f49579a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
