package com.kwad.sdk.reward.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.utils.ag;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.reward.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59690b;

    public c(AdInfo adInfo, ViewGroup viewGroup) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adInfo, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59690b = adInfo;
        if (!com.kwad.sdk.core.response.a.a.aH(adInfo)) {
            if (com.kwad.sdk.core.response.a.a.aI(this.f59690b)) {
                com.kwad.sdk.reward.kwai.c cVar = new com.kwad.sdk.reward.kwai.c();
                a((Presenter) cVar);
                a(new com.kwad.sdk.reward.presenter.platdetail.actionbar.d((ViewGroup) ((ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card)).inflate(), new g.a(this, cVar) { // from class: com.kwad.sdk.reward.presenter.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.sdk.reward.kwai.c a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f59691b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr2 = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext2);
                            int i4 = newInitContext2.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext2.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.f59691b = this;
                        this.a = cVar;
                    }

                    @Override // com.kwad.sdk.reward.d.g.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.e();
                        }
                    }
                }));
                return;
            }
            return;
        }
        boolean aA = com.kwad.sdk.core.response.a.a.aA(this.f59690b);
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(aA ? R.id.ksad_reward_followed_card : R.id.ksad_reward_follow_card);
        if (viewStub == null) {
            inflate = viewGroup.findViewById(aA ? R.id.ksad_reward_follow_root : R.id.ksad_reward_followed_root);
        } else {
            inflate = viewStub.inflate();
        }
        a(new com.kwad.sdk.reward.presenter.platdetail.actionbar.c((ViewGroup) inflate));
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            int i2 = 0;
            if (!(com.kwad.sdk.core.response.a.a.az(this.f59690b) || com.kwad.sdk.core.response.a.a.aF(this.f59690b)) || ((com.kwad.sdk.reward.g) this).a.f59455g.mAdScene == null) {
                return;
            }
            if (!ag.a(q(), "com.smile.gifmaker") && ag.a(q(), "com.kuaishou.nebula")) {
                i2 = 3;
            }
            String backUrl = ((com.kwad.sdk.reward.g) this).a.f59455g.mAdScene.getBackUrl();
            String aJ = com.kwad.sdk.core.response.a.a.aJ(this.f59690b);
            if (TextUtils.isEmpty(backUrl)) {
                backUrl = "";
            }
            this.f59690b.adConversionInfo.deeplinkUrl = com.kwad.sdk.ec.a.a.a(aJ, i2, backUrl);
        }
    }
}
