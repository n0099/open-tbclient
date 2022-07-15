package com.kuaishou.weapon.p0;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;
/* renamed from: com.kuaishou.weapon.p0.ʼᵢ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0342 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int f135;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean f136;
    public transient /* synthetic */ FieldHolder $fh;

    public C0342() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        m294();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private int m293(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, method)) == null) {
            try {
                if (f135 <= 1 || method == null) {
                    return 0;
                }
                return Engine.mmo(method, f135, method.getModifiers());
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m294() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && Engine.loadSuccess && !f136) {
            boolean m290 = C0340.m290();
            int i = Build.VERSION.SDK_INT;
            if (m290 && i < 29 && i > 22) {
                f135 = Engine.off();
            }
            f136 = true;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m295() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? f136 && f135 > 1 : invokeV.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m296() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (m295()) {
                long m288 = C0338.f124.m288();
                long m2882 = C0338.f123.m288();
                if (f135 == m288) {
                    return (int) m2882;
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m297(int i, Class cls, String str, Object... objArr) {
        Method m433;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), cls, str, objArr})) == null) {
            try {
                if (!m295() || (m433 = C0376.m433(cls, str, objArr)) == null) {
                    return 0;
                }
                return Engine.mqc(m433, i);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m298(Class cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, objArr)) == null) {
            try {
                if (m295()) {
                    return m293(C0376.m433(cls, str, objArr));
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLLL.intValue;
    }
}
