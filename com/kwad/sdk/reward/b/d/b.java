package com.kwad.sdk.reward.b.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.utils.ab;
/* loaded from: classes2.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.a.a.c f66285b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.a.b.a f66286c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66287d;

    /* renamed from: e  reason: collision with root package name */
    public f f66288e;

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
        this.f66288e = new f(this) { // from class: com.kwad.sdk.reward.b.d.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f66289a;

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
                this.f66289a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.b.c.r(((com.kwad.sdk.reward.d) this.f66289a).f66342a.f66015f)) {
                    this.f66289a.j().findViewById(this.f66289a.f()).setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.sdk.reward.b.d.a, com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
            j().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
            super.a();
            ((com.kwad.sdk.reward.d) this).f66342a.a(this.f66288e);
        }
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            float f2 = ((com.kwad.sdk.reward.d) this).f66342a.f66016g.getResources().getDisplayMetrics().density;
            float f3 = ((com.kwad.sdk.reward.d) this).f66342a.f66016g.getResources().getDisplayMetrics().widthPixels;
            if (!ab.e(((com.kwad.sdk.reward.d) this).f66342a.f66016g)) {
                f3 = ((com.kwad.sdk.reward.d) this).f66342a.f66016g.getResources().getDisplayMetrics().heightPixels;
            }
            aVar.f65289a = (int) ((f3 / f2) + 0.5f);
            aVar.f65290b = 44;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            this.f66285b = new com.kwad.sdk.fullscreen.a.a.c();
            this.f66286c = new com.kwad.sdk.fullscreen.a.b.a();
            this.f66285b.a(j());
            this.f66286c.a(j());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            if (this.f66287d) {
                this.f66286c.g();
                this.f66285b.g();
            }
            ((com.kwad.sdk.reward.d) this).f66342a.b(this.f66288e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            if (this.f66287d) {
                this.f66286c.h();
                this.f66285b.h();
            }
        }
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "ksad-video-top-bar.js" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.id.ksad_js_top : invokeV.intValue;
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f66287d = true;
            j().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
            this.f66286c.a(((com.kwad.sdk.reward.d) this).f66342a);
            this.f66285b.a(((com.kwad.sdk.reward.d) this).f66342a);
        }
    }
}
