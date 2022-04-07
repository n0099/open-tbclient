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
import com.repackage.k54;
import com.repackage.u54;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z54 extends v44<tm2> implements u54.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sm2 a;
    public tm2 b;

    /* loaded from: classes7.dex */
    public class a implements k54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z54 c;

        public a(z54 z54Var, sm2 sm2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z54Var, sm2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z54Var;
            this.a = sm2Var;
            this.b = str;
        }

        @Override // com.repackage.k54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jx1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.k54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jx1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755161032, "Lcom/repackage/z54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755161032, "Lcom/repackage/z54;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public z54() {
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

    public static z54 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new z54() : (z54) invokeV.objValue;
    }

    @Override // com.repackage.u54.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        sm2 sm2Var;
        tm2 tm2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (sm2Var = this.a) == null || (tm2Var = this.b) == null) {
            return;
        }
        sm2Var.c(tm2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, tm2 tm2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tm2Var, sm2Var, j03Var)) == null) {
            jx1.i("map", "ChooseLocationAction start");
            if (!tm2Var.isValid()) {
                jx1.c("map", "model is invalid");
                return false;
            }
            String str = tm2Var.z;
            if (TextUtils.isEmpty(str)) {
                jx1.c("map", "cb is empty");
                return false;
            }
            this.a = sm2Var;
            this.b = tm2Var;
            k54.b(context, new a(this, sm2Var, str));
            jx1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.v44
    /* renamed from: f */
    public boolean b(Context context, tm2 tm2Var, sm2 sm2Var, j03 j03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, tm2Var, sm2Var, j03Var, jSONObject)) == null) ? e(context, tm2Var, sm2Var, j03Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u54 a3 = u54.a3(null);
            a3.f3(this);
            a3.h3();
        }
    }

    @Override // com.repackage.u54.b
    public void onCancel() {
        tm2 tm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            jx1.i("map", "choose location cancel");
            sm2 sm2Var = this.a;
            if (sm2Var == null || (tm2Var = this.b) == null) {
                return;
            }
            sm2Var.b(tm2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.u54.b
    public void onError() {
        tm2 tm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            jx1.i("map", "choose location fail");
            sm2 sm2Var = this.a;
            if (sm2Var == null || (tm2Var = this.b) == null) {
                return;
            }
            sm2Var.b(tm2Var.z, 1007, "choose location failed");
        }
    }
}
