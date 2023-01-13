package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes8.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.k.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup es;
    public KsLogoView pM;
    public h rM;

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
        this.es = viewGroup;
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
                z2 = ((!ag.cB(context) && (com.kwad.components.ad.reward.kwai.b.h(adInfo) || com.kwad.sdk.core.response.a.a.bF(adInfo))) || (ag.cB(context) && com.kwad.sdk.core.response.a.a.bE(adInfo))) ? true : true;
                layoutParams3.gravity = 85;
                if (z2) {
                    i = R.dimen.obfuscated_res_0x7f0703b4;
                }
                layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
                layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0703b4);
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

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            h hVar = new h(this.nM, this.es, this.pM);
            this.rM = hVar;
            hVar.b(u.D(this.nM.mAdTemplate));
            a(getContext(), com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate), this.pM, R.dimen.obfuscated_res_0x7f0703ce, false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void gn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void hA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void hz() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCreate();
            this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0910f3);
        }
    }
}
