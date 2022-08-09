package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (uj3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            jk3 m = ak3.l().m();
            if (m == null) {
                if (uj3.a) {
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
                if (uj3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                c83 c83Var = new c83();
                c83Var.b = str;
                c83Var.a("dh_group_id", Integer.valueOf(intValue));
                c83Var.a("dh_secret", Integer.valueOf(intValue2));
                c83Var.a("dh_pub_c", Integer.valueOf(intValue3));
                c83Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (uj3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                s73.d(c83Var);
            } catch (Exception e) {
                if (uj3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(jk3 jk3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jk3Var, bdtls$Alert) == null) {
            if (uj3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (jk3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = jk3Var.d() != null ? jk3Var.d().intValue() : -1;
                    int intValue2 = jk3Var.f() != null ? jk3Var.f().intValue() : -1;
                    int intValue3 = jk3Var.e() != null ? jk3Var.e().intValue() : -1;
                    int intValue4 = jk3Var.g() != null ? jk3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (uj3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    c83 c83Var = new c83();
                    c83Var.b = "alert";
                    c83Var.e = str;
                    c83Var.a("dh_group_id", Integer.valueOf(intValue));
                    c83Var.a("dh_secret", Integer.valueOf(intValue2));
                    c83Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    c83Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    c83Var.a("alert_msg", str2);
                    if (uj3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    s73.d(c83Var);
                } catch (Exception e) {
                    if (uj3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (uj3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
