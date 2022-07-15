package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.h;
import com.kwad.components.ad.reward.i.i;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.l.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, RewardActionBarControl.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAuthorIconView b;
    public KsLogoView c;
    public ViewGroup d;
    public com.kwad.components.ad.reward.i.d e;
    public int f;
    public FrameLayout.LayoutParams g;

    public d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, adInfo, ksLogoView, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            FrameLayout.LayoutParams layoutParams = null;
            if (ksLogoView != null && context != null) {
                ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
                if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                    return null;
                }
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                layoutParams = a(layoutParams3);
                boolean z2 = false;
                if (z) {
                    ksLogoView.setVisibility(0);
                }
                z2 = ((!ae.e(context) && (com.kwad.components.ad.reward.kwai.b.a(adInfo) || com.kwad.components.ad.reward.kwai.b.b(adInfo) || com.kwad.sdk.core.response.a.a.aV(adInfo))) || (ae.e(context) && com.kwad.components.ad.reward.kwai.b.a(adInfo) && com.kwad.sdk.core.response.a.a.aU(adInfo))) ? true : true;
                layoutParams3.gravity = 85;
                if (z2) {
                    i = R.dimen.obfuscated_res_0x7f0703b6;
                }
                layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
                layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0703b6);
                ksLogoView.setLayoutParams(layoutParams3);
            }
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeCommon.objValue;
    }

    public static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutParams)) == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams2.gravity = layoutParams.gravity;
            return layoutParams2;
        }
        return (FrameLayout.LayoutParams) invokeL.objValue;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.core.widget.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, adTemplate, fVar) == null) {
            this.b.setVisibility(0);
            this.b.a(adTemplate);
            this.b.a(fVar);
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                Context u = u();
                if (u != null) {
                    if (ae.e(u)) {
                        layoutParams2.gravity = 85;
                        layoutParams2.bottomMargin = u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b4);
                    } else {
                        layoutParams2.gravity = 21;
                        layoutParams2.bottomMargin = 0;
                    }
                    this.b.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdInfo i = com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            com.kwad.components.core.widget.f fVar = new com.kwad.components.core.widget.f();
            boolean z = !com.kwad.sdk.core.response.a.a.aU(i) && com.kwad.components.ad.reward.kwai.b.g() == 2;
            this.f = this.c.getVisibility();
            this.g = a(u(), i, this.c, R.dimen.obfuscated_res_0x7f0703bf, true);
            if (z) {
                a(((com.kwad.components.ad.reward.presenter.a) this).a.g, fVar);
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.m.a(this);
            boolean aU = com.kwad.sdk.core.response.a.a.aU(i);
            com.kwad.components.ad.reward.i.a aVar = new com.kwad.components.ad.reward.i.a(u(), ((com.kwad.components.ad.reward.presenter.a) this).a);
            this.e = aU ? new i(this.d, aVar) : new h(this.d, z, aVar);
            j.a(fVar, this.e.a());
            this.e.b(w.a(((com.kwad.components.ad.reward.presenter.a) this).a.g));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.a
    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.d.setVisibility(0);
            RewardActionBarControl.a(aVar, this.d, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_FOLLOW);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.c = (KsLogoView) b(R.id.obfuscated_res_0x7f090fe6);
            KsAuthorIconView ksAuthorIconView = (KsAuthorIconView) b(R.id.obfuscated_res_0x7f0910f5);
            this.b = ksAuthorIconView;
            ksAuthorIconView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.m.a((RewardActionBarControl.a) null);
            this.c.setVisibility(this.f);
            FrameLayout.LayoutParams layoutParams = this.g;
            if (layoutParams != null) {
                this.c.setLayoutParams(layoutParams);
            }
            this.b.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.equals(this.b)) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), 1, 2);
        }
    }
}
