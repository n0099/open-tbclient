package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ij3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (dj3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            sj3 m = jj3.l().m();
            if (m == null) {
                if (dj3.a) {
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
                if (dj3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                l73 l73Var = new l73();
                l73Var.b = str;
                l73Var.a("dh_group_id", Integer.valueOf(intValue));
                l73Var.a("dh_secret", Integer.valueOf(intValue2));
                l73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                l73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (dj3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                b73.d(l73Var);
            } catch (Exception e) {
                if (dj3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(sj3 sj3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, sj3Var, bdtls$Alert) == null) {
            if (dj3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (sj3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = sj3Var.d() != null ? sj3Var.d().intValue() : -1;
                    int intValue2 = sj3Var.f() != null ? sj3Var.f().intValue() : -1;
                    int intValue3 = sj3Var.e() != null ? sj3Var.e().intValue() : -1;
                    int intValue4 = sj3Var.g() != null ? sj3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (dj3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    l73 l73Var = new l73();
                    l73Var.b = "alert";
                    l73Var.e = str;
                    l73Var.a("dh_group_id", Integer.valueOf(intValue));
                    l73Var.a("dh_secret", Integer.valueOf(intValue2));
                    l73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    l73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    l73Var.a("alert_msg", str2);
                    if (dj3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    b73.d(l73Var);
                } catch (Exception e) {
                    if (dj3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (dj3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
