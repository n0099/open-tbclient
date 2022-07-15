package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b71 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b71 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755874187, "Lcom/repackage/b71;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755874187, "Lcom/repackage/b71;");
        }
    }

    public b71() {
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

    public static synchronized b71 f() {
        InterceptResult invokeV;
        b71 b71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b71.class) {
                if (a == null) {
                    synchronized (b71.class) {
                        if (a == null) {
                            a = new b71();
                        }
                    }
                }
                b71Var = a;
            }
            return b71Var;
        }
        return (b71) invokeV.objValue;
    }

    public boolean a(Activity activity, String str, f71 f71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, f71Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            a71.a().c(activity, str, f71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean b(Activity activity, String str, f71 f71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, f71Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            a71.a().e(activity, str, f71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(Activity activity, JSONObject jSONObject, f71 f71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, jSONObject, f71Var)) == null) {
            if (jSONObject == null) {
                return false;
            }
            a71.a().i(activity, jSONObject, f71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean d(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            a71.a().f(context, jSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean e(Context context, JSONObject jSONObject, f71 f71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, jSONObject, f71Var)) == null) {
            if (jSONObject == null) {
                return false;
            }
            a71.a().d(context, jSONObject, f71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
