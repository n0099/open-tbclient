package com.kwad.sdk.reward.presenter.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes2.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.kwai.c f59091b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.a.a f59092c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59093d;

    /* renamed from: e  reason: collision with root package name */
    public f f59094e;

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
        this.f59094e = new f(this) { // from class: com.kwad.sdk.reward.presenter.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.a.d.s(((g) this.a).a.f58874g)) {
                    this.a.m().findViewById(this.a.i()).setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
            m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
            super.a();
            ((g) this).a.a(this.f59094e);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
            aVar.f57994b = 44;
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            if (this.f59093d) {
                this.f59092c.j();
                this.f59091b.j();
            }
            ((g) this).a.b(this.f59094e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c_();
            this.f59091b = new com.kwad.sdk.fullscreen.kwai.kwai.c();
            this.f59092c = new com.kwad.sdk.fullscreen.kwai.a.a();
            this.f59091b.c(m());
            this.f59092c.c(m());
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d_();
            if (this.f59093d) {
                this.f59092c.k();
                this.f59091b.k();
            }
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "ksad-video-top-bar.js" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.id.ksad_js_top : invokeV.intValue;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f59093d = true;
            m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
            this.f59092c.a(((g) this).a);
            this.f59091b.a(((g) this).a);
        }
    }
}
