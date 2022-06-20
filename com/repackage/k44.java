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
public class k44 extends d44<dm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755608858, "Lcom/repackage/k44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755608858, "Lcom/repackage/k44;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    public k44() {
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

    public static k44 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new k44() : (k44) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d44
    /* renamed from: d */
    public boolean b(Context context, dm2 dm2Var, bm2 bm2Var, sz2 sz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dm2Var, bm2Var, sz2Var, jSONObject)) == null) ? f(context, dm2Var, bm2Var, sz2Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, dm2 dm2Var, bm2 bm2Var, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, dm2Var, bm2Var, sz2Var)) == null) {
            sw1.i("map", "IncludePointsAction start");
            am1 A = fl2.U().A(dm2Var.c);
            if (!(A instanceof yl1)) {
                sw1.c("map", "WebViewManager is null");
                return false;
            }
            b54 d = a44.b().c((yl1) A).d(dm2Var.b);
            if (d == null) {
                sw1.c("map", "can not find map by id " + dm2Var.b);
                return false;
            }
            sw1.i("map", "IncludePointsAction end");
            return g(dm2Var, d);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(dm2 dm2Var, b54 b54Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, dm2Var, b54Var)) == null) {
            if (dm2Var == null || !dm2Var.isValid()) {
                return false;
            }
            BaiduMap map = b54Var.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<lm2> it = dm2Var.z.iterator();
            while (it.hasNext()) {
                lm2 next = it.next();
                builder.include(new LatLng(next.a, next.b));
            }
            LatLngBounds build = builder.build();
            int[] iArr = dm2Var.A;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
