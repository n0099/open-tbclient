package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class m extends com.kwad.components.ad.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.b.d nr;
    public WeakReference ns;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, JSONObject jSONObject, String str) {
        super(jSONObject, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, jSONObject, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((JSONObject) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ns = new WeakReference(kVar);
    }

    public final void a(com.kwad.components.ad.reward.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.nr = dVar;
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            super.a(aVar);
            aVar.a(new com.kwad.components.ad.reward.f.b(this.bF.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
            aVar.a(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d(this) { // from class: com.kwad.components.ad.reward.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m nt;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.nt = this;
                }

                @Override // com.kwad.components.ad.reward.b.d
                public final void a(com.kwad.components.ad.reward.b.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) || this.nt.nr == null) {
                        return;
                    }
                    this.nt.nr.a(bVar);
                }
            }));
            aVar.a(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b(this) { // from class: com.kwad.components.ad.reward.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m nt;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.nt = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.b
                public final void a(com.kwad.components.core.webview.jshandler.a aVar2, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar2, str) == null) && TextUtils.equals(str, "getExtraReward")) {
                        aVar2.a(com.kwad.components.ad.reward.b.a.gp().gq());
                    }
                }
            }));
            WeakReference weakReference = this.ns;
            aVar.b(new com.kwad.components.ad.reward.h.k(weakReference != null ? (k) weakReference.get() : null, -1L, this.mJsBridgeContext));
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WeakReference weakReference = this.ns;
            com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? (k) weakReference.get() : null) != null, "end_card");
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WeakReference weakReference = this.ns;
            com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? (k) weakReference.get() : null) != null, "end_card", l(this.mAdTemplate));
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            WeakReference weakReference = this.ns;
            com.kwad.components.ad.reward.monitor.a.b((weakReference != null ? (k) weakReference.get() : null) != null, "end_card", l(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
        }
    }
}
