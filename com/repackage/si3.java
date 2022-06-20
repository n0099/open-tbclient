package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class si3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (ni3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            cj3 m = ti3.l().m();
            if (m == null) {
                if (ni3.a) {
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
                if (ni3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                v63 v63Var = new v63();
                v63Var.b = str;
                v63Var.a("dh_group_id", Integer.valueOf(intValue));
                v63Var.a("dh_secret", Integer.valueOf(intValue2));
                v63Var.a("dh_pub_c", Integer.valueOf(intValue3));
                v63Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (ni3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                l63.d(v63Var);
            } catch (Exception e) {
                if (ni3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(cj3 cj3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cj3Var, bdtls$Alert) == null) {
            if (ni3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (cj3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = cj3Var.d() != null ? cj3Var.d().intValue() : -1;
                    int intValue2 = cj3Var.f() != null ? cj3Var.f().intValue() : -1;
                    int intValue3 = cj3Var.e() != null ? cj3Var.e().intValue() : -1;
                    int intValue4 = cj3Var.g() != null ? cj3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (ni3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    v63 v63Var = new v63();
                    v63Var.b = "alert";
                    v63Var.e = str;
                    v63Var.a("dh_group_id", Integer.valueOf(intValue));
                    v63Var.a("dh_secret", Integer.valueOf(intValue2));
                    v63Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    v63Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    v63Var.a("alert_msg", str2);
                    if (ni3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    l63.d(v63Var);
                } catch (Exception e) {
                    if (ni3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (ni3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
