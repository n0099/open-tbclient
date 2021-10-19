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
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f71774a;

    /* renamed from: b  reason: collision with root package name */
    public long f71775b;

    /* renamed from: c  reason: collision with root package name */
    public long f71776c;

    /* renamed from: d  reason: collision with root package name */
    public int f71777d;

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
        this.f71775b = -1L;
    }

    public b(@NonNull AdTemplate adTemplate, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71775b = -1L;
        this.f71774a = com.kwad.sdk.core.response.b.c.o(adTemplate);
        this.f71775b = j2;
        this.f71776c = com.kwad.sdk.core.response.b.c.t(adTemplate);
        this.f71777d = com.kwad.sdk.core.response.b.c.e(adTemplate);
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
                jSONObject.put("contentType", this.f71777d);
                jSONObject.put("adStyle", this.f71776c);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
