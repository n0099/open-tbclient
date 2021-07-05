package com.kwad.sdk.splashscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f39274a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsVideoPlayConfig f39275b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f39276c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f39277d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.b.a f39278e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f39279f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public KsScene f39280g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.b f39281h;

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
            }
        }
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f39278e) == null) {
            return;
        }
        aVar.f();
    }
}
