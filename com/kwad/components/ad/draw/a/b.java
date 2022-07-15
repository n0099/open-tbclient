package com.kwad.components.ad.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public com.kwad.sdk.core.response.model.b c;
    public g d;
    public Runnable e;

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
        this.d = new h(this) { // from class: com.kwad.components.ad.draw.a.b.1
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

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    if (this.a.b.getVisibility() == 0) {
                        this.a.b.setVisibility(8);
                    }
                }
            }
        };
        this.e = new Runnable(this) { // from class: com.kwad.components.ad.draw.a.b.2
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

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int width = this.a.q().getWidth();
                    ViewGroup.LayoutParams layoutParams = this.a.b.getLayoutParams();
                    int c = this.a.c.c();
                    int b = this.a.c.b();
                    if (c == 0 || b == 0 || b > c) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                        this.a.b.setLayoutParams(layoutParams);
                    } else {
                        layoutParams.width = width;
                        layoutParams.height = (int) ((b / (c * 1.0f)) * width);
                        this.a.b.setLayoutParams(layoutParams);
                        this.a.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                    this.a.b.setImageDrawable(null);
                    KSImageLoader.loadImage(this.a.b, this.a.c.a(), ((com.kwad.components.ad.draw.kwai.a) this.a).a.c);
                }
            }
        };
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.response.model.b ae = com.kwad.sdk.core.response.a.a.ae(com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.draw.kwai.a) this).a.c));
            this.c = ae;
            if (TextUtils.isEmpty(ae.a())) {
                return;
            }
            q().post(this.e);
            this.b.setVisibility(0);
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.a(this.d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.b = (ImageView) b(R.id.obfuscated_res_0x7f0911d2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            q().removeCallbacks(this.e);
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.b(this.d);
        }
    }
}
