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
import com.repackage.e64;
import com.repackage.u54;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j64 extends f54<en2> implements e64.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dn2 a;
    public en2 b;

    /* loaded from: classes6.dex */
    public class a implements u54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dn2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j64 c;

        public a(j64 j64Var, dn2 dn2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j64Var, dn2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j64Var;
            this.a = dn2Var;
            this.b = str;
        }

        @Override // com.repackage.u54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.u54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ux1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755636727, "Lcom/repackage/j64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755636727, "Lcom/repackage/j64;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public j64() {
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

    public static j64 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new j64() : (j64) invokeV.objValue;
    }

    @Override // com.repackage.e64.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        dn2 dn2Var;
        en2 en2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (dn2Var = this.a) == null || (en2Var = this.b) == null) {
            return;
        }
        dn2Var.c(en2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, en2 en2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, en2Var, dn2Var, u03Var)) == null) {
            ux1.i("map", "ChooseLocationAction start");
            if (!en2Var.isValid()) {
                ux1.c("map", "model is invalid");
                return false;
            }
            String str = en2Var.z;
            if (TextUtils.isEmpty(str)) {
                ux1.c("map", "cb is empty");
                return false;
            }
            this.a = dn2Var;
            this.b = en2Var;
            u54.b(context, new a(this, dn2Var, str));
            ux1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f54
    /* renamed from: f */
    public boolean b(Context context, en2 en2Var, dn2 dn2Var, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, en2Var, dn2Var, u03Var, jSONObject)) == null) ? e(context, en2Var, dn2Var, u03Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e64 a3 = e64.a3(null);
            a3.f3(this);
            a3.h3();
        }
    }

    @Override // com.repackage.e64.b
    public void onCancel() {
        en2 en2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ux1.i("map", "choose location cancel");
            dn2 dn2Var = this.a;
            if (dn2Var == null || (en2Var = this.b) == null) {
                return;
            }
            dn2Var.b(en2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.e64.b
    public void onError() {
        en2 en2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ux1.i("map", "choose location fail");
            dn2 dn2Var = this.a;
            if (dn2Var == null || (en2Var = this.b) == null) {
                return;
            }
            dn2Var.b(en2Var.z, 1007, "choose location failed");
        }
    }
}
