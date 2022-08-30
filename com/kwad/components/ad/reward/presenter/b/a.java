package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements p.a, com.kwad.sdk.core.webview.a.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView bF;
    public KSFrameLayout sT;
    public View sU;
    public t sV;
    public q sz;

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
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0911b4);
            this.sT = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911b5);
            this.sU = findViewById(R.id.obfuscated_res_0x7f09110a);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            initView();
            boolean z = !ag.cB(getContext()) && d.cd(this.nM.mAdTemplate);
            b.d("PlayableHorizontalPresenter", "onBind enable: " + z);
            if (z) {
                this.sz.e((ViewGroup) getRootView());
                this.sz.b(u.D(this.nM.mAdTemplate));
                this.sT.setWidthBasedRatio(false);
                if (this.sV == null) {
                    this.sV = new t(this.bF, this.sU, this.nM.mApkDownloadHelper, this);
                }
                this.sV.a(this.nM.mAdTemplate, (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911b8));
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void hs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void ht() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.components.ad.reward.b.eV().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(getContext()));
            com.kwad.sdk.core.report.a.r(this.nM.mAdTemplate, 67);
        }
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void hu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.nM.a(getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.k.p.a
    public final void hv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.nM.a(getContext(), 1, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onCreate();
            q qVar = new q(-1);
            this.sz = qVar;
            qVar.a(this);
        }
    }
}
