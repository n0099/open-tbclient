package com.kwad.components.ad.reward.h.kwai;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.h.l;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.sdk.components.h;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.core.webview.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<k> ns;
    public com.kwad.components.ad.reward.b.e tW;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(k kVar, long j, Context context) {
        super(j, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, Long.valueOf(j), context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ns = new WeakReference<>(kVar);
    }

    @Override // com.kwad.components.core.webview.b.d
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.c.a.c cVar, h hVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, bVar, cVar, hVar, viewGroup) == null) {
            super.a(bVar, cVar, hVar, viewGroup);
            hVar.c(new l(bVar, cVar, null, this.tS, this.Nf.getClickListener()));
            com.kwad.components.ad.reward.b.e eVar = new com.kwad.components.ad.reward.b.e();
            this.tW = eVar;
            hVar.c(eVar);
        }
    }

    @Override // com.kwad.components.core.webview.b.d
    public final s c(com.kwad.sdk.core.webview.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            WeakReference<k> weakReference = this.ns;
            return new com.kwad.components.ad.reward.h.k(weakReference != null ? weakReference.get() : null, this.tS, bVar);
        }
        return (s) invokeL.objValue;
    }

    public final com.kwad.components.ad.reward.b.e iq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tW : (com.kwad.components.ad.reward.b.e) invokeV.objValue;
    }
}
