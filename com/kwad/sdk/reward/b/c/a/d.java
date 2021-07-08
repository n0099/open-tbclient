package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f36098b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.d.c f36099c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f36100d;

    public d() {
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
        this.f36100d = new a.b(this) { // from class: com.kwad.sdk.reward.b.c.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f36101a;

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
                this.f36101a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C0427a c0427a) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, c0427a) == null) {
                    ((com.kwad.sdk.reward.d) this.f36101a).f36214a.f35884b.a();
                }
            }
        };
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36214a;
            AdTemplate adTemplate = aVar.f35888f;
            com.kwad.sdk.d.c cVar = aVar.l;
            this.f36099c = cVar;
            if (cVar == null) {
                return;
            }
            cVar.a(this.f36100d);
            com.kwad.sdk.d.c cVar2 = this.f36099c;
            FrameLayout frameLayout = this.f36098b;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f36214a;
            cVar2.a(frameLayout, aVar2.f35890h, adTemplate, aVar2.j, aVar2.f35887e);
            this.f36099c.a(((com.kwad.sdk.reward.d) this).f36214a.f35889g);
            this.f36099c.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f36098b = (FrameLayout) a(R.id.ksad_web_card_container);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.d.c cVar = this.f36099c;
            if (cVar != null) {
                cVar.g();
            }
        }
    }
}
