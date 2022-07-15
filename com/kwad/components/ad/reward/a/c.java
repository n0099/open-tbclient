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
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate b;
    public boolean c;

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
        this.c = false;
    }

    public static boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) {
            AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
            return (!com.kwad.components.ad.reward.kwai.b.b(adInfo) || bd == null || bd.isCouponListEmpty()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.b = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
        }
    }

    @Override // com.kwad.components.ad.reward.a.b.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), 29, 1);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.d.b.a("RewardCouponDialogPresenter", "onBind hasShown : " + this.c);
            if (this.c) {
                return;
            }
            AdInfo i = d.i(this.b);
            ViewGroup viewGroup = (ViewGroup) ((com.kwad.components.ad.reward.presenter.a) this).a.h.findViewById(R.id.obfuscated_res_0x7f09114b);
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            View view2 = viewGroup;
            if (childCount > 0) {
                view2 = viewGroup.getChildAt(0);
            }
            int[] b = com.kwad.sdk.b.kwai.a.b(view2);
            if (!a(i) || b == null) {
                return;
            }
            view2.post(new Runnable(this, b) { // from class: com.kwad.components.ad.reward.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int[] a;
                public final /* synthetic */ c b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, b};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = b;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.b.a("RewardCouponDialogPresenter", "targetView x: " + this.a[0] + ", y: " + this.a[1]);
                        b.a(this.b.s(), this.b.b, this.b, this.a);
                        this.b.c = true;
                    }
                }
            });
        }
    }
}
