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
/* loaded from: classes10.dex */
public final class s implements t {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178697, "Lcom/vivo/push/util/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178697, "Lcom/vivo/push/util/s;");
                return;
            }
        }
        a = "(" + Process.myPid() + SmallTailInfo.EMOTION_SUFFIX;
    }

    public s() {
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
            u.a();
            if (com.vivo.push.g.a.a().b()) {
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
            nVar.g();
            com.vivo.push.a.a.a(context, nVar, context.getPackageName());
        }
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String concat = "VivoPush.Client.".concat(String.valueOf(str));
            return Log.e(concat, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String concat = "VivoPush.Client.".concat(String.valueOf(str));
            return Log.w(concat, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String concat = "VivoPush.Client.".concat(String.valueOf(str));
            return Log.d(concat, a + str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th)) == null) {
            String concat = "VivoPush.Client.".concat(String.valueOf(str));
            return Log.e(concat, a + str2, th);
        }
        return invokeLLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th)) == null) {
            return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) && a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.t
    public final void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) && a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.t
    public final String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, th)) == null) {
            return Log.getStackTraceString(th);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.vivo.push.util.t
    public final void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) && a()) {
            a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.t
    public final int b(String str, String str2, Throwable th) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, th)) == null) {
            if (u.a()) {
                String concat = "VivoPush.Client.".concat(String.valueOf(str));
                return Log.i(concat, a + str2, th);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (u.a()) {
                String concat = "VivoPush.Client.".concat(String.valueOf(str));
                return Log.i(concat, a + str2);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // com.vivo.push.util.t
    public final int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (u.a()) {
                String concat = "VivoPush.Client.".concat(String.valueOf(str));
                return Log.v(concat, a + str2);
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
