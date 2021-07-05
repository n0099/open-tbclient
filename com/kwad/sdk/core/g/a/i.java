package com.kwad.sdk.core.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36152a;

    /* renamed from: b  reason: collision with root package name */
    public String f36153b;

    /* renamed from: c  reason: collision with root package name */
    public int f36154c;

    /* renamed from: d  reason: collision with root package name */
    public int f36155d;

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
            iVar.f36152a = ah.l();
            iVar.f36153b = ah.k(KsAdSDKImpl.get().getContext());
            iVar.f36154c = v.d(KsAdSDKImpl.get().getContext());
            iVar.f36155d = v.e(KsAdSDKImpl.get().getContext());
            return iVar;
        }
        return (i) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "ip", this.f36152a);
            o.a(jSONObject, "mac", this.f36153b);
            o.a(jSONObject, "connectionType", this.f36154c);
            o.a(jSONObject, "operatorType", this.f36155d);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
