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
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes7.dex */
public final class l extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.playable.a mk;
    public PlayableSource qe;
    public final com.kwad.components.ad.reward.d.f qf;

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
        this.qf = new com.kwad.components.ad.reward.d.g(this) { // from class: com.kwad.components.ad.reward.presenter.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l qg;

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
                this.qg = this;
            }

            @Override // com.kwad.components.ad.reward.d.g, com.kwad.components.ad.reward.d.f
            public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.j jVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, playableSource, jVar) == null) {
                    this.qg.qe = playableSource;
                    if (this.qg.mk != null && this.qg.mk.od()) {
                        this.qg.mk.e(playableSource);
                        com.kwad.components.ad.reward.k kVar = this.qg.nM;
                        if (kVar != null) {
                            kVar.d(playableSource);
                            this.qg.nM.E(true);
                            this.qg.nM.eF.pause();
                        }
                        com.kwad.components.ad.reward.b.eV().b(playableSource);
                        return;
                    }
                    if (this.qg.mk != null) {
                        this.qg.mk.ha();
                    }
                    if (jVar != null) {
                        jVar.gv();
                        com.kwad.sdk.core.e.b.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
                    } else if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.qg.nM.mAdTemplate))) {
                        DownloadLandPageActivity.launch(this.qg.getActivity(), this.qg.nM.mAdTemplate, true);
                    }
                }
            }

            @Override // com.kwad.components.ad.reward.d.g, com.kwad.components.ad.reward.d.f
            public final void bO() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.qg.mk.ha();
                    com.kwad.components.ad.reward.k kVar = this.qg.nM;
                    if (kVar != null) {
                        kVar.d((PlayableSource) null);
                        this.qg.nM.eF.resume();
                    }
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.components.ad.reward.k kVar = this.nM;
            com.kwad.components.core.playable.a aVar = kVar.mk;
            this.mk = aVar;
            aVar.a(kVar.mAdTemplate, kVar.mRootContainer, kVar.mApkDownloadHelper);
            com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "playable");
            com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "playable", com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate)));
            this.mk.oc();
            this.mk.a(new x.b(this) { // from class: com.kwad.components.ad.reward.presenter.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l qg;

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
                    this.qg = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.x.b
                public final void a(x.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) || aVar2.isSuccess()) {
                        return;
                    }
                    AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.qg.nM.mAdTemplate);
                    long loadTime = this.qg.nM.mk.getLoadTime();
                    if (loadTime == -1) {
                        return;
                    }
                    com.kwad.components.ad.reward.monitor.a.a(this.qg.nM.mz, "playable", com.kwad.sdk.core.response.a.a.bc(bQ), System.currentTimeMillis() - loadTime);
                }
            });
            this.mk.a(new KsAdWebView.d(this) { // from class: com.kwad.components.ad.reward.presenter.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l qg;

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
                    this.qg = this;
                }

                @Override // com.kwad.components.core.webview.KsAdWebView.d
                public final void a(int i, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    }
                }

                @Override // com.kwad.components.core.webview.KsAdWebView.d
                public final void bv() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                @Override // com.kwad.components.core.webview.KsAdWebView.d
                public final void bw() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.qg.nM.mAdTemplate);
                        long loadTime = this.qg.nM.mk.getLoadTime();
                        if (loadTime == -1) {
                            return;
                        }
                        com.kwad.components.ad.reward.monitor.a.b(this.qg.nM.mz, "playable", com.kwad.sdk.core.response.a.a.bc(bQ), System.currentTimeMillis() - loadTime);
                    }
                }
            });
            com.kwad.components.ad.reward.b.eV().a(this.qf);
        }
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource) == null) || (aVar = this.mk) == null) {
            return;
        }
        if (playableSource != null) {
            aVar.e(playableSource);
        } else {
            aVar.e(this.qe);
        }
    }

    public final void ha() {
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.mk) == null) {
            return;
        }
        aVar.ha();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            ((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091137)).setVisibility(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            this.mk.ob();
            this.mk.ha();
            com.kwad.components.ad.reward.b.eV().b(this.qf);
        }
    }
}
