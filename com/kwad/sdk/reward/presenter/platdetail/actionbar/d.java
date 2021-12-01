package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes2.dex */
public class d extends g implements RewardActionBarControl.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59241b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.d.g f59242c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f59243d;

    /* renamed from: e  reason: collision with root package name */
    public int f59244e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f59245f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f59246g;

    public d(ViewGroup viewGroup, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59241b = viewGroup;
        this.f59246g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            ((com.kwad.sdk.reward.g) this).a.n.a(this);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f58874g);
            this.f59244e = this.f59243d.getVisibility();
            this.f59245f = c.a(q(), j2, this.f59243d, R.dimen.ksad_reward_order_logo_margin_bottom);
            com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.f59241b, new com.kwad.sdk.reward.d.a(this, q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.kwad.sdk.reward.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.g) this.a).a.a(this.a.q(), 10, 1);
                    }
                }

                @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        ((com.kwad.sdk.reward.g) this.a).a.a(this.a.q(), 10, 1);
                    }
                }
            });
            this.f59242c = gVar;
            gVar.a(this.f59246g);
            this.f59242c.a(((com.kwad.sdk.reward.g) this).a.f58874g);
            w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f59242c.a());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f59243d.setVisibility(this.f59244e);
            FrameLayout.LayoutParams layoutParams = this.f59245f;
            if (layoutParams != null) {
                this.f59243d.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59243d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59241b.setVisibility(0);
        }
    }
}
