package com.kwad.components.ad.e.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.e.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public c.a a;
    @NonNull
    public KsNativeAd.VideoPlayListener b;
    @NonNull
    public AdBasePvFrameLayout c;
    @NonNull
    public AdTemplate d;
    @Nullable
    public com.kwad.components.core.c.a.b e;
    @NonNull
    public com.kwad.components.ad.e.b.a f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.components.core.c.a.b bVar = this.e;
            if (bVar != null) {
                bVar.i();
            }
            this.f.e();
        }
    }
}
