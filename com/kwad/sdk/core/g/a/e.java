package com.kwad.sdk.core.g.a;

import android.location.Location;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.q;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static e f71599a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public double f71600b;

    /* renamed from: c  reason: collision with root package name */
    public double f71601c;

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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e eVar = f71599a;
            if (eVar != null) {
                return eVar;
            }
            Location a2 = o.a(KsAdSDKImpl.get().getContext());
            if (a2 != null) {
                e eVar2 = new e();
                f71599a = eVar2;
                eVar2.f71600b = a2.getLatitude();
                f71599a.f71601c = a2.getLongitude();
            }
            return f71599a;
        }
        return (e) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "latitude", this.f71600b);
            q.a(jSONObject, "longitude", this.f71601c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
