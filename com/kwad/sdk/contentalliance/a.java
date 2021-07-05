package com.kwad.sdk.contentalliance;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.lib.widget.recycler.a.e<AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.a.e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean b(AdTemplate adTemplate, AdTemplate adTemplate2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, adTemplate, adTemplate2)) == null) {
            if (adTemplate == null || adTemplate2 == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.c.a(adTemplate) ? com.kwad.sdk.core.response.b.c.a(adTemplate2) && com.kwad.sdk.live.mode.a.b(com.kwad.sdk.core.response.b.c.A(adTemplate)) == com.kwad.sdk.live.mode.a.b(com.kwad.sdk.core.response.b.c.A(adTemplate2)) : com.kwad.sdk.core.response.b.c.z(adTemplate) == com.kwad.sdk.core.response.b.c.z(adTemplate2);
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.a.e
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public boolean a(AdTemplate adTemplate, AdTemplate adTemplate2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, adTemplate2)) == null) ? (adTemplate == null && adTemplate2 == null) || (adTemplate != null && adTemplate.equals(adTemplate2)) : invokeLL.booleanValue;
    }
}
