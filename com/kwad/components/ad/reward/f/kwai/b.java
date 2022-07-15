package com.kwad.components.ad.reward.f.kwai;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.f.kwai.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.e;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public e b;
    public AdTemplate c;
    public String d;
    public Activity e;
    public long f;
    public boolean g;
    public com.kwad.components.ad.reward.e h;
    public d.a i;

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
        }
    }
}
