package com.repackage;

import android.text.TextUtils;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class da2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fz1 fz1Var, ha2 ha2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, fz1Var, ha2Var) == null) || fz1Var == null || ha2Var == null) {
            return;
        }
        ha2Var.g(fz1Var);
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return "";
            }
            String quote = JSONObject.quote(str3);
            return str + "." + str2 + " = " + quote + ParamableElem.DIVIDE_PARAM;
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(fz1 fz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fz1Var)) == null) ? fz1Var.isWebView() ? ClearCacheUbcController.DOCUMENT : SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME : (String) invokeL.objValue;
    }
}
