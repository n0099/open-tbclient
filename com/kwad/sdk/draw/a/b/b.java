package com.kwad.sdk.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.b;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f58346b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f58347c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f58348d;

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
        this.f58348d = new b.c(this) { // from class: com.kwad.sdk.draw.a.b.b.1
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

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || ((com.kwad.sdk.draw.kwai.a) this.a).a.a == null) {
                    return;
                }
                ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onAdClicked();
            }
        };
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.i.b bVar = ((com.kwad.sdk.draw.kwai.a) this).a.f58383g;
            this.f58347c = bVar;
            if (bVar == null) {
                return;
            }
            bVar.a(this.f58348d);
            com.kwad.sdk.i.b bVar2 = this.f58347c;
            FrameLayout frameLayout = this.f58346b;
            com.kwad.sdk.draw.kwai.b bVar3 = ((com.kwad.sdk.draw.kwai.a) this).a;
            bVar2.a(frameLayout, bVar3.f58378b, bVar3.f58379c, bVar3.f58380d);
            this.f58347c.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            com.kwad.sdk.i.b bVar = this.f58347c;
            if (bVar != null) {
                bVar.g();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f58346b = (FrameLayout) a(R.id.ksad_play_end_web_card_container);
        }
    }
}
