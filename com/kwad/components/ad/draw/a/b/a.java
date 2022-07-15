package com.kwad.components.ad.draw.a.b;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DrawVideoTailFrame b;
    @Nullable
    public com.kwad.components.ad.h.b c;
    public g d;

    public a() {
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
        this.d = new h(this) { // from class: com.kwad.components.ad.draw.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.d();
                    if (this.a.c == null || !this.a.c.e()) {
                        this.a.d();
                    } else {
                        this.a.b.setVisibility(8);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.b.a();
            this.b.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.ad.draw.kwai.b bVar = ((com.kwad.components.ad.draw.kwai.a) this).a;
            this.c = bVar.g;
            this.b.a(bVar.c);
            this.b.setAdBaseFrameLayout(((com.kwad.components.ad.draw.kwai.a) this).a.b);
            this.b.setApkDownloadHelper(((com.kwad.components.ad.draw.kwai.a) this).a.d);
            this.b.setVisibility(8);
            this.b.setAdInteractionListener(((com.kwad.components.ad.draw.kwai.a) this).a.a);
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.a(this.d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (DrawVideoTailFrame) b(R.id.obfuscated_res_0x7f0911de);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.b(this.d);
            this.b.b();
        }
    }
}
