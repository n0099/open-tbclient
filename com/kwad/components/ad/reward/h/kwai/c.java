package com.kwad.components.ad.reward.h.kwai;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.b.f;
import com.kwad.sdk.components.h;
/* loaded from: classes7.dex */
public final class c extends com.kwad.components.core.webview.b.b.c implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a tU;

    public c() {
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

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || (aVar = this.tU) == null) {
            return;
        }
        aVar.b(bVar);
    }

    @Override // com.kwad.components.core.webview.b.b.a, com.kwad.components.core.webview.b.e
    public final void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bVar) == null) {
            super.a(hVar, bVar);
            hVar.c(new f(new com.kwad.components.ad.reward.b.d(this) { // from class: com.kwad.components.ad.reward.h.kwai.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c tV;

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
                    this.tV = this;
                }

                @Override // com.kwad.components.ad.reward.b.d
                public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                        com.kwad.sdk.core.e.b.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.gs());
                        this.tV.a(bVar2);
                    }
                }
            }));
            hVar.c(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b(this) { // from class: com.kwad.components.ad.reward.h.kwai.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c tV;

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
                    this.tV = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.b
                public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, str) == null) && TextUtils.equals(str, "getExtraReward")) {
                        aVar.a(com.kwad.components.ad.reward.b.a.gp().gq());
                        com.kwad.components.ad.reward.b.a.gp().a(aVar);
                    }
                }
            }));
        }
    }

    @Override // com.kwad.components.core.webview.b.b.a
    public final com.kwad.components.core.webview.b.d ip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = (a) this.Ob;
            this.tU = aVar;
            return new d(null, aVar.tS, getContext());
        }
        return (com.kwad.components.core.webview.b.d) invokeV.objValue;
    }
}
