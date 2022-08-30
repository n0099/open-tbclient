package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class l extends com.kwad.components.core.webview.jshandler.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long ss;
    public WeakReference<com.kwad.components.ad.reward.k> tR;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.components.ad.reward.k kVar, long j, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        super(bVar, cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, kVar, Long.valueOf(j), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.c) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ss = -1L;
        this.ss = j;
        if (kVar != null) {
            this.tR = new WeakReference<>(kVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r0 > 0) goto L8;
     */
    @Override // com.kwad.components.core.webview.jshandler.f
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final u.b a(com.kwad.sdk.core.webview.a.a.a aVar, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, adTemplate)) == null) {
            u.b a = super.a(aVar, adTemplate);
            WeakReference<com.kwad.components.ad.reward.k> weakReference = this.tR;
            long j = (weakReference == null || weakReference.get() == null) ? this.ss : this.tR.get().eF.getPlayDuration();
            a.ss = j;
            return a;
        }
        return (u.b) invokeLL.objValue;
    }

    @Override // com.kwad.components.core.webview.jshandler.f
    public final void ik() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.ik();
            if (this.Lk != null) {
                com.kwad.components.ad.reward.b.a.gp().b(this.Lk.getAdTemplate(), com.kwad.components.ad.reward.b.b.STATUS_NONE);
            }
        }
    }
}
