package com.kwad.components.ad.reward.presenter.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.i;
import com.kwad.components.ad.reward.g.d;
import com.kwad.components.ad.reward.i.c;
import com.kwad.components.ad.reward.i.e;
import com.kwad.components.ad.reward.i.v;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a, com.kwad.sdk.core.webview.a.kwai.a, com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ViewGroup b;
    @Nullable
    public v c;
    public ViewGroup d;
    public e e;
    public c f;
    @Nullable
    public c g;
    public com.kwad.components.ad.reward.g.kwai.a h;
    public final i i;

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
                return;
            }
        }
        this.i = new i(this) { // from class: com.kwad.components.ad.reward.presenter.d.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.components.ad.reward.c.i
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f != null) {
                        this.a.f.b();
                    }
                    if (this.a.g != null) {
                        this.a.g.b();
                    }
                }
            }
        };
    }

    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, view2, z) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0910e8 || id == R.id.obfuscated_res_0x7f090fd8) {
                b(z, 2);
            }
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context u;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, adBaseFrameLayout) == null) {
            if (!ae.e(u())) {
                com.kwad.sdk.core.d.b.a("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
                return;
            }
            ((ViewStub) b(R.id.obfuscated_res_0x7f0910f2)).inflate();
            KSFrameLayout kSFrameLayout = (KSFrameLayout) b(R.id.obfuscated_res_0x7f0910e9);
            kSFrameLayout.setRadius(u().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a9));
            int size = com.kwad.sdk.core.response.a.c.f(((com.kwad.components.ad.reward.presenter.a) this).a.g).size();
            kSFrameLayout.setRatio(0.0f);
            if (size == 0) {
                u = u();
                f = 136.0f;
            } else {
                u = u();
                f = 155.0f;
            }
            com.kwad.sdk.b.kwai.a.b(kSFrameLayout, com.kwad.sdk.b.kwai.a.a(u, f));
            ViewGroup viewGroup = (ViewGroup) b(R.id.obfuscated_res_0x7f0910e8);
            this.d = viewGroup;
            viewGroup.setClickable(true);
            new f(this.d, this);
            c cVar = new c(this.d);
            this.f = cVar;
            cVar.a(this);
            this.f.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, true);
            e eVar = new e((KsAdWebView) b(R.id.obfuscated_res_0x7f0910e7), this.d, null, this);
            this.e = eVar;
            eVar.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, adBaseFrameLayout);
        }
    }

    private void b(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), z ? 1 : 153, i);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.b.a("LandPageOpenTaskPresenter", "onBind");
            if (l.b(((com.kwad.components.ad.reward.presenter.a) this).a.g)) {
                com.kwad.components.ad.reward.g.kwai.a b = d.b();
                this.h = b;
                ((com.kwad.components.ad.reward.presenter.a) this).a.C = b;
                com.kwad.components.ad.reward.c.a().a(this.i);
                AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) b(R.id.obfuscated_res_0x7f091182);
                ViewGroup viewGroup = (ViewGroup) b(R.id.obfuscated_res_0x7f090fd8);
                this.b = viewGroup;
                if (viewGroup != null) {
                    viewGroup.setClickable(true);
                    this.b.setVisibility(8);
                    new f(this.b, this);
                    c cVar = new c(this.b);
                    this.g = cVar;
                    cVar.a(this);
                    this.g.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, false);
                    ((KSFrameLayout) b(R.id.obfuscated_res_0x7f09117f)).setWidthBasedRatio(false);
                    v vVar = new v((KsAdWebView) b(R.id.obfuscated_res_0x7f09117e), this.b, null, this);
                    this.c = vVar;
                    vVar.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, adBaseFrameLayout);
                }
                a(adBaseFrameLayout);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.c.a
    public final void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            b(z, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            a(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(((com.kwad.components.ad.reward.presenter.a) this).a.g)) {
            a(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.k_();
            com.kwad.sdk.core.d.b.a("LandPageOpenTaskPresenter", "onUnbind");
            e eVar = this.e;
            if (eVar != null) {
                eVar.a();
                this.e = null;
            }
            c cVar = this.g;
            if (cVar != null) {
                cVar.a();
            }
            com.kwad.components.ad.reward.c.a().b(this.i);
            ((com.kwad.components.ad.reward.presenter.a) this).a.C = null;
        }
    }
}
