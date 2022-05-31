package com.repackage;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wv3;
import java.io.File;
/* loaded from: classes5.dex */
public class e24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755789526, "Lcom/repackage/e24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755789526, "Lcom/repackage/e24;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public static PathType a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PathType.ERROR;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return PathType.RELATIVE;
            }
            return PathType.NETWORK;
        }
        return (PathType) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        File h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            hz2 r = gz2.J().r();
            if (r.H() && r.j0() != null && (h = wv3.d.h(r.getAppId(), r.j0())) != null && h.exists()) {
                return "file://" + h.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}
