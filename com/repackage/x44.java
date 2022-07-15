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
public class x44 extends s44<tm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755221575, "Lcom/repackage/x44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755221575, "Lcom/repackage/x44;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public x44() {
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

    public static x44 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new x44() : (x44) invokeV.objValue;
    }

    @Override // com.repackage.s44
    public boolean b(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tm2Var, qm2Var, h03Var, jSONObject)) == null) ? e(context, tm2Var, qm2Var, h03Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tm2Var, qm2Var, h03Var, jSONObject)) == null) {
            hx1.i("map", "GetRegionAction start");
            pm1 A = ul2.U().A(tm2Var.c);
            if (!(A instanceof nm1)) {
                hx1.c("map", "WebViewManager is null");
                return false;
            }
            q54 d = p44.b().c((nm1) A).d(tm2Var.b);
            if (d == null) {
                hx1.c("map", "can not find map by id " + tm2Var.b);
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
            hx1.i("map", "GetRegionAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
