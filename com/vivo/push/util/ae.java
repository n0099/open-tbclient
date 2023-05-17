package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class ae implements e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "SpCache";
    public static String b = "com.vivo.push.cache";
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1594687190, "Lcom/vivo/push/util/ae;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1594687190, "Lcom/vivo/push/util/ae;");
        }
    }

    public ae() {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SharedPreferences.Editor edit = this.c.edit();
            if (edit != null) {
                edit.clear();
                c.a(edit);
            }
            u.d(a, "system cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String string = this.c.getString(str, str2);
            String str3 = a;
            u.d(str3, "getString " + str + " is " + string);
            return string;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            SharedPreferences.Editor edit = this.c.edit();
            if (edit != null) {
                edit.putString(str, str2);
                c.a(edit);
                u.d(a, "putString by ".concat(String.valueOf(str)));
                return;
            }
            u.b(a, "putString error by ".concat(String.valueOf(str)));
        }
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.c == null) {
                this.c = context.getSharedPreferences(b, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
