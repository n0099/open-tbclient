package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
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
public class z44 extends u44<vm2> {
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
        boolean z = tg1.a;
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

    public static z44 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new z44() : (z44) invokeV.objValue;
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
            jx1.i("map", "GetRegionAction start");
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
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("latitude", mapStatus.bound.southwest.latitude);
                jSONObject3.put("longitude", mapStatus.bound.southwest.longitude);
                jSONObject2.put("latitude", mapStatus.bound.northeast.latitude);
                jSONObject2.put("longitude", mapStatus.bound.northeast.longitude);
                jSONObject.put("southwest", jSONObject3);
                jSONObject.put("northeast", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jx1.i("map", "GetRegionAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
