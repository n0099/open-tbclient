package com.kwad.components.ad.reward.presenter.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.a.a.c;
import com.kwad.components.ad.reward.presenter.a.a.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.kwad.components.ad.reward.presenter.a implements e, f, com.kwad.components.core.webview.b.d.b {
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
        bY();
    }

    private void bQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.nM.a(this);
            com.kwad.components.ad.reward.b.eV().a(this);
        }
    }

    private void dW() {
        List<Presenter> xQ;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (xQ = xQ()) == null) {
            return;
        }
        for (Presenter presenter : xQ) {
            if (presenter instanceof c) {
                ((c) presenter).hR();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, playableSource, jVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            if (k.a(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
            } else {
                bQ();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dW();
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dW();
        }
    }

    public void bY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(new d());
            a(new com.kwad.components.ad.reward.presenter.a.a.a());
            a(new com.kwad.components.ad.reward.presenter.a.a.b());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onUnbind();
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.nM.b(this);
            com.kwad.components.ad.reward.b.eV().b(this);
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
