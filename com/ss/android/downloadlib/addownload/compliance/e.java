package com.ss.android.downloadlib.addownload.compliance;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.downloadlib.addownload.b.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, str, j) == null) {
            com.ss.android.downloadlib.addownload.b.e e2 = f.a().e(j);
            if (e2.x()) {
                return;
            }
            e2.f69435c.setRefer(str);
            com.ss.android.downloadlib.d.a.a().b("lp_app_dialog_click", e2);
        }
    }

    public static void b(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, str, j) == null) {
            a(str, null, j);
        }
    }

    public static void a(String str, JSONObject jSONObject, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, jSONObject, Long.valueOf(j)}) == null) {
            com.ss.android.downloadlib.d.a.a().b(str, jSONObject, f.a().e(j));
        }
    }

    public static void a(String str, com.ss.android.downloadlib.addownload.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, eVar) == null) {
            com.ss.android.downloadlib.d.a.a().b(str, eVar);
        }
    }

    public static void a(int i2, com.ss.android.downloadlib.addownload.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, eVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("error_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, eVar);
        }
    }

    public static void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("error_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, f.a().e(j));
        }
    }
}
