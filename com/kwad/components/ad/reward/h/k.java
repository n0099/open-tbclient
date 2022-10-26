package com.kwad.components.ad.reward.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.jshandler.s;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class k extends s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference ns;
    public long tQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(com.kwad.components.ad.reward.k kVar, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, Long.valueOf(j), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.kwad.sdk.core.webview.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tQ = -1L;
        this.tQ = j;
        if (kVar != null) {
            this.ns = new WeakReference(kVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.s
    public final void a(com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            super.a(fVar);
            WeakReference weakReference = this.ns;
            if (weakReference != null && weakReference.get() != null) {
                fVar.F(((com.kwad.components.ad.reward.k) this.ns.get()).eF.getPlayDuration());
                return;
            }
            long j = this.tQ;
            if (j > 0) {
                fVar.F(j);
            }
        }
    }
}
