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
/* loaded from: classes6.dex */
public final class l81 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h91 a;
        public final /* synthetic */ JSONObject b;

        public a(h91 h91Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h91Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h91Var;
            this.b = jSONObject;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                h91 h91Var = this.a;
                if (h91Var != null) {
                    h91Var.a(1, str);
                }
                p81.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
        /* renamed from: d */
        public void c(String str) {
            h91 h91Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (h91Var = this.a) == null) {
                return;
            }
            h91Var.a(0, "");
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h91 a;

        public b(h91 h91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h91Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            h91 h91Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) || (h91Var = this.a) == null) {
                return;
            }
            h91Var.a(1, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
        /* renamed from: d */
        public void c(String str) {
            h91 h91Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (h91Var = this.a) == null) {
                return;
            }
            h91Var.a(0, "");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755575316, "Lcom/repackage/l81;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755575316, "Lcom/repackage/l81;");
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

    public static final void c(JSONObject jSONObject, h91 h91Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, jSONObject, h91Var) == null) || jSONObject == null) {
            return;
        }
        g81 g81Var = new g81();
        n81.d(g81Var);
        f81 e = n81.e(jSONObject);
        n81.c(g81Var, e.a("bduss"));
        HttpSigner.b(e);
        new k81(false).a(o81.f(), g81Var, e, new a(h91Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, h91 h91Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, h91Var) == null) || jSONArray == null) {
            return;
        }
        g81 g81Var = new g81();
        n81.d(g81Var);
        f81 f81Var = new f81();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        f81Var.d("batchData", jSONArray2);
        HttpSigner.b(f81Var);
        new k81(false).a(o81.a(), g81Var, f81Var, new b(h91Var));
    }
}
