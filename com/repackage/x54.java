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
import com.repackage.i54;
import com.repackage.s54;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x54 extends t44<sm2> implements s54.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rm2 a;
    public sm2 b;

    /* loaded from: classes7.dex */
    public class a implements i54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ x54 c;

        public a(x54 x54Var, rm2 rm2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x54Var, rm2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x54Var;
            this.a = rm2Var;
            this.b = str;
        }

        @Override // com.repackage.i54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ix1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.i54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ix1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755220614, "Lcom/repackage/x54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755220614, "Lcom/repackage/x54;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    public x54() {
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

    public static x54 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new x54() : (x54) invokeV.objValue;
    }

    @Override // com.repackage.s54.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        rm2 rm2Var;
        sm2 sm2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (rm2Var = this.a) == null || (sm2Var = this.b) == null) {
            return;
        }
        rm2Var.c(sm2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, sm2 sm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sm2Var, rm2Var, i03Var)) == null) {
            ix1.i("map", "ChooseLocationAction start");
            if (!sm2Var.isValid()) {
                ix1.c("map", "model is invalid");
                return false;
            }
            String str = sm2Var.z;
            if (TextUtils.isEmpty(str)) {
                ix1.c("map", "cb is empty");
                return false;
            }
            this.a = rm2Var;
            this.b = sm2Var;
            i54.b(context, new a(this, rm2Var, str));
            ix1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t44
    /* renamed from: f */
    public boolean b(Context context, sm2 sm2Var, rm2 rm2Var, i03 i03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, sm2Var, rm2Var, i03Var, jSONObject)) == null) ? e(context, sm2Var, rm2Var, i03Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s54 b3 = s54.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.repackage.s54.b
    public void onCancel() {
        sm2 sm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ix1.i("map", "choose location cancel");
            rm2 rm2Var = this.a;
            if (rm2Var == null || (sm2Var = this.b) == null) {
                return;
            }
            rm2Var.b(sm2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.s54.b
    public void onError() {
        sm2 sm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ix1.i("map", "choose location fail");
            rm2 rm2Var = this.a;
            if (rm2Var == null || (sm2Var = this.b) == null) {
                return;
            }
            rm2Var.b(sm2Var.z, 1007, "choose location failed");
        }
    }
}
