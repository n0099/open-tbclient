package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (cj3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            rj3 m = ij3.l().m();
            if (m == null) {
                if (cj3.a) {
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
                if (cj3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                k73 k73Var = new k73();
                k73Var.b = str;
                k73Var.a("dh_group_id", Integer.valueOf(intValue));
                k73Var.a("dh_secret", Integer.valueOf(intValue2));
                k73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                k73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (cj3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                a73.d(k73Var);
            } catch (Exception e) {
                if (cj3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(rj3 rj3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, rj3Var, bdtls$Alert) == null) {
            if (cj3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (rj3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = rj3Var.d() != null ? rj3Var.d().intValue() : -1;
                    int intValue2 = rj3Var.f() != null ? rj3Var.f().intValue() : -1;
                    int intValue3 = rj3Var.e() != null ? rj3Var.e().intValue() : -1;
                    int intValue4 = rj3Var.g() != null ? rj3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (cj3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    k73 k73Var = new k73();
                    k73Var.b = "alert";
                    k73Var.e = str;
                    k73Var.a("dh_group_id", Integer.valueOf(intValue));
                    k73Var.a("dh_secret", Integer.valueOf(intValue2));
                    k73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    k73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    k73Var.a("alert_msg", str2);
                    if (cj3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    a73.d(k73Var);
                } catch (Exception e) {
                    if (cj3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (cj3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
