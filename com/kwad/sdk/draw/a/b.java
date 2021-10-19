package com.kwad.sdk.draw.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.d.c;
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f73121a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f73122b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f73123c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73124d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f73125e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.draw.b.b.a f73126f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public c f73127g;

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
            com.kwad.sdk.core.download.b.b bVar = this.f73124d;
            if (bVar != null) {
                bVar.f();
            }
            this.f73125e.e();
        }
    }
}
