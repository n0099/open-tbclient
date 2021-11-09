package com.kwad.sdk.draw.b.b;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.draw.view.playcard.DrawCardApp;
import com.kwad.sdk.draw.view.playcard.DrawCardH5;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f65602b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f65603c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f65604d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f65605e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f65606f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC1923a f65607g;

    public b() {
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
        this.f65607g = new a.InterfaceC1923a(this) { // from class: com.kwad.sdk.draw.b.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65608a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65608a = this;
            }

            @Override // com.kwad.sdk.draw.b.b.a.InterfaceC1923a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f65608a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (com.kwad.sdk.core.response.b.a.v(this.f65606f)) {
                f();
            } else {
                n();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f65602b.setVisibility(8);
            this.f65603c.a(this.f65605e, new DrawCardApp.a(this) { // from class: com.kwad.sdk.draw.b.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65609a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65609a = this;
                }

                @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65609a.f65602b.setVisibility(0);
                    }
                }

                @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f65609a.o();
                    }
                }
            });
            this.f65603c.setVisibility(0);
            this.f65603c.b();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f65602b.setVisibility(8);
            this.f65604d.a(this.f65605e, new DrawCardH5.a(this) { // from class: com.kwad.sdk.draw.b.b.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65610a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65610a = this;
                }

                @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65610a.f65602b.setVisibility(0);
                    }
                }

                @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f65610a.o();
                    }
                }
            });
            this.f65604d.setVisibility(0);
            this.f65604d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f65605e, 29, ((com.kwad.sdk.draw.a.a) this).f65560a.f65562b.getTouchCoords());
            KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f65560a.f65561a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f65560a.f65563c;
            this.f65605e = adTemplate;
            this.f65606f = com.kwad.sdk.core.response.b.c.i(adTemplate);
            ((com.kwad.sdk.draw.a.a) this).f65560a.f65566f.a(this.f65607g);
            this.f65603c.setVisibility(8);
            this.f65604d.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f65602b = (ViewGroup) a(R.id.ksad_ad_normal_container);
            this.f65603c = (DrawCardApp) a(R.id.ksad_card_app_container);
            this.f65604d = (DrawCardH5) a(R.id.ksad_card_h5_container);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f65603c.a();
            this.f65604d.a();
            ((com.kwad.sdk.draw.a.a) this).f65560a.f65566f.a((a.InterfaceC1923a) null);
        }
    }
}
