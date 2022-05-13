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
/* loaded from: classes7.dex */
public class xb1 extends ub1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, ub1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xb1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(123913036, "Lcom/repackage/xb1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(123913036, "Lcom/repackage/xb1$b;");
                    return;
                }
            }
            a = new xb1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755177462, "Lcom/repackage/xb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755177462, "Lcom/repackage/xb1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public /* synthetic */ xb1(a aVar) {
        this();
    }

    public static xb1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (xb1) invokeV.objValue;
    }

    @Override // com.repackage.ub1
    public boolean b(Context context, wb1 wb1Var, qb1 qb1Var) {
        InterceptResult invokeLLL;
        ub1 ub1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, wb1Var, qb1Var)) == null) {
            String b2 = wb1Var.b();
            if (a.get(b2) != null) {
                wb1Var.f(b2, a.get(b2));
            }
            String d = wb1Var.d(true);
            if (TextUtils.isEmpty(d) || (ub1Var = b.get(d)) == null) {
                return false;
            }
            return ub1Var.b(context, wb1Var, qb1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.repackage.ub1
    public boolean c(Context context, wb1 wb1Var, qb1 qb1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wb1Var, qb1Var)) == null) {
            wb1Var.i = zb1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, ub1 ub1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ub1Var) == null) || TextUtils.isEmpty(str) || ub1Var == null) {
            return;
        }
        b.put(str, ub1Var);
    }

    public void g(ub1 ub1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ub1Var) == null) || ub1Var == null) {
            return;
        }
        ub1Var.a(a);
    }

    public xb1() {
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
