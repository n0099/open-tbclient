package d.a.q0.j.k.e;

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
import d.a.q0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.j.k.a<d.a.q0.a.h1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2078037096, "Ld/a/q0/j/k/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2078037096, "Ld/a/q0/j/k/e/a;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // d.a.q0.j.k.a
    public boolean b(Context context, d.a.q0.a.h1.c.c cVar, d.a.q0.a.h1.b bVar, d.a.q0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? e(context, cVar, bVar, eVar, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, d.a.q0.a.h1.c.c cVar, d.a.q0.a.h1.b bVar, d.a.q0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar, eVar, jSONObject)) == null) {
            d.a.q0.a.e0.d.g("map", "GetCenterLcationAction start");
            d.a.q0.a.p.e.d B = d.a.q0.a.g1.f.V().B(cVar.f46780g);
            if (!(B instanceof d.a.q0.a.p.e.b)) {
                d.a.q0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            d.a.q0.j.n.c d2 = d.a.q0.j.c.b().c((d.a.q0.a.p.e.b) B).d(cVar.f46779f);
            if (d2 == null) {
                d.a.q0.a.e0.d.b("map", "can not find map by id " + cVar.f46779f);
                return false;
            }
            MapStatus mapStatus = d2.l.getMap().getMapStatus();
            d.a.q0.a.h1.c.h.c cVar2 = new d.a.q0.a.h1.c.h.c();
            LatLng latLng = mapStatus.target;
            double d3 = latLng.latitude;
            cVar2.f48607e = d3;
            cVar2.f48608f = latLng.longitude;
            try {
                jSONObject.put("latitude", d3);
                jSONObject.put("longitude", cVar2.f48608f);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.a.q0.a.e0.d.g("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
