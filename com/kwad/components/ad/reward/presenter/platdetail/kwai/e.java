package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.c.g;
import com.kwad.components.ad.reward.c.k;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.c.d, g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public View c;
    public ImageView d;
    public f e;

    public e() {
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
        this.e = new f(this) { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                    this.a.g();
                }
            }
        };
        a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.a());
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.a());
        a((Presenter) new com.kwad.components.ad.reward.presenter.c.d());
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (!((com.kwad.components.ad.reward.presenter.a) this).a.u) {
                this.c.setVisibility(8);
            }
            this.b.setVisibility(0);
            Context u = u();
            if (l.b(((com.kwad.components.ad.reward.presenter.a) this).a.g) && ae.e(u)) {
                this.d.setVisibility(8);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.a(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
                this.b.setVisibility(8);
                this.c.setVisibility(8);
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.e);
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
            h();
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
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (((com.kwad.components.ad.reward.presenter.a) this).a.u) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(8);
                this.c.setVisibility(0);
            }
            Context u = u();
            if (l.b(((com.kwad.components.ad.reward.presenter.a) this).a.g) && ae.e(u)) {
                this.d.setVisibility(0);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.i_();
            this.b = b(R.id.obfuscated_res_0x7f0910ae);
            this.c = b(R.id.obfuscated_res_0x7f0910af);
            this.d = (ImageView) b(R.id.obfuscated_res_0x7f091004);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.k_();
            i();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.e);
            com.kwad.components.ad.reward.b.a().b(this);
            this.c.setVisibility(8);
        }
    }
}
