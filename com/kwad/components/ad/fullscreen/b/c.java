package com.kwad.components.ad.fullscreen.b;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.fullscreen.b.kwai.e;
import com.kwad.components.ad.reward.c.d;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.c.g;
import com.kwad.components.ad.reward.c.k;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements d, g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public View c;
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
        this.d = new f(this) { // from class: com.kwad.components.ad.fullscreen.b.c.1
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
                    this.a.h();
                }
            }
        };
        a((Presenter) new e());
        a((Presenter) new com.kwad.components.ad.fullscreen.b.a.a());
        a((Presenter) new com.kwad.components.ad.fullscreen.b.b.a());
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i = 8;
            if (((com.kwad.components.ad.reward.presenter.a) this).a.u) {
                this.b.setVisibility(8);
                view2 = this.c;
            } else {
                this.b.setVisibility(8);
                view2 = this.c;
                i = 0;
            }
            view2.setVisibility(i);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || ((com.kwad.components.ad.reward.presenter.a) this).a.u) {
            return;
        }
        this.b.setVisibility(0);
        this.c.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.b(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
                this.b.setVisibility(8);
                this.c.setVisibility(8);
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.d);
            com.kwad.components.ad.reward.b.a().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void a(PlayableSource playableSource, @Nullable k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource, kVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            g();
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i();
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.i_();
            this.b = b(R.id.obfuscated_res_0x7f0910ae);
            this.c = b(R.id.obfuscated_res_0x7f0910af);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.d);
            com.kwad.components.ad.reward.b.a().b(this);
        }
    }
}
