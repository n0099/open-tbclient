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
import com.kwad.components.ad.reward.i.r;
import com.kwad.components.ad.reward.i.s;
import com.kwad.components.ad.reward.i.v;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements r.a, com.kwad.sdk.core.webview.a.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s b;
    public KSFrameLayout c;
    public KsAdWebView d;
    public View e;
    public v f;

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

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.d = (KsAdWebView) b(R.id.obfuscated_res_0x7f09117e);
            this.c = (KSFrameLayout) b(R.id.obfuscated_res_0x7f09117f);
            this.e = b(R.id.obfuscated_res_0x7f0910b8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            e();
            boolean z = !ae.e(u()) && d.w(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            b.a("PlayableHorizontalPresenter", "onBind enable: " + z);
            if (z) {
                this.b.a((ViewGroup) q());
                this.b.b(w.a(((com.kwad.components.ad.reward.presenter.a) this).a.g));
                this.c.setWidthBasedRatio(false);
                if (this.f == null) {
                    this.f = new v(this.d, this.e, ((com.kwad.components.ad.reward.presenter.a) this).a.k, this);
                }
                this.f.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, (AdBaseFrameLayout) b(R.id.obfuscated_res_0x7f091182));
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.r.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.components.ad.reward.b.a().a(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.d.a(u()));
            com.kwad.sdk.core.report.a.k(((com.kwad.components.ad.reward.presenter.a) this).a.g, 67);
        }
    }

    @Override // com.kwad.components.ad.reward.i.r.a
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.i.r.a
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), 1, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.i_();
            s sVar = new s(-1);
            this.b = sVar;
            sVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.i.r.a
    public final void l_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
