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
public class o54 extends k54<ln2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755488733, "Lcom/repackage/o54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755488733, "Lcom/repackage/o54;");
                return;
            }
        }
        boolean z = jh1.a;
    }

    public o54() {
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

    public static o54 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new o54() : (o54) invokeV.objValue;
    }

    @Override // com.repackage.k54
    public boolean b(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, ln2Var, in2Var, z03Var, jSONObject)) == null) ? e(context, ln2Var, in2Var, z03Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ln2 ln2Var, in2 in2Var, z03 z03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ln2Var, in2Var, z03Var, jSONObject)) == null) {
            zx1.i("map", "GetCenterLcationAction start");
            hn1 A = mm2.U().A(ln2Var.c);
            if (!(A instanceof fn1)) {
                zx1.c("map", "WebViewManager is null");
                return false;
            }
            i64 d = h54.b().c((fn1) A).d(ln2Var.b);
            if (d == null) {
                zx1.c("map", "can not find map by id " + ln2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            sn2 sn2Var = new sn2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            sn2Var.a = d2;
            sn2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", sn2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zx1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
