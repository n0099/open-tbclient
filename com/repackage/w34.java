package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class w34 extends s34<tl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755252327, "Lcom/repackage/w34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755252327, "Lcom/repackage/w34;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public w34() {
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

    public static w34 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new w34() : (w34) invokeV.objValue;
    }

    @Override // com.repackage.s34
    public boolean b(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tl2Var, ql2Var, hz2Var, jSONObject)) == null) ? e(context, tl2Var, ql2Var, hz2Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tl2Var, ql2Var, hz2Var, jSONObject)) == null) {
            hw1.i("map", "GetCenterLcationAction start");
            pl1 A = uk2.U().A(tl2Var.c);
            if (!(A instanceof nl1)) {
                hw1.c("map", "WebViewManager is null");
                return false;
            }
            q44 d = p34.b().c((nl1) A).d(tl2Var.b);
            if (d == null) {
                hw1.c("map", "can not find map by id " + tl2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            am2 am2Var = new am2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            am2Var.a = d2;
            am2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", am2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            hw1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
