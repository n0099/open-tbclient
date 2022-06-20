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
public class h44 extends d44<em2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755698231, "Lcom/repackage/h44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755698231, "Lcom/repackage/h44;");
                return;
            }
        }
        boolean z = cg1.a;
    }

    public h44() {
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

    public static h44 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new h44() : (h44) invokeV.objValue;
    }

    @Override // com.repackage.d44
    public boolean b(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, em2Var, bm2Var, sz2Var, jSONObject)) == null) ? e(context, em2Var, bm2Var, sz2Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, em2 em2Var, bm2 bm2Var, sz2 sz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, em2Var, bm2Var, sz2Var, jSONObject)) == null) {
            sw1.i("map", "GetCenterLcationAction start");
            am1 A = fl2.U().A(em2Var.c);
            if (!(A instanceof yl1)) {
                sw1.c("map", "WebViewManager is null");
                return false;
            }
            b54 d = a44.b().c((yl1) A).d(em2Var.b);
            if (d == null) {
                sw1.c("map", "can not find map by id " + em2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            lm2 lm2Var = new lm2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            lm2Var.a = d2;
            lm2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", lm2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sw1.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
