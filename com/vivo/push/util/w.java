package com.vivo.push.util;

import android.os.Build;
import android.os.UserHandle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(744178821, "Lcom/vivo/push/util/w;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(744178821, "Lcom/vivo/push/util/w;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT < 17) {
                return 0;
            }
            int i = a;
            if (i != -1) {
                return i;
            }
            try {
                Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
                declaredMethod.setAccessible(true);
                a = ((Integer) declaredMethod.invoke(null, null)).intValue();
                u.d("MultiUserManager", "getMyUserId = " + a);
                return a;
            } catch (Exception e) {
                u.a("MultiUserManager", "getMyUserId error " + e.getMessage());
                return 0;
            }
        }
        return invokeV.intValue;
    }
}
