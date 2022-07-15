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
public class z44 extends s44<sm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755161993, "Lcom/repackage/z44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755161993, "Lcom/repackage/z44;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public z44() {
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

    public static z44 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new z44() : (z44) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s44
    /* renamed from: d */
    public boolean b(Context context, sm2 sm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sm2Var, qm2Var, h03Var, jSONObject)) == null) ? f(context, sm2Var, qm2Var, h03Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, sm2 sm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sm2Var, qm2Var, h03Var)) == null) {
            hx1.i("map", "IncludePointsAction start");
            pm1 A = ul2.U().A(sm2Var.c);
            if (!(A instanceof nm1)) {
                hx1.c("map", "WebViewManager is null");
                return false;
            }
            q54 d = p44.b().c((nm1) A).d(sm2Var.b);
            if (d == null) {
                hx1.c("map", "can not find map by id " + sm2Var.b);
                return false;
            }
            hx1.i("map", "IncludePointsAction end");
            return g(sm2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(sm2 sm2Var, q54 q54Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sm2Var, q54Var)) == null) {
            if (sm2Var == null || !sm2Var.isValid()) {
                return false;
            }
            BaiduMap map = q54Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<an2> it = sm2Var.z.iterator();
            while (it.hasNext()) {
                an2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = sm2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
