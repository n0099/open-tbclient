package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h64;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u54 extends k54<on2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements h64.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on2 a;
        public final /* synthetic */ in2 b;

        public a(u54 u54Var, on2 on2Var, in2 in2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u54Var, on2Var, in2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on2Var;
            this.b = in2Var;
        }

        @Override // com.repackage.h64.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                zx1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755309987, "Lcom/repackage/u54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755309987, "Lcom/repackage/u54;");
                return;
            }
        }
        boolean z = jh1.a;
    }

    public u54() {
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

    public static u54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new u54() : (u54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.k54
    /* renamed from: d */
    public boolean b(Context context, on2 on2Var, in2 in2Var, z03 z03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, on2Var, in2Var, z03Var, jSONObject)) == null) ? f(context, on2Var, in2Var, z03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, on2 on2Var, in2 in2Var, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, on2Var, in2Var, z03Var)) == null) {
            zx1.i("map", "TranslateMarkerAction start");
            hn1 A = mm2.U().A(on2Var.c);
            if (!(A instanceof fn1)) {
                zx1.c("map", "WebViewManager is null");
                return false;
            }
            i64 d = h54.b().c((fn1) A).d(on2Var.b);
            if (d == null) {
                zx1.c("map", "can not find map by id " + on2Var.b);
                return false;
            }
            return g(on2Var, d, in2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(on2 on2Var, i64 i64Var, in2 in2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, on2Var, i64Var, in2Var)) == null) {
            if (on2Var.isValid()) {
                sn2 sn2Var = on2Var.A;
                LatLng latLng = new LatLng(sn2Var.a, sn2Var.b);
                List<h64> I = i64Var.I(on2Var.z);
                zx1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (h64 h64Var : I) {
                        h64Var.c(i64Var, latLng, on2Var, new a(this, on2Var, in2Var));
                    }
                }
                zx1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
