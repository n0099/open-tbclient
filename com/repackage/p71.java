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
/* loaded from: classes6.dex */
public class p71 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p71 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755457113, "Lcom/repackage/p71;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755457113, "Lcom/repackage/p71;");
        }
    }

    public p71() {
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

    public static synchronized p71 f() {
        InterceptResult invokeV;
        p71 p71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (p71.class) {
                if (a == null) {
                    synchronized (p71.class) {
                        if (a == null) {
                            a = new p71();
                        }
                    }
                }
                p71Var = a;
            }
            return p71Var;
        }
        return (p71) invokeV.objValue;
    }

    public boolean a(Activity activity, String str, t71 t71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, t71Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            o71.a().c(activity, str, t71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean b(Activity activity, String str, t71 t71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, t71Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            o71.a().e(activity, str, t71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(Activity activity, JSONObject jSONObject, t71 t71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, jSONObject, t71Var)) == null) {
            if (jSONObject == null) {
                return false;
            }
            o71.a().i(activity, jSONObject, t71Var);
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
            o71.a().f(context, jSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean e(Context context, JSONObject jSONObject, t71 t71Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, jSONObject, t71Var)) == null) {
            if (jSONObject == null) {
                return false;
            }
            o71.a().d(context, jSONObject, t71Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
