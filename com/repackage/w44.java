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
import com.repackage.h44;
import com.repackage.r44;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class w44 extends s34<rl2> implements r44.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ql2 a;
    public rl2 b;

    /* loaded from: classes7.dex */
    public class a implements h44.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ w44 c;

        public a(w44 w44Var, ql2 ql2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w44Var, ql2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w44Var;
            this.a = ql2Var;
            this.b = str;
        }

        @Override // com.repackage.h44.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hw1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.repackage.h44.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hw1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755251366, "Lcom/repackage/w44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755251366, "Lcom/repackage/w44;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public w44() {
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

    public static w44 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new w44() : (w44) invokeV.objValue;
    }

    @Override // com.repackage.r44.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        ql2 ql2Var;
        rl2 rl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (ql2Var = this.a) == null || (rl2Var = this.b) == null) {
            return;
        }
        ql2Var.c(rl2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, rl2 rl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, rl2Var, ql2Var, hz2Var)) == null) {
            hw1.i("map", "ChooseLocationAction start");
            if (!rl2Var.isValid()) {
                hw1.c("map", "model is invalid");
                return false;
            }
            String str = rl2Var.z;
            if (TextUtils.isEmpty(str)) {
                hw1.c("map", "cb is empty");
                return false;
            }
            this.a = ql2Var;
            this.b = rl2Var;
            h44.b(context, new a(this, ql2Var, str));
            hw1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s34
    /* renamed from: f */
    public boolean b(Context context, rl2 rl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, rl2Var, ql2Var, hz2Var, jSONObject)) == null) ? e(context, rl2Var, ql2Var, hz2Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r44 a3 = r44.a3(null);
            a3.f3(this);
            a3.h3();
        }
    }

    @Override // com.repackage.r44.b
    public void onCancel() {
        rl2 rl2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hw1.i("map", "choose location cancel");
            ql2 ql2Var = this.a;
            if (ql2Var == null || (rl2Var = this.b) == null) {
                return;
            }
            ql2Var.b(rl2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.repackage.r44.b
    public void onError() {
        rl2 rl2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hw1.i("map", "choose location fail");
            ql2 ql2Var = this.a;
            if (ql2Var == null || (rl2Var = this.b) == null) {
                return;
            }
            ql2Var.b(rl2Var.z, 1007, "choose location failed");
        }
    }
}
