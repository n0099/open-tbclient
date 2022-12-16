package com.kwad.components.ad.reward.presenter.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.i.d;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a, com.kwad.sdk.core.webview.a.kwai.a, com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.i.kwai.a mL;
    public final h mRewardVerifyListener;
    @Nullable
    public t sV;
    @Nullable

    /* renamed from: tv  reason: collision with root package name */
    public ViewGroup f1109tv;
    public ViewGroup tw;
    public e tx;
    public c ty;
    @Nullable
    public c tz;

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
        this.mRewardVerifyListener = new h(this) { // from class: com.kwad.components.ad.reward.presenter.d.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a tA;

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
                this.tA = this;
            }

            @Override // com.kwad.components.ad.reward.d.h
            public final void onRewardVerify() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.tA.ty != null) {
                        this.tA.ty.iP();
                    }
                    if (this.tA.tz != null) {
                        this.tA.tz.iP();
                    }
                }
            }
        };
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context context;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, adBaseFrameLayout) == null) {
            if (!ag.cB(getContext())) {
                com.kwad.sdk.core.e.b.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
                return;
            }
            ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0911f1)).inflate();
            KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911e8);
            kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a7));
            int size = com.kwad.sdk.core.response.a.c.bH(this.nM.mAdTemplate).size();
            kSFrameLayout.setRatio(0.0f);
            if (size == 0) {
                context = getContext();
                f = 136.0f;
            } else {
                context = getContext();
                f = 155.0f;
            }
            com.kwad.sdk.b.kwai.a.h(kSFrameLayout, com.kwad.sdk.b.kwai.a.a(context, f));
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911e7);
            this.tw = viewGroup;
            viewGroup.setClickable(true);
            new f(this.tw, this);
            c cVar = new c(this.tw);
            this.ty = cVar;
            cVar.a(this);
            this.ty.c(this.nM.mAdTemplate, true);
            e eVar = new e((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0911e6), this.tw, null, this);
            this.tx = eVar;
            eVar.a(this.nM.mAdTemplate, adBaseFrameLayout);
        }
    }

    private void c(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, z) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0911e7 || id == R.id.obfuscated_res_0x7f0910da) {
                d(z, 2);
            }
        }
    }

    private void d(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.nM.a(getContext(), z ? 1 : 153, i);
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
            com.kwad.sdk.core.e.b.d("LandPageOpenTaskPresenter", "onBind");
            if (k.p(this.nM.mAdTemplate)) {
                com.kwad.components.ad.reward.i.kwai.a iA = d.iA();
                this.mL = iA;
                this.nM.mL = iA;
                com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
                AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091268);
                ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910da);
                this.f1109tv = viewGroup;
                if (viewGroup != null) {
                    viewGroup.setClickable(true);
                    this.f1109tv.setVisibility(8);
                    new f(this.f1109tv, this);
                    c cVar = new c(this.f1109tv);
                    this.tz = cVar;
                    cVar.a(this);
                    this.tz.c(this.nM.mAdTemplate, false);
                    ((KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091265)).setWidthBasedRatio(false);
                    t tVar = new t((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091264), this.f1109tv, null, this);
                    this.sV = tVar;
                    tVar.a(this.nM.mAdTemplate, adBaseFrameLayout);
                }
                a(adBaseFrameLayout);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            d(z, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            c(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.nM.mAdTemplate)) {
            c(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            com.kwad.sdk.core.e.b.d("LandPageOpenTaskPresenter", "onUnbind");
            e eVar = this.tx;
            if (eVar != null) {
                eVar.iR();
                this.tx = null;
            }
            c cVar = this.tz;
            if (cVar != null) {
                cVar.iO();
            }
            com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
            this.nM.mL = null;
        }
    }
}
