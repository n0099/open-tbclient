package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m54 extends f54<fn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755548315, "Lcom/repackage/m54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755548315, "Lcom/repackage/m54;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public m54() {
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

    public static m54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new m54() : (m54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f54
    /* renamed from: d */
    public boolean b(Context context, fn2 fn2Var, dn2 dn2Var, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fn2Var, dn2Var, u03Var, jSONObject)) == null) ? f(context, fn2Var, dn2Var, u03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, fn2 fn2Var, dn2 dn2Var, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fn2Var, dn2Var, u03Var)) == null) {
            ux1.i("map", "IncludePointsAction start");
            cn1 A = hm2.U().A(fn2Var.c);
            if (!(A instanceof an1)) {
                ux1.c("map", "WebViewManager is null");
                return false;
            }
            d64 d = c54.b().c((an1) A).d(fn2Var.b);
            if (d == null) {
                ux1.c("map", "can not find map by id " + fn2Var.b);
                return false;
            }
            ux1.i("map", "IncludePointsAction end");
            return g(fn2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(fn2 fn2Var, d64 d64Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fn2Var, d64Var)) == null) {
            if (fn2Var == null || !fn2Var.isValid()) {
                return false;
            }
            BaiduMap map = d64Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<nn2> it = fn2Var.z.iterator();
            while (it.hasNext()) {
                nn2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = fn2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
