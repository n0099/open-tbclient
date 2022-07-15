package com.kwad.components.ad.reward.f.kwai;

import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.e;
import com.kwad.components.ad.reward.f.kwai.d;
import com.kwad.components.core.webview.b.kwai.p;
import com.kwad.components.core.webview.b.kwai.q;
import com.kwad.components.core.webview.b.t;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.utils.av;
/* loaded from: classes5.dex */
public final class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d b;
    public String c;
    public FrameLayout d;
    public t e;

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
            }
        }
    }

    @Override // com.kwad.components.ad.reward.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            b bVar = ((a) this).a;
            this.c = bVar.d;
            this.b = bVar.a;
        }
    }

    @Override // com.kwad.components.ad.reward.f.kwai.a, com.kwad.components.ad.reward.f.c
    public final void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            super.a(pVar);
            d dVar = this.b;
            if (dVar != null) {
                dVar.dismiss();
            }
            e eVar = ((a) this).a.h;
            if (eVar != null) {
                eVar.a(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.f.kwai.a, com.kwad.components.ad.reward.f.c
    public final void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar) == null) {
            this.e = tVar;
            long j = ((a) this).a.f;
            if (tVar == null || j <= 0) {
                return;
            }
            q qVar = new q();
            qVar.a = (int) (j / 1000);
            this.e.a(qVar);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            float d = com.kwad.sdk.b.kwai.a.d(u());
            aVar.a = (int) ((av.k(u()) / d) + 0.5f);
            aVar.b = (int) ((av.l(u()) / d) + 0.5f);
        }
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.f.c
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a aVar = ((a) this).a.i;
            if (aVar != null) {
                aVar.a();
            }
            d dVar = this.b;
            if (dVar != null) {
                dVar.dismiss();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.i_();
            this.d = (FrameLayout) b(R.id.obfuscated_res_0x7f0911b9);
        }
    }

    @Override // com.kwad.components.ad.reward.f.kwai.a, com.kwad.components.ad.reward.f.c
    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.l();
            b bVar = ((a) this).a;
            e eVar = bVar.h;
            if (eVar != null) {
                if (bVar.g) {
                    eVar.a(true);
                    return;
                }
                d dVar = this.b;
                if (dVar != null) {
                    dVar.dismiss();
                }
                ((a) this).a.h.b();
            }
        }
    }
}
