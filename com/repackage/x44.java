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
public class x44 extends t44<um2> {
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
        boolean z = sg1.a;
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

    @Override // com.repackage.t44
    public boolean b(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, um2Var, rm2Var, i03Var, jSONObject)) == null) ? e(context, um2Var, rm2Var, i03Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, um2 um2Var, rm2 rm2Var, i03 i03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, um2Var, rm2Var, i03Var, jSONObject)) == null) {
            ix1.i("map", "GetCenterLcationAction start");
            qm1 A = vl2.U().A(um2Var.c);
            if (!(A instanceof om1)) {
                ix1.c("map", "WebViewManager is null");
                return false;
            }
            r54 d = q44.b().c((om1) A).d(um2Var.b);
            if (d == null) {
                ix1.c("map", "can not find map by id " + um2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            bn2 bn2Var = new bn2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            bn2Var.a = d2;
            bn2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", bn2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ix1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
