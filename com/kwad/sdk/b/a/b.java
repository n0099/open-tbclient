package com.kwad.sdk.b.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f71510a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f71511b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public AdBasePvFrameLayout f71512c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f71513d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f71514e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.b.c.a f71515f;

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
            com.kwad.sdk.core.download.b.b bVar = this.f71514e;
            if (bVar != null) {
                bVar.f();
            }
            this.f71515f.e();
        }
    }
}
