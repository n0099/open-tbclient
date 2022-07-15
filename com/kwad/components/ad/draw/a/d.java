package com.kwad.components.ad.draw.a;

import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.utils.ac;
/* loaded from: classes5.dex */
public final class d extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public g c;

    public d() {
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
        this.c = new h(this) { // from class: com.kwad.components.ad.draw.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    this.a.b.setVisibility(0);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b.setVisibility(8);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.b.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        TextView textView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (ac.b(u())) {
                textView = this.b;
                i = 8;
            } else {
                textView = this.b;
                i = 0;
            }
            textView.setVisibility(i);
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.a(this.c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (TextView) b(R.id.obfuscated_res_0x7f0911d1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.b(this.c);
        }
    }
}
