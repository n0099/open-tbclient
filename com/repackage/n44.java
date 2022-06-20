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
import com.repackage.a54;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n44 extends d44<hm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements a54.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm2 a;
        public final /* synthetic */ bm2 b;

        public a(n44 n44Var, hm2 hm2Var, bm2 bm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var, hm2Var, bm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm2Var;
            this.b = bm2Var;
        }

        @Override // com.repackage.a54.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                sw1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755519485, "Lcom/repackage/n44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755519485, "Lcom/repackage/n44;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    public n44() {
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

    public static n44 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new n44() : (n44) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d44
    /* renamed from: d */
    public boolean b(Context context, hm2 hm2Var, bm2 bm2Var, sz2 sz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hm2Var, bm2Var, sz2Var, jSONObject)) == null) ? f(context, hm2Var, bm2Var, sz2Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, hm2 hm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, hm2Var, bm2Var, sz2Var)) == null) {
            sw1.i("map", "TranslateMarkerAction start");
            am1 A = fl2.U().A(hm2Var.c);
            if (!(A instanceof yl1)) {
                sw1.c("map", "WebViewManager is null");
                return false;
            }
            b54 d = a44.b().c((yl1) A).d(hm2Var.b);
            if (d == null) {
                sw1.c("map", "can not find map by id " + hm2Var.b);
                return false;
            }
            return g(hm2Var, d, bm2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(hm2 hm2Var, b54 b54Var, bm2 bm2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, hm2Var, b54Var, bm2Var)) == null) {
            if (hm2Var.isValid()) {
                lm2 lm2Var = hm2Var.A;
                LatLng latLng = new LatLng(lm2Var.a, lm2Var.b);
                List<a54> I = b54Var.I(hm2Var.z);
                sw1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (a54 a54Var : I) {
                        a54Var.c(b54Var, latLng, hm2Var, new a(this, hm2Var, bm2Var));
                    }
                }
                sw1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
