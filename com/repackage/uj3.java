package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (pj3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            ek3 m = vj3.l().m();
            if (m == null) {
                if (pj3.a) {
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
                if (pj3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                x73 x73Var = new x73();
                x73Var.b = str;
                x73Var.a("dh_group_id", Integer.valueOf(intValue));
                x73Var.a("dh_secret", Integer.valueOf(intValue2));
                x73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                x73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (pj3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                n73.d(x73Var);
            } catch (Exception e) {
                if (pj3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(ek3 ek3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ek3Var, bdtls$Alert) == null) {
            if (pj3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (ek3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = ek3Var.d() != null ? ek3Var.d().intValue() : -1;
                    int intValue2 = ek3Var.f() != null ? ek3Var.f().intValue() : -1;
                    int intValue3 = ek3Var.e() != null ? ek3Var.e().intValue() : -1;
                    int intValue4 = ek3Var.g() != null ? ek3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (pj3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    x73 x73Var = new x73();
                    x73Var.b = "alert";
                    x73Var.e = str;
                    x73Var.a("dh_group_id", Integer.valueOf(intValue));
                    x73Var.a("dh_secret", Integer.valueOf(intValue2));
                    x73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    x73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    x73Var.a("alert_msg", str2);
                    if (pj3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    n73.d(x73Var);
                } catch (Exception e) {
                    if (pj3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (pj3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
