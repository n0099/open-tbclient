package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public com.kwad.sdk.widget.f c;
    public boolean d;

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
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            if (hVar == null) {
                return;
            }
            this.d = com.kwad.sdk.core.response.a.c.d(hVar.c);
            boolean a = m.a(com.kwad.sdk.core.response.a.d.i(((e) this).a.c));
            this.b.setVisibility(a ? 0 : 8);
            if (a) {
                this.c = new com.kwad.sdk.widget.f(this.b.getContext(), this.b, this);
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            ((e) this).a.a(view2.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            com.kwad.sdk.core.d.b.a("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.d);
            if (this.d) {
                ((e) this).a.a(view2.getContext(), 153, 2);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = b(R.id.obfuscated_res_0x7f09119e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
        }
    }
}
