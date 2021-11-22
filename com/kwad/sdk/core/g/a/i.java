package com.kwad.sdk.core.g.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65529a;

    /* renamed from: b  reason: collision with root package name */
    public String f65530b;

    /* renamed from: c  reason: collision with root package name */
    public int f65531c;

    /* renamed from: d  reason: collision with root package name */
    public int f65532d;

    public i() {
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

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            i iVar = new i();
            iVar.f65529a = ap.m();
            iVar.f65530b = ap.o(KsAdSDKImpl.get().getContext());
            iVar.f65531c = z.c(KsAdSDKImpl.get().getContext());
            iVar.f65532d = z.d(KsAdSDKImpl.get().getContext());
            return iVar;
        }
        return (i) invokeV.objValue;
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
            q.a(jSONObject, "ip", this.f65529a);
            q.a(jSONObject, "mac", this.f65530b);
            q.a(jSONObject, "connectionType", this.f65531c);
            q.a(jSONObject, "operatorType", this.f65532d);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
