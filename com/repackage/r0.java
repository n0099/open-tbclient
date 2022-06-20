package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;
    public static w7<String, r0> e;
    public static int f;
    public static final b g;
    public static final d7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final d7 a;
    public final d7 b;
    public final d7 c;
    public final int d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d7 a;
        public d7 b;
        public d7 c;

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
            this.a = r0.h;
            this.b = r0.h;
            this.c = r0.h;
        }

        @SafeVarargs
        public final b a(Class<? extends l0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = m0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public r0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String f = r0.f(this.a, this.b, this.c);
                r0 r0Var = (r0) r0.e.d(f, null);
                if (r0Var == null) {
                    r0 r0Var2 = new r0(this.a, this.b, this.c, null);
                    r0.e.i(f, r0Var2);
                    return r0Var2;
                }
                return r0Var;
            }
            return (r0) invokeV.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends l0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = m0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = r0.h;
                this.b = r0.h;
                this.c = r0.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964030521, "Lcom/repackage/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964030521, "Lcom/repackage/r0;");
                return;
            }
        }
        e = new w7<>();
        f = 0;
        g = new b();
        h = new d7();
    }

    public /* synthetic */ r0(d7 d7Var, d7 d7Var2, d7 d7Var3, a aVar) {
        this(d7Var, d7Var2, d7Var3);
    }

    @SafeVarargs
    public static final b d(Class<? extends l0>... clsArr) {
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

    public static String e(d7 d7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, d7Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = d7Var.h();
            for (int i = 0; i < h2; i++) {
                sb.append(d7Var.e(i) ? "1" : "0");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(d7 d7Var, d7 d7Var2, d7 d7Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, d7Var, d7Var2, d7Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!d7Var.g()) {
                sb.append("{all:");
                sb.append(e(d7Var));
                sb.append("}");
            }
            if (!d7Var2.g()) {
                sb.append("{one:");
                sb.append(e(d7Var2));
                sb.append("}");
            }
            if (!d7Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(d7Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    @SafeVarargs
    public static final b i(Class<? extends l0>... clsArr) {
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

    public boolean h(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o0Var)) == null) {
            d7 e2 = o0Var.e();
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

    public r0(d7 d7Var, d7 d7Var2, d7 d7Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d7Var, d7Var2, d7Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = d7Var;
        this.b = d7Var2;
        this.c = d7Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }
}
