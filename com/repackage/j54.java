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
/* loaded from: classes6.dex */
public class j54 extends f54<gn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755637688, "Lcom/repackage/j54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755637688, "Lcom/repackage/j54;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public j54() {
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

    public static j54 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new j54() : (j54) invokeV.objValue;
    }

    @Override // com.repackage.f54
    public boolean b(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, gn2Var, dn2Var, u03Var, jSONObject)) == null) ? e(context, gn2Var, dn2Var, u03Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, gn2 gn2Var, dn2 dn2Var, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gn2Var, dn2Var, u03Var, jSONObject)) == null) {
            ux1.i("map", "GetCenterLcationAction start");
            cn1 A = hm2.U().A(gn2Var.c);
            if (!(A instanceof an1)) {
                ux1.c("map", "WebViewManager is null");
                return false;
            }
            d64 d = c54.b().c((an1) A).d(gn2Var.b);
            if (d == null) {
                ux1.c("map", "can not find map by id " + gn2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            nn2 nn2Var = new nn2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            nn2Var.a = d2;
            nn2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", nn2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ux1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
