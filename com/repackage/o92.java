package com.repackage;

import android.text.TextUtils;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class o92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qy1 qy1Var, s92 s92Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, qy1Var, s92Var) == null) || qy1Var == null || s92Var == null) {
            return;
        }
        s92Var.g(qy1Var);
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

    public static String c(qy1 qy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qy1Var)) == null) ? qy1Var.isWebView() ? ClearCacheUbcController.DOCUMENT : SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME : (String) invokeL.objValue;
    }
}
