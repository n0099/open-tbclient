package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public com.kwad.components.ad.reward.c.a b;
    public com.kwad.components.ad.reward.h.a c;
    public long d;
    public final com.kwad.components.core.video.g e;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.presenter.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    this.a.b.a(i3, i4);
                    this.a.j();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    com.kwad.components.ad.reward.l lVar = ((a) this.a).a;
                    lVar.F = j2;
                    lVar.G = j - j2 < 800;
                    i iVar = this.a;
                    if (((a) iVar).a.v) {
                        return;
                    }
                    iVar.d = j2;
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.b.c();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    i iVar = this.a;
                    com.kwad.components.ad.reward.l lVar = ((a) iVar).a;
                    if (lVar.t && lVar.v) {
                        iVar.b.a(this.a.d);
                    } else {
                        this.a.b.d();
                    }
                    e.a(((a) this.a).a);
                    com.kwad.components.ad.reward.l lVar2 = ((a) this.a).a;
                    if (lVar2.G) {
                        com.kwad.components.ad.reward.o.a(lVar2);
                    }
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            lVar.F = 0L;
            lVar.G = false;
            this.b = lVar.b;
            com.kwad.components.ad.reward.h.a aVar = lVar.j;
            this.c = aVar;
            aVar.a(this.e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.k_();
            this.c.b(this.e);
        }
    }
}
