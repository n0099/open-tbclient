package com.ss.android.downloadlib.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.j p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, str, str2, jSONObject) == null) || (p = com.ss.android.downloadlib.addownload.j.p()) == null) {
            return;
        }
        p.a(2, str, str2, jSONObject);
    }

    public static void b(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.j p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, jSONObject) == null) || (p = com.ss.android.downloadlib.addownload.j.p()) == null) {
            return;
        }
        p.a(3, str, str2, jSONObject);
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.j p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, jSONObject) == null) || (p = com.ss.android.downloadlib.addownload.j.p()) == null) {
            return;
        }
        p.a(6, str, str2, jSONObject);
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            c(str, str2, null);
        }
    }
}
