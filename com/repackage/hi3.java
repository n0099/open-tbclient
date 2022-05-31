package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (ci3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            ri3 m = ii3.l().m();
            if (m == null) {
                if (ci3.a) {
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
                if (ci3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                k63 k63Var = new k63();
                k63Var.b = str;
                k63Var.a("dh_group_id", Integer.valueOf(intValue));
                k63Var.a("dh_secret", Integer.valueOf(intValue2));
                k63Var.a("dh_pub_c", Integer.valueOf(intValue3));
                k63Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (ci3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                a63.d(k63Var);
            } catch (Exception e) {
                if (ci3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(ri3 ri3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ri3Var, bdtls$Alert) == null) {
            if (ci3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (ri3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = ri3Var.d() != null ? ri3Var.d().intValue() : -1;
                    int intValue2 = ri3Var.f() != null ? ri3Var.f().intValue() : -1;
                    int intValue3 = ri3Var.e() != null ? ri3Var.e().intValue() : -1;
                    int intValue4 = ri3Var.g() != null ? ri3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (ci3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    k63 k63Var = new k63();
                    k63Var.b = "alert";
                    k63Var.e = str;
                    k63Var.a("dh_group_id", Integer.valueOf(intValue));
                    k63Var.a("dh_secret", Integer.valueOf(intValue2));
                    k63Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    k63Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    k63Var.a("alert_msg", str2);
                    if (ci3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    a63.d(k63Var);
                } catch (Exception e) {
                    if (ci3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (ci3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
