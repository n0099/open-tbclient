package com.kwad.sdk.reward.b.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.b.c.b.c;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a((Presenter) new c());
        a((Presenter) new com.kwad.sdk.reward.b.c.b.a());
        a((Presenter) new com.kwad.sdk.reward.b.c.b.b((z ? com.kwad.sdk.core.config.c.G() : com.kwad.sdk.core.config.c.v()) * 1000).a(true));
    }
}
