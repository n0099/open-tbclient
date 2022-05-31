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
import com.repackage.p44;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c44 extends s34<wl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements p44.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ ql2 b;

        public a(c44 c44Var, wl2 wl2Var, ql2 ql2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c44Var, wl2Var, ql2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl2Var;
            this.b = ql2Var;
        }

        @Override // com.repackage.p44.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                hw1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755847186, "Lcom/repackage/c44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755847186, "Lcom/repackage/c44;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public c44() {
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

    public static c44 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new c44() : (c44) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s34
    /* renamed from: d */
    public boolean b(Context context, wl2 wl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wl2Var, ql2Var, hz2Var, jSONObject)) == null) ? f(context, wl2Var, ql2Var, hz2Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, wl2 wl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, wl2Var, ql2Var, hz2Var)) == null) {
            hw1.i("map", "TranslateMarkerAction start");
            pl1 A = uk2.U().A(wl2Var.c);
            if (!(A instanceof nl1)) {
                hw1.c("map", "WebViewManager is null");
                return false;
            }
            q44 d = p34.b().c((nl1) A).d(wl2Var.b);
            if (d == null) {
                hw1.c("map", "can not find map by id " + wl2Var.b);
                return false;
            }
            return g(wl2Var, d, ql2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(wl2 wl2Var, q44 q44Var, ql2 ql2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, wl2Var, q44Var, ql2Var)) == null) {
            if (wl2Var.isValid()) {
                am2 am2Var = wl2Var.A;
                LatLng latLng = new LatLng(am2Var.a, am2Var.b);
                List<p44> I = q44Var.I(wl2Var.z);
                hw1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (p44 p44Var : I) {
                        p44Var.c(q44Var, latLng, wl2Var, new a(this, wl2Var, ql2Var));
                    }
                }
                hw1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
