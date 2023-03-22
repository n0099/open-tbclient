package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes8.dex */
public class z0 {
    public static /* synthetic */ Interceptable $ic;
    public static z0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes8.dex */
    public static class a extends a1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.hatool.a1
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.huawei.hms.hatool.a.d(this.a, this.b) : (String) invokeV.objValue;
        }

        @Override // com.huawei.hms.hatool.a1
        public String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? zma.b(str) : (String) invokeL.objValue;
        }

        @Override // com.huawei.hms.hatool.a1
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.huawei.hms.hatool.a.g(this.a, this.b) : (String) invokeV.objValue;
        }

        @Override // com.huawei.hms.hatool.a1
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.huawei.hms.hatool.a.j(this.a, this.b) : (String) invokeV.objValue;
        }

        @Override // com.huawei.hms.hatool.a1
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return (com.huawei.hms.hatool.a.k(this.a, this.b) ? 4 : 0) | 0 | (com.huawei.hms.hatool.a.e(this.a, this.b) ? 2 : 0) | (com.huawei.hms.hatool.a.h(this.a, this.b) ? 1 : 0);
            }
            return invokeV.intValue;
        }
    }

    public z0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static z0 a() {
        InterceptResult invokeV;
        z0 z0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (z0.class) {
                if (b == null) {
                    b = new z0();
                }
                z0Var = b;
            }
            return z0Var;
        }
        return (z0) invokeV.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? g.a(this.a, str, str2) : (String) invokeLL.objValue;
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (z) {
                String e = b.e();
                if (TextUtils.isEmpty(e)) {
                    e = g0.a(this.a, "global_v2", "uuid", "");
                    if (TextUtils.isEmpty(e)) {
                        e = UUID.randomUUID().toString().replace("-", "");
                        g0.b(this.a, "global_v2", "uuid", e);
                    }
                    b.h(e);
                }
                return e;
            }
            return "";
        }
        return (String) invokeZ.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = context;
        }
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? g.b(this.a, str, str2) : (String) invokeLL.objValue;
    }

    public x0 c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? new a(str, str2).a(this.a) : (x0) invokeLL.objValue;
    }

    public String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) ? c1.b(str, str2) : (String) invokeLL.objValue;
    }

    public Pair<String, String> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (com.huawei.hms.hatool.a.f(str, str2)) {
                String p = i.c().b().p();
                String q = i.c().b().q();
                if (TextUtils.isEmpty(p) || TextUtils.isEmpty(q)) {
                    Pair<String, String> e = b1.e(this.a);
                    i.c().b().k((String) e.first);
                    i.c().b().l((String) e.second);
                    return e;
                }
                return new Pair<>(p, q);
            }
            return new Pair<>("", "");
        }
        return (Pair) invokeLL.objValue;
    }

    public String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) ? c1.a(str, str2) : (String) invokeLL.objValue;
    }
}
