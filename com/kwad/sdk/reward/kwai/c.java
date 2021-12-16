package com.kwad.sdk.reward.kwai;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.kwai.b;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class c extends g implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f59571b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59572c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59572c = false;
    }

    public static boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) {
            AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(adInfo);
            return (!com.kwad.sdk.core.response.a.a.aI(adInfo) || aK == null || aK.isCouponListEmpty()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f59571b = ((g) this).a.f59455g;
        }
    }

    @Override // com.kwad.sdk.reward.kwai.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((g) this).a.a(q(), 29, 1);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.d.a.a("RewardCouponDialogPresenter", "onBind hasShown : " + this.f59572c);
            if (this.f59572c) {
                return;
            }
            AdInfo j2 = d.j(this.f59571b);
            ViewGroup viewGroup = (ViewGroup) ((g) this).a.f59458j.findViewById(R.id.ksad_reward_order_coupon_list);
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            View view = viewGroup;
            if (childCount > 0) {
                view = viewGroup.getChildAt(0);
            }
            int[] c2 = bb.c(view);
            if (!a(j2) || c2 == null) {
                return;
            }
            view.post(new Runnable(this, c2) { // from class: com.kwad.sdk.reward.kwai.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int[] a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f59573b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, c2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59573b = this;
                    this.a = c2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("RewardCouponDialogPresenter", "targetView x: " + this.a[0] + ", y: " + this.a[1]);
                        b.a(this.f59573b.o(), this.f59573b.f59571b, this.f59573b, this.a);
                        this.f59573b.f59572c = true;
                    }
                }
            });
        }
    }
}
