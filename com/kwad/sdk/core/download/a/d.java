package com.kwad.sdk.core.download.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f36034a;

    /* renamed from: b  reason: collision with root package name */
    public e f36035b;

    /* renamed from: c  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f36036c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f36037d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36038e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36039f;

    public d() {
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
        com.kwad.sdk.core.download.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f36039f) == null) {
            return;
        }
        bVar.f();
    }
}
