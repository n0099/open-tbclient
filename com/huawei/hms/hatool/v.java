package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static e1 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            e1 e1Var = new e1();
            e1Var.a(z0.a().a(str, str2));
            return e1Var;
        }
        return (e1) invokeLL.objValue;
    }

    public static f1 a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, str3, str4)) == null) {
            f1 f1Var = new f1();
            f1Var.a(str);
            f1Var.b(b.f());
            f1Var.e(str2);
            f1Var.c(str4);
            StringBuffer stringBuffer = new StringBuffer("hmshi");
            stringBuffer.append(str3);
            stringBuffer.append("qrt");
            f1Var.d(stringBuffer.toString());
            return f1Var;
        }
        return (f1) invokeLLLL.objValue;
    }

    public static g1 a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            g1 g1Var = new g1();
            g1Var.c(b.j());
            g1Var.e(b.l());
            g1Var.a(str3);
            g1Var.b(z0.a().b(str2, str));
            return g1Var;
        }
        return (g1) invokeLLL.objValue;
    }

    public static r b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            y.c("hmsSdk", "generate UploadData EventModelHandlerBase");
            x.d().a(str, str2);
            if (TextUtils.isEmpty(x.d().a())) {
                y.f("hmsSdk", "event chifer is empty");
                return null;
            }
            return new r(x.d().c());
        }
        return (r) invokeLL.objValue;
    }

    public static Map<String, String> c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("App-Id", b.f());
            hashMap.put("App-Ver", b.g());
            hashMap.put("Sdk-Name", "hianalytics");
            hashMap.put("Sdk-Ver", "2.2.0.313");
            hashMap.put("Device-Type", Build.MODEL);
            hashMap.put("servicetag", str);
            y.a("hmsSdk", "sendData RequestId : %s", str2);
            hashMap.put("Request-Id", str2);
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }
}
