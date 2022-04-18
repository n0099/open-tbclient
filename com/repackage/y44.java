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
public class y44 extends u44<vm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755191784, "Lcom/repackage/y44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755191784, "Lcom/repackage/y44;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public y44() {
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

    public static y44 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new y44() : (y44) invokeV.objValue;
    }

    @Override // com.repackage.u44
    public boolean b(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, vm2Var, sm2Var, j03Var, jSONObject)) == null) ? e(context, vm2Var, sm2Var, j03Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, vm2 vm2Var, sm2 sm2Var, j03 j03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vm2Var, sm2Var, j03Var, jSONObject)) == null) {
            jx1.i("map", "GetCenterLcationAction start");
            rm1 A = wl2.U().A(vm2Var.c);
            if (!(A instanceof pm1)) {
                jx1.c("map", "WebViewManager is null");
                return false;
            }
            s54 d = r44.b().c((pm1) A).d(vm2Var.b);
            if (d == null) {
                jx1.c("map", "can not find map by id " + vm2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            cn2 cn2Var = new cn2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            cn2Var.a = d2;
            cn2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", cn2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jx1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
