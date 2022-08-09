package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j64;
import com.repackage.z54;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o64 extends k54<jn2> implements j64.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public in2 a;
    public jn2 b;

    /* loaded from: classes6.dex */
    public class a implements z54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ in2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o64 c;

        public a(o64 o64Var, in2 in2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o64Var, in2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o64Var;
            this.a = in2Var;
            this.b = str;
        }

        @Override // com.repackage.z54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zx1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.z54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zx1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755487772, "Lcom/repackage/o64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755487772, "Lcom/repackage/o64;");
                return;
            }
        }
        boolean z = jh1.a;
    }

    public o64() {
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

    public static o64 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new o64() : (o64) invokeV.objValue;
    }

    @Override // com.repackage.j64.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        in2 in2Var;
        jn2 jn2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (in2Var = this.a) == null || (jn2Var = this.b) == null) {
            return;
        }
        in2Var.c(jn2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, jn2 jn2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jn2Var, in2Var, z03Var)) == null) {
            zx1.i("map", "ChooseLocationAction start");
            if (!jn2Var.isValid()) {
                zx1.c("map", "model is invalid");
                return false;
            }
            String str = jn2Var.z;
            if (TextUtils.isEmpty(str)) {
                zx1.c("map", "cb is empty");
                return false;
            }
            this.a = in2Var;
            this.b = jn2Var;
            z54.b(context, new a(this, in2Var, str));
            zx1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.k54
    /* renamed from: f */
    public boolean b(Context context, jn2 jn2Var, in2 in2Var, z03 z03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, jn2Var, in2Var, z03Var, jSONObject)) == null) ? e(context, jn2Var, in2Var, z03Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j64 b3 = j64.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.repackage.j64.b
    public void onCancel() {
        jn2 jn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            zx1.i("map", "choose location cancel");
            in2 in2Var = this.a;
            if (in2Var == null || (jn2Var = this.b) == null) {
                return;
            }
            in2Var.b(jn2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.j64.b
    public void onError() {
        jn2 jn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            zx1.i("map", "choose location fail");
            in2 in2Var = this.a;
            if (in2Var == null || (jn2Var = this.b) == null) {
                return;
            }
            in2Var.b(jn2Var.z, 1007, "choose location failed");
        }
    }
}
