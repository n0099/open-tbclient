package com.kwad.sdk.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.d.c;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f65634b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f65635c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f65636d;

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
        this.f65636d = new a.b(this) { // from class: com.kwad.sdk.draw.b.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f65637a;

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
                this.f65637a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.a.b
            public void a(a.C1916a c1916a) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) || ((com.kwad.sdk.draw.a.a) this.f65637a).f65560a.f65561a == null) {
                    return;
                }
                ((com.kwad.sdk.draw.a.a) this.f65637a).f65560a.f65561a.onAdClicked();
            }
        };
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = ((com.kwad.sdk.draw.a.a) this).f65560a.f65567g;
            this.f65635c = cVar;
            if (cVar == null) {
                return;
            }
            cVar.a(this.f65636d);
            c cVar2 = this.f65635c;
            FrameLayout frameLayout = this.f65634b;
            com.kwad.sdk.draw.a.b bVar = ((com.kwad.sdk.draw.a.a) this).f65560a;
            cVar2.a(frameLayout, bVar.f65562b, bVar.f65563c, bVar.f65564d);
            this.f65635c.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f65634b = (FrameLayout) a(R.id.ksad_play_end_web_card_container);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            c cVar = this.f65635c;
            if (cVar != null) {
                cVar.g();
            }
        }
    }
}
