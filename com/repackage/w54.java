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
import com.repackage.h54;
import com.repackage.r54;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class w54 extends s44<rm2> implements r54.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qm2 a;
    public rm2 b;

    /* loaded from: classes7.dex */
    public class a implements h54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ w54 c;

        public a(w54 w54Var, qm2 qm2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w54Var, qm2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w54Var;
            this.a = qm2Var;
            this.b = str;
        }

        @Override // com.repackage.h54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.h54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hx1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755250405, "Lcom/repackage/w54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755250405, "Lcom/repackage/w54;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public w54() {
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

    public static w54 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new w54() : (w54) invokeV.objValue;
    }

    @Override // com.repackage.r54.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        qm2 qm2Var;
        rm2 rm2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (qm2Var = this.a) == null || (rm2Var = this.b) == null) {
            return;
        }
        qm2Var.c(rm2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, rm2 rm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, rm2Var, qm2Var, h03Var)) == null) {
            hx1.i("map", "ChooseLocationAction start");
            if (!rm2Var.isValid()) {
                hx1.c("map", "model is invalid");
                return false;
            }
            String str = rm2Var.z;
            if (TextUtils.isEmpty(str)) {
                hx1.c("map", "cb is empty");
                return false;
            }
            this.a = qm2Var;
            this.b = rm2Var;
            h54.b(context, new a(this, qm2Var, str));
            hx1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s44
    /* renamed from: f */
    public boolean b(Context context, rm2 rm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, rm2Var, qm2Var, h03Var, jSONObject)) == null) ? e(context, rm2Var, qm2Var, h03Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r54 b3 = r54.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.repackage.r54.b
    public void onCancel() {
        rm2 rm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hx1.i("map", "choose location cancel");
            qm2 qm2Var = this.a;
            if (qm2Var == null || (rm2Var = this.b) == null) {
                return;
            }
            qm2Var.b(rm2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.r54.b
    public void onError() {
        rm2 rm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hx1.i("map", "choose location fail");
            qm2 qm2Var = this.a;
            if (qm2Var == null || (rm2Var = this.b) == null) {
                return;
            }
            qm2Var.b(rm2Var.z, 1007, "choose location failed");
        }
    }
}
