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
import com.repackage.q54;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d54 extends t44<xm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements q54.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm2 a;
        public final /* synthetic */ rm2 b;

        public a(d54 d54Var, xm2 xm2Var, rm2 rm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d54Var, xm2Var, rm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xm2Var;
            this.b = rm2Var;
        }

        @Override // com.repackage.q54.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                ix1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755816434, "Lcom/repackage/d54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755816434, "Lcom/repackage/d54;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    public d54() {
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

    public static d54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new d54() : (d54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t44
    /* renamed from: d */
    public boolean b(Context context, xm2 xm2Var, rm2 rm2Var, i03 i03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xm2Var, rm2Var, i03Var, jSONObject)) == null) ? f(context, xm2Var, rm2Var, i03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, xm2 xm2Var, rm2 rm2Var, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, xm2Var, rm2Var, i03Var)) == null) {
            ix1.i("map", "TranslateMarkerAction start");
            qm1 A = vl2.U().A(xm2Var.c);
            if (!(A instanceof om1)) {
                ix1.c("map", "WebViewManager is null");
                return false;
            }
            r54 d = q44.b().c((om1) A).d(xm2Var.b);
            if (d == null) {
                ix1.c("map", "can not find map by id " + xm2Var.b);
                return false;
            }
            return g(xm2Var, d, rm2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(xm2 xm2Var, r54 r54Var, rm2 rm2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, xm2Var, r54Var, rm2Var)) == null) {
            if (xm2Var.isValid()) {
                bn2 bn2Var = xm2Var.A;
                LatLng latLng = new LatLng(bn2Var.a, bn2Var.b);
                List<q54> I = r54Var.I(xm2Var.z);
                ix1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (q54 q54Var : I) {
                        q54Var.c(r54Var, latLng, xm2Var, new a(this, xm2Var, rm2Var));
                    }
                }
                ix1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
