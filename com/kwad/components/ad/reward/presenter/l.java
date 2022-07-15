package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
/* loaded from: classes5.dex */
public final class l extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.playable.a b;
    public PlayableSource c;
    public final com.kwad.components.ad.reward.c.g d;

    public l() {
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
        this.d = new com.kwad.components.ad.reward.c.h(this) { // from class: com.kwad.components.ad.reward.presenter.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.h, com.kwad.components.ad.reward.c.g
            public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.c.k kVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, playableSource, kVar) == null) {
                    this.a.c = playableSource;
                    if (this.a.b != null && this.a.b.d()) {
                        this.a.b.a(playableSource);
                        com.kwad.components.ad.reward.l lVar = ((a) this.a).a;
                        if (lVar != null) {
                            lVar.a(playableSource);
                            ((a) this.a).a.d(true);
                            ((a) this.a).a.j.c();
                        }
                        com.kwad.components.ad.reward.b.a().b(playableSource);
                        return;
                    }
                    if (this.a.b != null) {
                        this.a.b.c();
                    }
                    if (kVar != null) {
                        kVar.a();
                        com.kwad.sdk.core.d.b.a("RewardPlayablePresenter", "onEnterPlayable outer handled");
                    } else if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(((a) this.a).a.g))) {
                        DownloadLandPageActivity.launch(this.a.s(), ((a) this.a).a.g, true);
                    }
                }
            }

            @Override // com.kwad.components.ad.reward.c.h, com.kwad.components.ad.reward.c.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b.c();
                    com.kwad.components.ad.reward.l lVar = ((a) this.a).a;
                    if (lVar != null) {
                        lVar.a((PlayableSource) null);
                        ((a) this.a).a.j.b();
                    }
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.reward.l lVar = ((a) this).a;
            com.kwad.components.core.playable.a aVar = lVar.l;
            this.b = aVar;
            aVar.a(lVar.g, lVar.h, lVar.k);
            this.b.b();
            com.kwad.components.ad.reward.b.a().a(this.d);
        }
    }

    public final void a(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource) == null) || (aVar = this.b) == null) {
            return;
        }
        if (playableSource != null) {
            aVar.a(playableSource);
        } else {
            aVar.a(this.c);
        }
    }

    public final void d() {
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.b) == null) {
            return;
        }
        aVar.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            ((KsAdWebView) b(R.id.obfuscated_res_0x7f0910c7)).setVisibility(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            this.b.a();
            this.b.c();
            com.kwad.components.ad.reward.b.a().b(this.d);
        }
    }
}
