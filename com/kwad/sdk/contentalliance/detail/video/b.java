package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f34307a;

    /* renamed from: b  reason: collision with root package name */
    public long f34308b;

    /* renamed from: c  reason: collision with root package name */
    public long f34309c;

    /* renamed from: d  reason: collision with root package name */
    public int f34310d;

    public b() {
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
        this.f34308b = -1L;
    }

    public b(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34308b = -1L;
        this.f34307a = com.kwad.sdk.core.response.b.c.o(adTemplate);
        this.f34308b = j;
        this.f34309c = com.kwad.sdk.core.response.b.c.t(adTemplate);
        this.f34310d = com.kwad.sdk.core.response.b.c.e(adTemplate);
    }

    @NonNull
    public static b a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) ? new b(adTemplate, j.d(adTemplate)) : (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("contentType", this.f34310d);
                jSONObject.put("adStyle", this.f34309c);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
