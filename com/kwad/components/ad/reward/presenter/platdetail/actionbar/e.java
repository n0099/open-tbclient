package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.j;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.core.widget.KsLogoView;
/* loaded from: classes5.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;
    public j c;
    public KsLogoView d;

    public e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = viewGroup;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            j jVar = new j(((com.kwad.components.ad.reward.presenter.a) this).a, this.b, this.d);
            this.c = jVar;
            jVar.b(w.a(((com.kwad.components.ad.reward.presenter.a) this).a.g));
            d.a(u(), com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.reward.presenter.a) this).a.g), this.d, R.dimen.obfuscated_res_0x7f0703d0, false);
        }
    }

    @Override // com.kwad.components.ad.reward.i.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.i_();
            this.d = (KsLogoView) b(R.id.obfuscated_res_0x7f090fe6);
        }
    }
}
