package com.kwad.sdk.contentalliance.detail.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34455b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34456c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34457d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f34458e;

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
                return;
            }
        }
        this.f34458e = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f34459a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34459a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    if (this.f34459a.f34457d) {
                        float q = com.kwad.sdk.core.config.c.q();
                        if (q > 0.0f) {
                            this.f34459a.f34455b.a(q);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
            this.f34455b = bVar;
            AdTemplate adTemplate = cVar.j;
            this.f34456c = adTemplate;
            this.f34457d = false;
            if (bVar == null || adTemplate == null) {
                return;
            }
            long b2 = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f34456c)) : com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(this.f34456c)).longValue() / 1000;
            SceneImpl sceneImpl = this.f34456c.mAdScene;
            if (sceneImpl != null && sceneImpl.getPageScene() == 1 && b2 >= com.kwad.sdk.core.config.c.r()) {
                this.f34457d = true;
            }
            if (this.f34457d) {
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.f34458e);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            if (cVar != null) {
                cVar.f34575b.remove(this.f34458e);
            }
        }
    }
}
