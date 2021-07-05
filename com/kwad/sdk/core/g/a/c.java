package com.kwad.sdk.core.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f36123a;

    /* renamed from: b  reason: collision with root package name */
    public int f36124b;

    /* renamed from: c  reason: collision with root package name */
    public int f36125c;

    /* renamed from: d  reason: collision with root package name */
    public int f36126d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36123a = 0;
        this.f36124b = 0;
        this.f36125c = 0;
        this.f36126d = 0;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "contentType", this.f36123a);
            o.a(jSONObject, "allowInsertThirdAd", this.f36124b);
            o.a(jSONObject, "slideType", this.f36125c);
            o.a(jSONObject, "requestCount", this.f36126d);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
