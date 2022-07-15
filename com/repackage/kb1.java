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
public class kb1 extends hb1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, hb1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kb1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-248265927, "Lcom/repackage/kb1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-248265927, "Lcom/repackage/kb1$b;");
                    return;
                }
            }
            a = new kb1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755564745, "Lcom/repackage/kb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755564745, "Lcom/repackage/kb1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public /* synthetic */ kb1(a aVar) {
        this();
    }

    public static kb1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (kb1) invokeV.objValue;
    }

    @Override // com.repackage.hb1
    public boolean b(Context context, jb1 jb1Var, db1 db1Var) {
        InterceptResult invokeLLL;
        hb1 hb1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, jb1Var, db1Var)) == null) {
            String b2 = jb1Var.b();
            if (a.get(b2) != null) {
                jb1Var.f(b2, a.get(b2));
            }
            String d = jb1Var.d(true);
            if (TextUtils.isEmpty(d) || (hb1Var = b.get(d)) == null) {
                return false;
            }
            return hb1Var.b(context, jb1Var, db1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.repackage.hb1
    public boolean c(Context context, jb1 jb1Var, db1 db1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jb1Var, db1Var)) == null) {
            jb1Var.i = mb1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, hb1 hb1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hb1Var) == null) || TextUtils.isEmpty(str) || hb1Var == null) {
            return;
        }
        b.put(str, hb1Var);
    }

    public void g(hb1 hb1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hb1Var) == null) || hb1Var == null) {
            return;
        }
        hb1Var.a(a);
    }

    public kb1() {
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
