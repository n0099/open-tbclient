package com.kwad.sdk.reward.b.d;

import android.widget.FrameLayout;
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
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f73537b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.b.b.a.b f73538c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.b.b.a.c f73539d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73540e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73541f;

    /* renamed from: g  reason: collision with root package name */
    public f f73542g;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73542g = new f(this) { // from class: com.kwad.sdk.reward.b.d.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73543a;

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
                this.f73543a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73543a.o();
                }
            }
        };
        this.f73541f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (frameLayout = (FrameLayout) ((com.kwad.sdk.reward.d) this).f73590a.f73255h.findViewById(f())) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.sdk.reward.b.d.a, com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f73537b = j().findViewById(R.id.ksad_video_play_bar_h5).getVisibility();
            j().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
            super.a();
            ((com.kwad.sdk.reward.d) this).f73590a.a(this.f73542g);
        }
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            float f2 = ((com.kwad.sdk.reward.d) this).f73590a.f73254g.getResources().getDisplayMetrics().density;
            float f3 = ((com.kwad.sdk.reward.d) this).f73590a.f73254g.getResources().getDisplayMetrics().widthPixels;
            if (!ab.e(((com.kwad.sdk.reward.d) this).f73590a.f73254g)) {
                f3 = ((com.kwad.sdk.reward.d) this).f73590a.f73254g.getResources().getDisplayMetrics().heightPixels;
            }
            aVar.f72486a = (int) ((f3 / f2) + 0.5f);
            aVar.f72487b = 90;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            this.f73538c = new com.kwad.sdk.reward.b.b.a.b();
            if (this.f73541f) {
                com.kwad.sdk.reward.b.b.a.c cVar = new com.kwad.sdk.reward.b.b.a.c();
                this.f73539d = cVar;
                cVar.a(j());
            }
            this.f73538c.a(j());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f73590a.b(this.f73542g);
            if (this.f73540e) {
                this.f73538c.g();
                com.kwad.sdk.reward.b.b.a.c cVar = this.f73539d;
                if (cVar != null) {
                    cVar.g();
                }
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            if (this.f73540e) {
                com.kwad.sdk.reward.b.b.a.c cVar = this.f73539d;
                if (cVar != null) {
                    cVar.h();
                }
                this.f73538c.h();
            }
        }
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "ksad-video-bottom-card.js" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.id.ksad_js_bottom : invokeV.intValue;
    }

    @Override // com.kwad.sdk.reward.b.d.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f73540e = true;
            j().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(this.f73537b);
            this.f73538c.a(((com.kwad.sdk.reward.d) this).f73590a);
            com.kwad.sdk.reward.b.b.a.c cVar = this.f73539d;
            if (cVar != null) {
                cVar.a(((com.kwad.sdk.reward.d) this).f73590a);
            }
        }
    }
}
