package com.kwad.sdk.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(AdTemplate adTemplate, boolean z, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{adTemplate, Boolean.valueOf(z), jSONObject})) == null) {
            if (com.kwad.sdk.core.response.b.c.C(adTemplate)) {
                return new a(jSONObject).a(z);
            }
            if (com.kwad.sdk.core.response.b.b.p(adTemplate)) {
                return new c(jSONObject);
            }
            return null;
        }
        return (c) invokeCommon.objValue;
    }
}
