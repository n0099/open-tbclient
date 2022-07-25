package com.kwad.components.ad.draw.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.c;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsDrawAd.AdInteractionListener aJ;
    @NonNull
    public com.kwad.components.ad.draw.b.a aL;
    @NonNull
    public com.kwad.components.ad.draw.a.a.a ba;
    @Nullable
    public com.kwad.components.ad.i.b bb;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public c mApkDownloadHelper;
    @NonNull
    public AdBaseFrameLayout mRootContainer;

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
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.clear();
            }
            this.aL.release();
        }
    }
}
