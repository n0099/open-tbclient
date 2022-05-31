package com.repackage;

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
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ka1 extends ha1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, ha1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ka1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249189448, "Lcom/repackage/ka1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-249189448, "Lcom/repackage/ka1$b;");
                    return;
                }
            }
            a = new ka1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755565706, "Lcom/repackage/ka1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755565706, "Lcom/repackage/ka1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public /* synthetic */ ka1(a aVar) {
        this();
    }

    public static ka1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (ka1) invokeV.objValue;
    }

    @Override // com.repackage.ha1
    public boolean b(Context context, ja1 ja1Var, da1 da1Var) {
        InterceptResult invokeLLL;
        ha1 ha1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, ja1Var, da1Var)) == null) {
            String b2 = ja1Var.b();
            if (a.get(b2) != null) {
                ja1Var.f(b2, a.get(b2));
            }
            String d = ja1Var.d(true);
            if (TextUtils.isEmpty(d) || (ha1Var = b.get(d)) == null) {
                return false;
            }
            return ha1Var.b(context, ja1Var, da1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.repackage.ha1
    public boolean c(Context context, ja1 ja1Var, da1 da1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ja1Var, da1Var)) == null) {
            ja1Var.i = ma1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, ha1 ha1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ha1Var) == null) || TextUtils.isEmpty(str) || ha1Var == null) {
            return;
        }
        b.put(str, ha1Var);
    }

    public void g(ha1 ha1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ha1Var) == null) || ha1Var == null) {
            return;
        }
        ha1Var.a(a);
    }

    public ka1() {
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
}
