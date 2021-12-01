package com.kwad.sdk.draw.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsDrawAd.AdInteractionListener a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f58378b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f58379c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58380d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f58381e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.draw.a.a.a f58382f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.i.b f58383g;

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
            }
        }
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.download.a.b bVar = this.f58380d;
            if (bVar != null) {
                bVar.i();
            }
            this.f58381e.e();
        }
    }
}
