package com.kwad.components.ad.e.a;

import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class k extends com.kwad.components.ad.e.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar c;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            this.c.setProgress(i);
            if (this.c.getVisibility() == 0) {
                return;
            }
            this.c.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.c.setProgress(0);
            this.c.setVisibility(8);
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.e.a.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void a(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i, i2) == null) {
                        this.a.d();
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void a(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.a.a(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.d();
                    }
                }
            };
            ((com.kwad.components.ad.e.kwai.a) this).b = hVar;
            ((com.kwad.components.ad.e.kwai.a) this).a.f.a(hVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.c = (ProgressBar) b(R.id.obfuscated_res_0x7f0911db);
        }
    }
}
