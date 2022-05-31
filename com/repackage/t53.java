package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ek2;
import com.repackage.p53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755339809, "Lcom/repackage/t53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755339809, "Lcom/repackage/t53;");
                return;
            }
        }
        a = rf1.a;
        b = oi2.g0().v() * 1024;
    }

    public static boolean a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? !TextUtils.isEmpty(str) && str.getBytes().length > b : invokeL.booleanValue;
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (c()) {
                boolean a2 = a(str);
                if (a2) {
                    d(str);
                }
                return a2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b > 0 : invokeV.booleanValue;
    }

    public static void d(@NonNull String str) {
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || (a0 = hz2.a0()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ek2.a V = a0.V();
            SwanCoreVersion M = uk2.U().M();
            int l = a0.l();
            jSONObject.putOpt("scheme", V.W());
            jSONObject.putOpt("swanjs", m83.i(M, l));
            if (str != null && str.length() > 1024) {
                jSONObject.putOpt("params", str.substring(0, 1024));
            }
            p53.b bVar = new p53.b(10020);
            bVar.j(bd3.n().e());
            bVar.i(jSONObject.toString());
            bVar.h(a0.getAppId());
            bVar.m();
            hw1.k("SwanAppParamChecker", "10020, params: " + str);
        } catch (JSONException e) {
            if (a) {
                e.printStackTrace();
            }
        }
    }
}
