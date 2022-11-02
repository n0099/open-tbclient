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
import java.util.Iterator;
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            p.a();
            if (com.vivo.push.e.a.a().c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, this, context, str, i) == null) {
            com.vivo.push.b.n nVar = new com.vivo.push.b.n();
            nVar.b(str);
            nVar.a(i);
            if (i > 0) {
                d("LogController", str);
            }
            if (context.getPackageName().equals("com.vivo.pushservice")) {
                nVar.a(true);
                Iterator<String> it = com.vivo.push.e.a.a().b().iterator();
                while (it.hasNext()) {
                    com.vivo.push.a.a.a(context, nVar, it.next());
                }
                return;
            }
            nVar.a(false);
            com.vivo.push.a.a.a(context, nVar, context.getPackageName());
        }
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.e(concat, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.w(concat, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.d(concat, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th)) == null) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.e(concat, a + str2, th);
        }
        return invokeLLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th)) == null) {
            return Log.e("VivoPush.".concat(String.valueOf(str)), Log.getStackTraceString(th));
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) && a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.o
    public final void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) && a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.o
    public final String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) {
            return Log.getStackTraceString(th);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.vivo.push.util.o
    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) && a()) {
            a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, th)) == null) {
            if (p.a()) {
                String concat = "VivoPush.".concat(String.valueOf(str));
                return Log.i(concat, a + str2, th);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    @Override // com.vivo.push.util.o
    public final int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (p.a()) {
                String concat = "VivoPush.".concat(String.valueOf(str));
                return Log.i(concat, a + str2);
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
                String concat = "VivoPush.".concat(String.valueOf(str));
                return Log.v(concat, a + str2);
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
