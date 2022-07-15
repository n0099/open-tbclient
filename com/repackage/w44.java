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
public class w44 extends s44<tm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755251366, "Lcom/repackage/w44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755251366, "Lcom/repackage/w44;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public w44() {
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

    public static w44 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new w44() : (w44) invokeV.objValue;
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
            hx1.i("map", "GetCenterLcationAction start");
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
            an2 an2Var = new an2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            an2Var.a = d2;
            an2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", an2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            hx1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
