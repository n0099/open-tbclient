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
/* loaded from: classes10.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.b.b.b f73166b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.b.c.b f73167c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73168d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73169e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73170f;

    /* renamed from: g  reason: collision with root package name */
    public f f73171g;

    public e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73171g = new f(this) { // from class: com.kwad.sdk.reward.b.d.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f73172a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f73172a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.b.c.r(((com.kwad.sdk.reward.d) this.f73172a).f73210a.f72873f)) {
                    this.f73172a.j().findViewById(this.f73172a.f()).setVisibility(8);
                }
            }
        };
        this.f73168d = z;
        this.f73169e = z2;
    }

    @Override // com.kwad.sdk.reward.b.d.a, com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
            j().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
            super.a();
            ((com.kwad.sdk.reward.d) this).f73210a.a(this.f73171g);
        }
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            float f2 = ((com.kwad.sdk.reward.d) this).f73210a.f72874g.getResources().getDisplayMetrics().density;
            float f3 = ((com.kwad.sdk.reward.d) this).f73210a.f72874g.getResources().getDisplayMetrics().widthPixels;
            if (!ab.e(((com.kwad.sdk.reward.d) this).f73210a.f72874g)) {
                f3 = ((com.kwad.sdk.reward.d) this).f73210a.f72874g.getResources().getDisplayMetrics().heightPixels;
            }
            aVar.f72106a = (int) ((f3 / f2) + 0.5f);
            aVar.f72107b = 44;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            this.f73166b = new com.kwad.sdk.reward.b.b.b(this.f73169e);
            this.f73167c = new com.kwad.sdk.reward.b.c.b(this.f73168d);
            this.f73166b.a(j());
            this.f73167c.a(j());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            if (this.f73170f) {
                this.f73167c.g();
                this.f73166b.g();
            }
            ((com.kwad.sdk.reward.d) this).f73210a.b(this.f73171g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            if (this.f73170f) {
                this.f73167c.h();
                this.f73166b.h();
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
            this.f73170f = true;
            j().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73210a;
            aVar.s = false;
            this.f73167c.a(aVar);
            this.f73166b.a(((com.kwad.sdk.reward.d) this).f73210a);
        }
    }
}
