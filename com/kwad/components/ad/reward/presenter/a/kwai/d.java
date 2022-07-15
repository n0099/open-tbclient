package com.kwad.components.ad.reward.presenter.a.kwai;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.h.b;
import com.kwad.components.ad.reward.c.i;
import com.kwad.components.ad.reward.i.t;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout b;
    public com.kwad.components.ad.h.b c;
    @Nullable
    public FrameLayout d;
    public com.kwad.components.ad.h.b e;
    public DetailVideoView f;
    public int g;
    public final i h;
    public com.kwad.sdk.core.webview.a.kwai.a i;

    public d() {
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
        this.g = Integer.MIN_VALUE;
        this.h = new i(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.c != null && l.c(((com.kwad.components.ad.reward.presenter.a) this.a).a.g)) {
                    this.a.c.b(true);
                }
            }
        };
        this.i = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    ((com.kwad.components.ad.reward.presenter.a) this.a).a.b.a();
                }
            }
        };
    }

    private void d() {
        FrameLayout frameLayout;
        com.kwad.components.ad.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            AdTemplate adTemplate = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            if (!com.kwad.sdk.core.response.a.b.A(adTemplate) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.B(adTemplate)) || (frameLayout = this.d) == null || (bVar = this.e) == null) {
                return;
            }
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            bVar.a(frameLayout, lVar.h, adTemplate, lVar.k, lVar.f);
            this.e.d();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                if (ae.e(u())) {
                    marginLayoutParams.bottomMargin = u().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070390);
                } else {
                    marginLayoutParams.bottomMargin = 0;
                    int c = com.kwad.sdk.b.kwai.a.c(u()) / 2;
                    marginLayoutParams.width = c;
                    marginLayoutParams.height = -1;
                    marginLayoutParams.rightMargin = -c;
                }
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            AdTemplate adTemplate = lVar.g;
            com.kwad.components.ad.h.b bVar = lVar.n;
            this.c = bVar;
            if (bVar == null) {
                return;
            }
            com.kwad.components.ad.reward.c.a().a(this.h);
            this.c.a(this.i);
            com.kwad.components.ad.h.b bVar2 = this.c;
            FrameLayout frameLayout = this.b;
            l lVar2 = ((com.kwad.components.ad.reward.presenter.a) this).a;
            bVar2.a(frameLayout, lVar2.h, adTemplate, lVar2.k, lVar2.f);
            this.c.d();
            com.kwad.components.ad.h.b bVar3 = ((com.kwad.components.ad.reward.presenter.a) this).a.o;
            this.e = bVar3;
            if (bVar3 != null) {
                bVar3.a(this);
            }
            d();
        }
    }

    @Override // com.kwad.components.ad.h.b.a
    public final void a(com.kwad.components.ad.h.b bVar) {
        Animator a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && bVar.equals(this.e)) {
            if (ae.e(u())) {
                this.g = com.kwad.sdk.b.kwai.a.c(this.f);
                com.kwad.sdk.b.kwai.a.c(this.f, 49);
                a = t.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, this.e.g(), this.f);
            } else {
                a = t.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, this.f, this.e.g());
            }
            if (a != null) {
                a.start();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i_();
            this.b = (FrameLayout) b(R.id.obfuscated_res_0x7f0911ea);
            this.d = (FrameLayout) b(R.id.obfuscated_res_0x7f0910ad);
            this.f = (DetailVideoView) b(R.id.obfuscated_res_0x7f0911da);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            com.kwad.components.ad.h.b bVar = this.c;
            if (bVar != null) {
                bVar.f();
                this.c.i();
            }
            com.kwad.components.ad.reward.c.a().b(this.h);
            com.kwad.components.ad.h.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.f();
                this.e.i();
                this.e.a((b.a) null);
            }
            DetailVideoView detailVideoView = this.f;
            if (detailVideoView == null || (i = this.g) == Integer.MIN_VALUE) {
                return;
            }
            com.kwad.sdk.b.kwai.a.c(detailVideoView, i);
        }
    }
}
