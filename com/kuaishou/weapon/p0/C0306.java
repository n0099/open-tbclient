package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻי  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0306 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f48 = "android.permission.READ_EXTERNAL_STORAGE";
    public transient /* synthetic */ FieldHolder $fh;

    public C0306() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m179(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null || str == null) {
                return -1;
            }
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return invokeLL.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m180(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, strArr)) == null) {
            if (strArr != null) {
                try {
                    for (String str : strArr) {
                        if (m179(context, str) != 0) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
