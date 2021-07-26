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
/* loaded from: classes6.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.b.b.b f36360b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.b.c.b f36361c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36362d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36363e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36364f;

    /* renamed from: g  reason: collision with root package name */
    public f f36365g;

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
        this.f36365g = new f(this) { // from class: com.kwad.sdk.reward.b.d.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f36366a;

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
                this.f36366a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && com.kwad.sdk.core.response.b.c.r(((com.kwad.sdk.reward.d) this.f36366a).f36403a.f36077f)) {
                    this.f36366a.j().findViewById(this.f36366a.f()).setVisibility(8);
                }
            }
        };
        this.f36362d = z;
        this.f36363e = z2;
    }

    @Override // com.kwad.sdk.reward.b.d.a, com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
            j().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
            super.a();
            ((com.kwad.sdk.reward.d) this).f36403a.a(this.f36365g);
        }
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            float f2 = ((com.kwad.sdk.reward.d) this).f36403a.f36078g.getResources().getDisplayMetrics().density;
            float f3 = ((com.kwad.sdk.reward.d) this).f36403a.f36078g.getResources().getDisplayMetrics().widthPixels;
            if (!ab.e(((com.kwad.sdk.reward.d) this).f36403a.f36078g)) {
                f3 = ((com.kwad.sdk.reward.d) this).f36403a.f36078g.getResources().getDisplayMetrics().heightPixels;
            }
            aVar.f35351a = (int) ((f3 / f2) + 0.5f);
            aVar.f35352b = 44;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            this.f36360b = new com.kwad.sdk.reward.b.b.b(this.f36363e);
            this.f36361c = new com.kwad.sdk.reward.b.c.b(this.f36362d);
            this.f36360b.a(j());
            this.f36361c.a(j());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            if (this.f36364f) {
                this.f36361c.g();
                this.f36360b.g();
            }
            ((com.kwad.sdk.reward.d) this).f36403a.b(this.f36365g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            if (this.f36364f) {
                this.f36361c.h();
                this.f36360b.h();
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
            this.f36364f = true;
            j().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36403a;
            aVar.s = false;
            this.f36361c.a(aVar);
            this.f36360b.a(((com.kwad.sdk.reward.d) this).f36403a);
        }
    }
}
