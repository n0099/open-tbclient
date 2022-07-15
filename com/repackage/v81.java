package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class v81 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public static JSONObject b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755277406, "Lcom/repackage/v81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755277406, "Lcom/repackage/v81;");
                return;
            }
        }
        b = new JSONObject();
    }

    public static final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, str, j) == null) {
            try {
                if (b == null) {
                    b = new JSONObject();
                }
                JSONObject jSONObject = b;
                if (jSONObject != null) {
                    jSONObject.put(str, j);
                }
            } catch (Exception unused) {
                i91.g("add panelShow json error");
            }
        }
    }

    public static final void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("errno", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("errmsg", str3);
                }
            } catch (Exception unused) {
            }
            w81 w81Var = new w81(str);
            w81Var.c(jSONObject);
            z81.e(w81Var);
        }
    }

    public static final void c(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, hashMap) == null) {
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                w81 w81Var = new w81(str);
                w81Var.c(jSONObject);
                z81.e(w81Var);
                return;
            }
            z81.e(new w81(str));
        }
    }

    public static final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || a <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("3", a);
            jSONObject.put("4", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        w81 w81Var = new w81(Constants.DEFAULT_UIN);
        w81Var.c(jSONObject);
        z81.e(w81Var);
        a = 0L;
    }

    public static final void e() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (jSONObject = b) == null) {
            return;
        }
        if ((jSONObject != null ? jSONObject.length() : 0) > 0) {
            a("2", System.currentTimeMillis());
            w81 w81Var = new w81(Constants.DEFAULT_UIN);
            w81Var.c(b);
            z81.e(w81Var);
            b = null;
        }
    }

    public static final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j) == null) {
            a = j;
        }
    }

    public static final void g(int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4}) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exceptionType", i);
            jSONObject.put("payChannel", str2);
            jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, str3);
            jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str4);
            w81 w81Var = new w81(str);
            w81Var.c(jSONObject);
            z81.e(w81Var);
        }
    }

    public static final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 0);
            } catch (Exception unused) {
            }
            w81 w81Var = new w81(str);
            w81Var.c(jSONObject);
            z81.e(w81Var);
        }
    }
}
