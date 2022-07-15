package com.kwad.components.ad.reward.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class b extends ae implements ae.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlayableSource b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adTemplate, playableSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.ae.a
    public final boolean j_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwad.components.ad.reward.b.a().a(this.b, new a(this.a));
            return false;
        }
        return invokeV.booleanValue;
    }
}
