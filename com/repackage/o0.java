package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public static u7<String, o0> e;
    public static int f;
    public static final b g;
    public static final b7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final b7 a;
    public final b7 b;
    public final b7 c;
    public final int d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b7 a;
        public b7 b;
        public b7 c;

        public b() {
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
            this.a = o0.h;
            this.b = o0.h;
            this.c = o0.h;
        }

        @SafeVarargs
        public final b a(Class<? extends i0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = j0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public o0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String f = o0.f(this.a, this.b, this.c);
                o0 o0Var = (o0) o0.e.d(f, null);
                if (o0Var == null) {
                    o0 o0Var2 = new o0(this.a, this.b, this.c, null);
                    o0.e.i(f, o0Var2);
                    return o0Var2;
                }
                return o0Var;
            }
            return (o0) invokeV.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends i0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = j0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = o0.h;
                this.b = o0.h;
                this.c = o0.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964033404, "Lcom/repackage/o0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964033404, "Lcom/repackage/o0;");
                return;
            }
        }
        e = new u7<>();
        f = 0;
        g = new b();
        h = new b7();
    }

    public /* synthetic */ o0(b7 b7Var, b7 b7Var2, b7 b7Var3, a aVar) {
        this(b7Var, b7Var2, b7Var3);
    }

    @SafeVarargs
    public static final b d(Class<? extends i0>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, clsArr)) == null) {
            b bVar = g;
            bVar.d();
            bVar.a(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static String e(b7 b7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, b7Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = b7Var.h();
            for (int i = 0; i < h2; i++) {
                sb.append(b7Var.e(i) ? "1" : "0");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(b7 b7Var, b7 b7Var2, b7 b7Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, b7Var, b7Var2, b7Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!b7Var.g()) {
                sb.append("{all:");
                sb.append(e(b7Var));
                sb.append("}");
            }
            if (!b7Var2.g()) {
                sb.append("{one:");
                sb.append(e(b7Var2));
                sb.append("}");
            }
            if (!b7Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(b7Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    @SafeVarargs
    public static final b i(Class<? extends i0>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, clsArr)) == null) {
            b bVar = g;
            bVar.d();
            bVar.c(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this == obj : invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean h(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l0Var)) == null) {
            b7 e2 = l0Var.e();
            if (e2.d(this.a)) {
                if (this.b.g() || this.b.f(e2)) {
                    return this.c.g() || !this.c.f(e2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.intValue;
    }

    public o0(b7 b7Var, b7 b7Var2, b7 b7Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b7Var, b7Var2, b7Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = b7Var;
        this.b = b7Var2;
        this.c = b7Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }
}
