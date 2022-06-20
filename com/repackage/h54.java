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
import com.repackage.c54;
import com.repackage.s44;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h54 extends d44<cm2> implements c54.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bm2 a;
    public cm2 b;

    /* loaded from: classes6.dex */
    public class a implements s44.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h54 c;

        public a(h54 h54Var, bm2 bm2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h54Var, bm2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h54Var;
            this.a = bm2Var;
            this.b = str;
        }

        @Override // com.repackage.s44.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sw1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.s44.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                sw1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755697270, "Lcom/repackage/h54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755697270, "Lcom/repackage/h54;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    public h54() {
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

    public static h54 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new h54() : (h54) invokeV.objValue;
    }

    @Override // com.repackage.c54.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        bm2 bm2Var;
        cm2 cm2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (bm2Var = this.a) == null || (cm2Var = this.b) == null) {
            return;
        }
        bm2Var.c(cm2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, cm2 cm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, cm2Var, bm2Var, sz2Var)) == null) {
            sw1.i("map", "ChooseLocationAction start");
            if (!cm2Var.isValid()) {
                sw1.c("map", "model is invalid");
                return false;
            }
            String str = cm2Var.z;
            if (TextUtils.isEmpty(str)) {
                sw1.c("map", "cb is empty");
                return false;
            }
            this.a = bm2Var;
            this.b = cm2Var;
            s44.b(context, new a(this, bm2Var, str));
            sw1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d44
    /* renamed from: f */
    public boolean b(Context context, cm2 cm2Var, bm2 bm2Var, sz2 sz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, cm2Var, bm2Var, sz2Var, jSONObject)) == null) ? e(context, cm2Var, bm2Var, sz2Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c54 b3 = c54.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.repackage.c54.b
    public void onCancel() {
        cm2 cm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            sw1.i("map", "choose location cancel");
            bm2 bm2Var = this.a;
            if (bm2Var == null || (cm2Var = this.b) == null) {
                return;
            }
            bm2Var.b(cm2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.c54.b
    public void onError() {
        cm2 cm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            sw1.i("map", "choose location fail");
            bm2 bm2Var = this.a;
            if (bm2Var == null || (cm2Var = this.b) == null) {
                return;
            }
            bm2Var.b(cm2Var.z, 1007, "choose location failed");
        }
    }
}
