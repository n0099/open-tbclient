package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes2.dex */
public class a extends Presenter implements com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.f f59458b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59459c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f59460d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59460d = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            Object p = p();
            if (p instanceof com.kwad.sdk.splashscreen.g) {
                this.f59460d = (com.kwad.sdk.splashscreen.g) p;
            }
            com.kwad.sdk.splashscreen.g gVar = this.f59460d;
            if (gVar == null) {
                return;
            }
            this.f59459c = com.kwad.sdk.core.response.a.c.g(gVar.f59577d);
            boolean a = i.a(com.kwad.sdk.core.response.a.d.j(this.f59460d.f59577d));
            this.a.setVisibility(a ? 0 : 8);
            if (a) {
                this.f59458b = new com.kwad.sdk.widget.f(this.a.getContext(), this.a, this);
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        Context context;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (com.kwad.sdk.splashscreen.g.a(view.getContext(), com.kwad.sdk.core.response.a.d.j(this.f59460d.f59577d))) {
                gVar = this.f59460d;
                context = view.getContext();
                i2 = 53;
            } else {
                gVar = this.f59460d;
                context = view.getContext();
                i2 = 0;
            }
            gVar.a(context, i2, 2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            com.kwad.sdk.core.d.a.a("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.f59459c);
            if (this.f59459c) {
                this.f59460d.a(view.getContext(), 153, 2);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c_();
            this.a = a(R.id.ksad_splash_actionbar_full_screen);
        }
    }
}
