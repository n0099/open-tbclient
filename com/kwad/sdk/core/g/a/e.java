package com.kwad.sdk.core.g.a;

import android.location.Location;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public double f36136a;

    /* renamed from: b  reason: collision with root package name */
    public double f36137b;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static e a() {
        InterceptResult invokeV;
        double longitude;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e eVar = new e();
            AdLocationProxy proxyForAdLocation = KsAdSDKImpl.get().getProxyForAdLocation();
            if (proxyForAdLocation == null) {
                Location a2 = com.kwad.sdk.utils.l.a(KsAdSDKImpl.get().getContext());
                if (a2 != null) {
                    eVar.f36136a = a2.getLatitude();
                    longitude = a2.getLongitude();
                }
                return eVar;
            }
            eVar.f36136a = proxyForAdLocation.getLatitude();
            longitude = proxyForAdLocation.getLongitude();
            eVar.f36137b = longitude;
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "latitude", this.f36136a);
            o.a(jSONObject, "longitude", this.f36137b);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
