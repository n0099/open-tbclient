package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yb1 {
    public static /* synthetic */ Interceptable $ic;
    public static vb1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, sb1.b());
                jSONObject.put("stack_trace", Log.getStackTraceString(exc));
                jSONObject.put("process_info", sb1.a());
                jSONObject.put("report_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(Exception exc) {
        vb1 vb1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, exc) == null) || (vb1Var = a) == null) {
            return;
        }
        vb1Var.a(a(exc).toString());
    }

    public static void c(String str) {
        vb1 vb1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || (vb1Var = a) == null) {
            return;
        }
        vb1Var.a(str);
    }
}
