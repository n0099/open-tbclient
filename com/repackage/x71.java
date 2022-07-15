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
public final class x71 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t81 a;
        public final /* synthetic */ JSONObject b;

        public a(t81 t81Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t81Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t81Var;
            this.b = jSONObject;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                t81 t81Var = this.a;
                if (t81Var != null) {
                    t81Var.a(1, str);
                }
                b81.d(this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
        /* renamed from: d */
        public void c(String str) {
            t81 t81Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (t81Var = this.a) == null) {
                return;
            }
            t81Var.a(0, "");
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t81 a;

        public b(t81 t81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t81Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            t81 t81Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) || (t81Var = this.a) == null) {
                return;
            }
            t81Var.a(1, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
        /* renamed from: d */
        public void c(String str) {
            t81 t81Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (t81Var = this.a) == null) {
                return;
            }
            t81Var.a(0, "");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755218785, "Lcom/repackage/x71;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755218785, "Lcom/repackage/x71;");
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

    public static final void c(JSONObject jSONObject, t81 t81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, jSONObject, t81Var) == null) || jSONObject == null) {
            return;
        }
        s71 s71Var = new s71();
        z71.d(s71Var);
        r71 e = z71.e(jSONObject);
        z71.c(s71Var, e.a("bduss"));
        HttpSigner.b(e);
        new w71(false).a(a81.f(), s71Var, e, new a(t81Var, jSONObject));
    }

    public static final void d(JSONArray jSONArray, t81 t81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, t81Var) == null) || jSONArray == null) {
            return;
        }
        s71 s71Var = new s71();
        z71.d(s71Var);
        r71 r71Var = new r71();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        r71Var.d("batchData", jSONArray2);
        HttpSigner.b(r71Var);
        new w71(false).a(a81.a(), s71Var, r71Var, new b(t81Var));
    }
}
