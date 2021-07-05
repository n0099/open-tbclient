package com.kwad.sdk.contentalliance.home.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.entry.model.CacheTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class l extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            List<AdTemplate> b2 = com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().b();
            if (b2 == null) {
                return;
            }
            SceneImpl sceneImpl = ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35223e;
            ArrayList arrayList = new ArrayList(b2.size());
            for (AdTemplate adTemplate : b2) {
                arrayList.add(new CacheTemplate(adTemplate, sceneImpl));
            }
            com.kwad.sdk.contentalliance.home.c.a(arrayList);
            com.kwad.sdk.contentalliance.profile.tabvideo.detail.a.a().c();
            com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a;
            fVar.f35221c.setInitStartPosition(fVar.j);
        }
    }
}
