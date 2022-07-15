package com.kwad.components.ad.reward.presenter.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.d;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.c.g;
import com.kwad.components.ad.reward.c.k;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.presenter.a.a.c;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.kwad.components.ad.reward.presenter.a implements d, f, g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
        f();
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a((f) this);
            com.kwad.components.ad.reward.b.a().a(this);
        }
    }

    private void h() {
        List<Presenter> r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (r = r()) == null) {
            return;
        }
        for (Presenter presenter : r) {
            if (presenter instanceof c) {
                ((c) presenter).d();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.a(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a((d) this);
            } else {
                g();
            }
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
        }
    }

    @Override // com.kwad.components.ad.reward.c.f
    public final void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
        }
    }

    @Override // com.kwad.components.ad.reward.c.g
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.a.a.d());
            a((Presenter) new com.kwad.components.ad.reward.presenter.a.a.a());
            a((Presenter) new com.kwad.components.ad.reward.presenter.a.a.b());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b((d) this);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b((f) this);
            com.kwad.components.ad.reward.b.a().b(this);
        }
    }
}
