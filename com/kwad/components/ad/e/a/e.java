package com.kwad.components.ad.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes5.dex */
public final class e extends com.kwad.components.ad.e.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public KsNativeAd.VideoPlayListener d;

    public e() {
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
        this.c = false;
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.d = ((com.kwad.components.ad.e.kwai.a) this).a.b;
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.e.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.a();
                        if (this.a.d != null) {
                            try {
                                this.a.d.onVideoPlayPause();
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.b.b(th);
                            }
                        }
                        this.a.c = true;
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void a(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || this.a.d == null) {
                        return;
                    }
                    this.a.d.onVideoPlayError(i, i2);
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        super.b();
                        if (this.a.c) {
                            this.a.c = false;
                            if (this.a.d != null) {
                                try {
                                    this.a.d.onVideoPlayResume();
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.b.b(th);
                                }
                            }
                        }
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.d == null) {
                        return;
                    }
                    this.a.d.onVideoPlayStart();
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void d() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.d == null) {
                        return;
                    }
                    this.a.d.onVideoPlayComplete();
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        super.e();
                        if (this.a.d != null) {
                            try {
                                this.a.d.onVideoPlayReady();
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.b.b(th);
                            }
                        }
                    }
                }
            };
            ((com.kwad.components.ad.e.kwai.a) this).b = hVar;
            ((com.kwad.components.ad.e.kwai.a) this).a.f.a(hVar);
        }
    }
}
