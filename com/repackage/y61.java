package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class y61 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u71 a;
        public final /* synthetic */ JSONObject b;

        public a(u71 u71Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u71Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u71Var;
            this.b = jSONObject;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                u71 u71Var = this.a;
                if (u71Var != null) {
                    u71Var.a(1, str);
                }
                c71.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            u71 u71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (u71Var = this.a) == null) {
                return;
            }
            u71Var.a(0, "");
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u71 a;

        public b(u71 u71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u71Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            u71 u71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) || (u71Var = this.a) == null) {
                return;
            }
            u71Var.a(1, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            u71 u71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (u71Var = this.a) == null) {
                return;
            }
            u71Var.a(0, "");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755189955, "Lcom/repackage/y61;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755189955, "Lcom/repackage/y61;");
        }
    }

    public static final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : invokeV.intValue;
    }

    public static final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            a = i;
        }
    }

    public static final void c(JSONObject jSONObject, u71 u71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, jSONObject, u71Var) == null) || jSONObject == null) {
            return;
        }
        t61 t61Var = new t61();
        a71.d(t61Var);
        s61 e = a71.e(jSONObject);
        a71.c(t61Var, e.a("bduss"));
        HttpSigner.b(e);
        new x61(false).a(b71.f(), t61Var, e, new a(u71Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, u71 u71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, u71Var) == null) || jSONArray == null) {
            return;
        }
        t61 t61Var = new t61();
        a71.d(t61Var);
        s61 s61Var = new s61();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        s61Var.d("batchData", jSONArray2);
        HttpSigner.b(s61Var);
        new x61(false).a(b71.a(), t61Var, s61Var, new b(u71Var));
    }
}
