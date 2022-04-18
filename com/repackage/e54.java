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
import com.repackage.r54;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e54 extends u44<ym2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements r54.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym2 a;
        public final /* synthetic */ sm2 b;

        public a(e54 e54Var, ym2 ym2Var, sm2 sm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e54Var, ym2Var, sm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ym2Var;
            this.b = sm2Var;
        }

        @Override // com.repackage.r54.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                jx1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755786643, "Lcom/repackage/e54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755786643, "Lcom/repackage/e54;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public e54() {
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

    public static e54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new e54() : (e54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u44
    /* renamed from: d */
    public boolean b(Context context, ym2 ym2Var, sm2 sm2Var, j03 j03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ym2Var, sm2Var, j03Var, jSONObject)) == null) ? f(context, ym2Var, sm2Var, j03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ym2 ym2Var, sm2 sm2Var, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ym2Var, sm2Var, j03Var)) == null) {
            jx1.i("map", "TranslateMarkerAction start");
            rm1 A = wl2.U().A(ym2Var.c);
            if (!(A instanceof pm1)) {
                jx1.c("map", "WebViewManager is null");
                return false;
            }
            s54 d = r44.b().c((pm1) A).d(ym2Var.b);
            if (d == null) {
                jx1.c("map", "can not find map by id " + ym2Var.b);
                return false;
            }
            return g(ym2Var, d, sm2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ym2 ym2Var, s54 s54Var, sm2 sm2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ym2Var, s54Var, sm2Var)) == null) {
            if (ym2Var.isValid()) {
                cn2 cn2Var = ym2Var.A;
                LatLng latLng = new LatLng(cn2Var.a, cn2Var.b);
                List<r54> I = s54Var.I(ym2Var.z);
                jx1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (r54 r54Var : I) {
                        r54Var.c(s54Var, latLng, ym2Var, new a(this, ym2Var, sm2Var));
                    }
                }
                jx1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
