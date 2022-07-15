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
import com.repackage.p54;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c54 extends s44<wm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements p54.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm2 a;
        public final /* synthetic */ qm2 b;

        public a(c54 c54Var, wm2 wm2Var, qm2 qm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c54Var, wm2Var, qm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wm2Var;
            this.b = qm2Var;
        }

        @Override // com.repackage.p54.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                hx1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755846225, "Lcom/repackage/c54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755846225, "Lcom/repackage/c54;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public c54() {
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

    public static c54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new c54() : (c54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s44
    /* renamed from: d */
    public boolean b(Context context, wm2 wm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wm2Var, qm2Var, h03Var, jSONObject)) == null) ? f(context, wm2Var, qm2Var, h03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, wm2 wm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, wm2Var, qm2Var, h03Var)) == null) {
            hx1.i("map", "TranslateMarkerAction start");
            pm1 A = ul2.U().A(wm2Var.c);
            if (!(A instanceof nm1)) {
                hx1.c("map", "WebViewManager is null");
                return false;
            }
            q54 d = p44.b().c((nm1) A).d(wm2Var.b);
            if (d == null) {
                hx1.c("map", "can not find map by id " + wm2Var.b);
                return false;
            }
            return g(wm2Var, d, qm2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(wm2 wm2Var, q54 q54Var, qm2 qm2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, wm2Var, q54Var, qm2Var)) == null) {
            if (wm2Var.isValid()) {
                an2 an2Var = wm2Var.A;
                LatLng latLng = new LatLng(an2Var.a, an2Var.b);
                List<p54> I = q54Var.I(wm2Var.z);
                hx1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (p54 p54Var : I) {
                        p54Var.c(q54Var, latLng, wm2Var, new a(this, wm2Var, qm2Var));
                    }
                }
                hx1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
