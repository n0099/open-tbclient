package com.kwad.components.ad.fullscreen.b.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.b;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.c.g;
import com.kwad.components.ad.reward.c.k;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.core.response.a.d;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.c.a implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout b;
    public final f c;

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
        this.c = new f(this) { // from class: com.kwad.components.ad.fullscreen.b.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && d.p(((com.kwad.components.ad.reward.presenter.a) this.a).a.g)) {
                    this.a.b.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (i()) {
                this.b.setVisibility(0);
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.c);
                b.a().a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void a(PlayableSource playableSource, @Nullable k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource, kVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            aVar.a = (int) ((com.kwad.sdk.b.kwai.a.c(u()) / com.kwad.sdk.b.kwai.a.d(u())) + 0.5f);
            aVar.b = 44;
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ((com.kwad.components.ad.reward.presenter.a) this).a.u) {
            this.b.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            if (!lVar.u || d.p(lVar.g)) {
                return;
            }
            this.b.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "ksad-video-top-bar" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.u = false;
            this.b.setVisibility(8);
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(f());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? l.b(((com.kwad.components.ad.reward.presenter.a) this).a) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.i_();
            this.b = (FrameLayout) b(R.id.obfuscated_res_0x7f091076);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.k_();
            if (i()) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.c);
                b.a().b(this);
            }
        }
    }
}
