package com.kwad.components.ad.reward.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.a.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public boolean oB;

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
                return;
            }
        }
        this.oB = false;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.oB = true;
        return true;
    }

    public static boolean k(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) {
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
            return (!com.kwad.components.ad.reward.kwai.b.h(adInfo) || bN == null || bN.isCouponListEmpty()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            this.mAdTemplate = this.nM.mAdTemplate;
        }
    }

    @Override // com.kwad.components.ad.reward.a.b.a
    public final void gn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.nM.a(getContext(), 29, 1);
        }
    }

    public final void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.e.b.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.oB);
            if (this.oB) {
                return;
            }
            AdInfo bQ = d.bQ(this.mAdTemplate);
            ViewGroup viewGroup = (ViewGroup) this.nM.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091293);
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            View view2 = viewGroup;
            if (childCount > 0) {
                view2 = viewGroup.getChildAt(0);
            }
            int[] z = com.kwad.sdk.b.kwai.a.z(view2);
            if (!k(bQ) || z == null) {
                return;
            }
            view2.post(new Runnable(this, z) { // from class: com.kwad.components.ad.reward.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int[] oC;
                public final /* synthetic */ c oD;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, z};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.oD = this;
                    this.oC = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.e.b.d("RewardCouponDialogPresenter", "targetView x: " + this.oC[0] + ", y: " + this.oC[1]);
                        b.a(this.oD.getActivity(), this.oD.mAdTemplate, this.oD, this.oC);
                        c.a(this.oD, true);
                    }
                }
            });
        }
    }
}
