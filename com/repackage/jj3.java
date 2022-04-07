package com.repackage;

import android.util.Log;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if (ej3.a) {
                Log.d("BDTLS", "bdtls success");
            }
            tj3 m = kj3.l().m();
            if (m == null) {
                if (ej3.a) {
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
                if (ej3.a) {
                    Log.d("BDTLS", "bdtls ubc get data");
                }
                m73 m73Var = new m73();
                m73Var.b = str;
                m73Var.a("dh_group_id", Integer.valueOf(intValue));
                m73Var.a("dh_secret", Integer.valueOf(intValue2));
                m73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                m73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                if (ej3.a) {
                    Log.d("BDTLS", "bdtls ubc create event");
                }
                c73.d(m73Var);
            } catch (Exception e) {
                if (ej3.a) {
                    Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(tj3 tj3Var, Bdtls$Alert bdtls$Alert) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tj3Var, bdtls$Alert) == null) {
            if (ej3.a) {
                Log.d("BDTLS", "bdtls ubc");
            }
            if (tj3Var != null && bdtls$Alert != null) {
                try {
                    String str = bdtls$Alert.getLevel() == 1 ? "warning" : "fatal_error";
                    int intValue = tj3Var.d() != null ? tj3Var.d().intValue() : -1;
                    int intValue2 = tj3Var.f() != null ? tj3Var.f().intValue() : -1;
                    int intValue3 = tj3Var.e() != null ? tj3Var.e().intValue() : -1;
                    int intValue4 = tj3Var.g() != null ? tj3Var.g().intValue() : -1;
                    String str2 = bdtls$Alert.getDescription() != null ? new String(bdtls$Alert.getDescription().toByteArray()) : "";
                    if (ej3.a) {
                        Log.d("BDTLS", "bdtls ubc get data");
                    }
                    m73 m73Var = new m73();
                    m73Var.b = "alert";
                    m73Var.e = str;
                    m73Var.a("dh_group_id", Integer.valueOf(intValue));
                    m73Var.a("dh_secret", Integer.valueOf(intValue2));
                    m73Var.a("dh_pub_c", Integer.valueOf(intValue3));
                    m73Var.a("dh_pub_s", Integer.valueOf(intValue4));
                    m73Var.a("alert_msg", str2);
                    if (ej3.a) {
                        Log.d("BDTLS", "bdtls ubc create event");
                    }
                    c73.d(m73Var);
                } catch (Exception e) {
                    if (ej3.a) {
                        Log.d("BDTLS", "bdtls ubc exception=" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else if (ej3.a) {
                Log.d("BDTLS", "bdtls ubc data is null");
            }
        }
    }
}
