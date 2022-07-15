package com.kwad.components.core.g;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.mvp.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<com.kwad.components.core.g.kwai.a> J;
    @NonNull
    public AdTemplate K;
    @Deprecated
    public Activity L;
    public Context M;

    public a() {
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
        this.J = new ArrayList();
    }

    @Override // com.kwad.sdk.mvp.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.J.clear();
        }
    }
}
