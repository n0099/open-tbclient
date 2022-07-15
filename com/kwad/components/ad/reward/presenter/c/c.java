package com.kwad.components.ad.reward.presenter.c;

import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.utils.av;
/* loaded from: classes5.dex */
public final class c extends a implements RewardActionBarControl.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public FrameLayout c;
    public f d;

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
        this.b = 0;
        this.d = new f(this) { // from class: com.kwad.components.ad.reward.presenter.c.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.d();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.c.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (i()) {
                this.b = this.c.getVisibility();
                q().findViewById(R.id.obfuscated_res_0x7f0911d9).setVisibility(8);
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.d);
                ((com.kwad.components.ad.reward.presenter.a) this).a.m.a(this);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.e
    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.c.setVisibility(0);
            RewardActionBarControl.a(aVar, this.c, RewardActionBarControl.ShowActionBarResult.TK);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            float d = com.kwad.sdk.b.kwai.a.d(u());
            aVar.a = (int) ((av.k(u()) / d) + 0.5f);
            aVar.b = (int) ((av.l(u()) / d) + 0.5f);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "ksad-video-bottom-card-v2" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(f());
            this.c.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l.c(((com.kwad.components.ad.reward.presenter.a) this).a) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.i_();
            this.c = (FrameLayout) b(R.id.obfuscated_res_0x7f091073);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.k_();
            if (i()) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.d);
                this.c.setVisibility(this.b);
                ((com.kwad.components.ad.reward.presenter.a) this).a.m.a((RewardActionBarControl.e) null);
            }
        }
    }
}
