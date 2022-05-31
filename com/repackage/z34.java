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
/* loaded from: classes7.dex */
public class z34 extends s34<sl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755162954, "Lcom/repackage/z34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755162954, "Lcom/repackage/z34;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public z34() {
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

    public static z34 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new z34() : (z34) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s34
    /* renamed from: d */
    public boolean b(Context context, sl2 sl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sl2Var, ql2Var, hz2Var, jSONObject)) == null) ? f(context, sl2Var, ql2Var, hz2Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, sl2 sl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sl2Var, ql2Var, hz2Var)) == null) {
            hw1.i("map", "IncludePointsAction start");
            pl1 A = uk2.U().A(sl2Var.c);
            if (!(A instanceof nl1)) {
                hw1.c("map", "WebViewManager is null");
                return false;
            }
            q44 d = p34.b().c((nl1) A).d(sl2Var.b);
            if (d == null) {
                hw1.c("map", "can not find map by id " + sl2Var.b);
                return false;
            }
            hw1.i("map", "IncludePointsAction end");
            return g(sl2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(sl2 sl2Var, q44 q44Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sl2Var, q44Var)) == null) {
            if (sl2Var == null || !sl2Var.isValid()) {
                return false;
            }
            BaiduMap map = q44Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<am2> it = sl2Var.z.iterator();
            while (it.hasNext()) {
                am2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = sl2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
