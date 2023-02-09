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
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView bd;
    public com.kwad.sdk.core.response.model.b be;
    public Runnable bf;
    public g mVideoPlayStateListener;

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
        this.mVideoPlayStateListener = new h(this) { // from class: com.kwad.components.ad.draw.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b bg;

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
                this.bg = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onVideoPlaying();
                    if (this.bg.bd.getVisibility() == 0) {
                        this.bg.bd.setVisibility(8);
                    }
                }
            }
        };
        this.bf = new Runnable(this) { // from class: com.kwad.components.ad.draw.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b bg;

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
                this.bg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int width = this.bg.getRootView().getWidth();
                    ViewGroup.LayoutParams layoutParams = this.bg.bd.getLayoutParams();
                    int width2 = this.bg.be.getWidth();
                    int height = this.bg.be.getHeight();
                    if (width2 == 0 || height == 0 || height > width2) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                        this.bg.bd.setLayoutParams(layoutParams);
                    } else {
                        layoutParams.width = width;
                        layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                        this.bg.bd.setLayoutParams(layoutParams);
                        this.bg.bd.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                    this.bg.bd.setImageDrawable(null);
                    KSImageLoader.loadImage(this.bg.bd, this.bg.be.getUrl(), this.bg.aK.mAdTemplate);
                }
            }
        };
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            com.kwad.sdk.core.response.model.b aL = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.bQ(this.aK.mAdTemplate));
            this.be = aL;
            if (TextUtils.isEmpty(aL.getUrl())) {
                return;
            }
            getRootView().post(this.bf);
            this.bd.setVisibility(0);
            this.aK.aL.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.bd = (ImageView) findViewById(R.id.obfuscated_res_0x7f091318);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            getRootView().removeCallbacks(this.bf);
            this.aK.aL.b(this.mVideoPlayStateListener);
        }
    }
}
