package com.kwad.components.ad.reward.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.f.kwai.d;
import com.kwad.components.ad.reward.i.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public final class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate b;
    public AdInfo c;
    public boolean d;

    public d(AdTemplate adTemplate, AdInfo adInfo, ViewGroup viewGroup) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, adInfo, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.c = adInfo;
        this.b = adTemplate;
        this.d = com.kwad.components.ad.reward.kwai.b.c(adInfo);
        if (com.kwad.components.ad.reward.kwai.b.a(this.c)) {
            boolean aU = com.kwad.sdk.core.response.a.a.aU(this.c);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(aU ? R.id.obfuscated_res_0x7f091112 : R.id.obfuscated_res_0x7f0910ff);
            if (viewStub == null) {
                inflate = viewGroup.findViewById(aU ? R.id.obfuscated_res_0x7f091110 : R.id.obfuscated_res_0x7f091115);
            } else {
                inflate = viewStub.inflate();
            }
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d((ViewGroup) inflate));
        } else if (com.kwad.components.ad.reward.kwai.b.b(this.c)) {
            com.kwad.components.ad.reward.a.c cVar = new com.kwad.components.ad.reward.a.c();
            a((Presenter) cVar);
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f091149);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.f((ViewGroup) (viewStub2 != null ? viewStub2.inflate() : viewGroup.findViewById(R.id.obfuscated_res_0x7f09115c)), new o.a(this, cVar) { // from class: com.kwad.components.ad.reward.presenter.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.ad.reward.a.c a;
                public final /* synthetic */ d b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = cVar;
                }

                @Override // com.kwad.components.ad.reward.i.o.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.d();
                    }
                }
            }));
        } else if (com.kwad.sdk.core.response.a.a.aV(adInfo)) {
            ViewStub viewStub3 = (ViewStub) viewGroup.findViewById(R.id.obfuscated_res_0x7f091117);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e((ViewGroup) (viewStub3 != null ? viewStub3.inflate() : viewGroup.findViewById(R.id.obfuscated_res_0x7f091131))));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if ((com.kwad.sdk.core.response.a.a.aT(this.c) || com.kwad.sdk.core.response.a.a.ba(this.c)) && ((a) this).a.g.mAdScene != null) {
                this.c.adConversionInfo.deeplinkUrl = com.kwad.components.core.c.a.c.a(u(), this.c, ((a) this).a.g.mAdScene);
            }
            if (this.d) {
                if (((a) this).a.o() == null) {
                    d.b bVar = new d.b();
                    bVar.a(this.b);
                    bVar.a("ksad-video-confirm-card");
                    bVar.a(false);
                    bVar.b(true);
                    ((a) this).a.a(com.kwad.components.ad.reward.f.kwai.d.a(bVar));
                }
                if (((a) this).a.p() == null) {
                    d.b bVar2 = new d.b();
                    bVar2.a(this.b);
                    bVar2.a("ksad-video-playend-dialog-card");
                    bVar2.a(true);
                    bVar2.b(true);
                    ((a) this).a.b(com.kwad.components.ad.reward.f.kwai.d.a(bVar2));
                }
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.k_();
            if (((a) this).a.o() != null) {
                try {
                    ((a) this).a.o().dismiss();
                    ((a) this).a.a((com.kwad.components.ad.reward.f.kwai.d) null);
                } catch (Exception unused) {
                }
            }
            if (((a) this).a.p() != null) {
                try {
                    ((a) this).a.p().dismiss();
                    ((a) this).a.b((com.kwad.components.ad.reward.f.kwai.d) null);
                } catch (Exception unused2) {
                }
            }
        }
    }
}
