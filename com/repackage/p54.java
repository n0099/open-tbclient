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
import com.repackage.c64;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p54 extends f54<jn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements c64.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn2 a;
        public final /* synthetic */ dn2 b;

        public a(p54 p54Var, jn2 jn2Var, dn2 dn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var, jn2Var, dn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn2Var;
            this.b = dn2Var;
        }

        @Override // com.repackage.c64.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                ux1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755458942, "Lcom/repackage/p54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755458942, "Lcom/repackage/p54;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public p54() {
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

    public static p54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new p54() : (p54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f54
    /* renamed from: d */
    public boolean b(Context context, jn2 jn2Var, dn2 dn2Var, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jn2Var, dn2Var, u03Var, jSONObject)) == null) ? f(context, jn2Var, dn2Var, u03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, jn2 jn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jn2Var, dn2Var, u03Var)) == null) {
            ux1.i("map", "TranslateMarkerAction start");
            cn1 A = hm2.U().A(jn2Var.c);
            if (!(A instanceof an1)) {
                ux1.c("map", "WebViewManager is null");
                return false;
            }
            d64 d = c54.b().c((an1) A).d(jn2Var.b);
            if (d == null) {
                ux1.c("map", "can not find map by id " + jn2Var.b);
                return false;
            }
            return g(jn2Var, d, dn2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(jn2 jn2Var, d64 d64Var, dn2 dn2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, jn2Var, d64Var, dn2Var)) == null) {
            if (jn2Var.isValid()) {
                nn2 nn2Var = jn2Var.A;
                LatLng latLng = new LatLng(nn2Var.a, nn2Var.b);
                List<c64> I = d64Var.I(jn2Var.z);
                ux1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (c64 c64Var : I) {
                        c64Var.c(d64Var, latLng, jn2Var, new a(this, jn2Var, dn2Var));
                    }
                }
                ux1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
