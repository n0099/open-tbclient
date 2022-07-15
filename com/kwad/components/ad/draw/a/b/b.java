package com.kwad.components.ad.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout b;
    @Nullable
    public com.kwad.components.ad.h.b c;
    public com.kwad.sdk.core.webview.a.kwai.a d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.draw.a.b.b.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || ((com.kwad.components.ad.draw.kwai.a) this.a).a.a == null) {
                    return;
                }
                ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onAdClicked();
            }
        };
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.h.b bVar = ((com.kwad.components.ad.draw.kwai.a) this).a.g;
            this.c = bVar;
            if (bVar == null) {
                return;
            }
            bVar.a(this.d);
            com.kwad.components.ad.h.b bVar2 = this.c;
            FrameLayout frameLayout = this.b;
            com.kwad.components.ad.draw.kwai.b bVar3 = ((com.kwad.components.ad.draw.kwai.a) this).a;
            bVar2.a(frameLayout, bVar3.b, bVar3.c, bVar3.d);
            this.c.d();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (FrameLayout) b(R.id.obfuscated_res_0x7f0910b0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            com.kwad.components.ad.h.b bVar = this.c;
            if (bVar != null) {
                bVar.i();
            }
        }
    }
}
