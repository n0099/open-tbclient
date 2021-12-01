package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class n implements o {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178542, "Lcom/vivo/push/util/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178542, "Lcom/vivo/push/util/n;");
                return;
            }
        }
        a = "(" + Process.myPid() + SmallTailInfo.EMOTION_SUFFIX;
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return Log.e("VivoPush." + str, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            return Log.w("VivoPush." + str, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            return Log.d("VivoPush." + str, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (p.a()) {
                return Log.i("VivoPush." + str, a + str2);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (p.a()) {
                return Log.v("VivoPush." + str, a + str2);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th)) == null) {
            return Log.e("VivoPush." + str, Log.getStackTraceString(th));
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, th)) == null) {
            if (p.a()) {
                return Log.i("VivoPush." + str, a + str2, th);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) && p.a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.o
    public final void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) && p.a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th)) == null) {
            return Log.e("VivoPush." + str, a + str2, th);
        }
        return invokeLLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) ? Log.getStackTraceString(th) : (String) invokeL.objValue;
    }

    @Override // com.vivo.push.util.o
    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) && p.a()) {
            a(context, str, 0);
        }
    }

    private void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, str, i2) == null) {
            com.vivo.push.b.p pVar = new com.vivo.push.b.p();
            pVar.b(str);
            pVar.a(i2);
            if (i2 > 0) {
                d("LogController", str);
            }
            if (z.a(context)) {
                pVar.a(true);
                for (String str2 : s.c(context)) {
                    a(context, pVar, str2);
                }
                return;
            }
            pVar.a(false);
            a(context, pVar, context.getPackageName());
        }
    }

    public static void a(Context context, com.vivo.push.b.p pVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, pVar, str) == null) {
            if (str.contains(com.baidu.fsg.base.a.f34139g) || str.equals(s.b(context))) {
                com.vivo.push.a.a.a(context, pVar, str);
            }
        }
    }
}
