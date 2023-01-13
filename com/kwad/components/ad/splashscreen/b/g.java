package com.kwad.components.ad.splashscreen.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class g extends e implements com.kwad.sdk.core.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public Handler mHandler;
    public boolean yG;
    public ImageView yH;
    public ImageView yI;
    public boolean yJ;

    public g() {
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
        this.yG = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.yJ = false;
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, imageView) == null) {
            this.yF.mRootContainer.setClipChildren(false);
            imageView.post(new Runnable(this, imageView) { // from class: com.kwad.components.ad.splashscreen.b.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g yK;
                public final /* synthetic */ ImageView yL;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.yK = this;
                    this.yL = imageView;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        float width = this.yL.getWidth() / 1080.0f;
                        float f = width * 2340.0f;
                        float height = this.yL.getHeight();
                        float f2 = (f - height) / 2.0f;
                        float f3 = f - (((width * 880.0f) * 1152.0f) / 880.0f);
                        float f4 = (f3 * 0.5589225f) - f2;
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.yL.getLayoutParams();
                        marginLayoutParams.topMargin = (int) (((f4 - ((0.44107744f * f3) - f2)) / 2.0f) - (height * 0.03f));
                        this.yL.setLayoutParams(marginLayoutParams);
                    }
                }
            });
        }
    }

    private void k(String str, int i) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, this, str, i) == null) {
            if (i == 0) {
                this.yH.setVisibility(0);
                imageView = this.yH;
                adTemplate = this.yF.mAdTemplate;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.components.ad.splashscreen.b.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g yK;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.yK = this;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                            return false;
                        }
                        return invokeLLL.booleanValue;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingCancelled(String str2, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view2) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, view2, decodedResult) == null) {
                            this.yK.yF.jE();
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || this.yK.getContext() == null || Build.VERSION.SDK_INT < 17) {
                                return;
                            }
                            this.yK.yI.setVisibility(0);
                            this.yK.yI.setImageDrawable(new BitmapDrawable(this.yK.getContext().getResources(), KSImageLoader.blur(this.yK.getContext(), bitmap, 20)));
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view2, failReason) == null) || this.yK.yJ) {
                            return;
                        }
                        this.yK.yF.e(0, "load image error");
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingStarted(String str2, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str2, view2) == null) {
                        }
                    }
                };
            } else {
                this.yI.setVisibility(0);
                if (com.kwad.components.ad.splashscreen.a.b.jS()) {
                    a(this.yI);
                }
                imageView = this.yI;
                adTemplate = this.yF.mAdTemplate;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.components.ad.splashscreen.b.g.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g yK;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.yK = this;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                            return false;
                        }
                        return invokeLLL.booleanValue;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingCancelled(String str2, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view2) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingComplete(String str2, View view2, DecodedResult decodedResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, view2, decodedResult) == null) {
                            this.yK.yF.jE();
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view2, failReason) == null) && this.yK.yJ) {
                            this.yK.yF.e(0, "load image error");
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingStarted(String str2, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str2, view2) == null) {
                        }
                    }
                };
            }
            KSImageLoader.loadImage(imageView, str, adTemplate, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.yG) {
            return;
        }
        this.yG = true;
        com.kwad.components.ad.splashscreen.local.c.V(getContext());
        com.kwad.components.core.m.c.ox().a(this.yF.mAdTemplate, null, null);
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            this.yI = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091291);
            this.yH = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091294);
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
            this.mAdInfo = bQ;
            String str = com.kwad.sdk.core.response.a.a.at(bQ).materialUrl;
            this.yI.setVisibility(0);
            this.yF.yd.a(this);
            int i = com.kwad.sdk.core.response.a.a.at(this.mAdInfo).source;
            if (getContext() != null) {
                SplashPreloadManager.qD();
                File aZ = SplashPreloadManager.aZ(this.mAdInfo.adPreloadInfo.preloadId);
                if (aZ != null && aZ.exists() && aZ.length() > 0) {
                    str = Uri.fromFile(aZ).toString();
                }
                k(str, i);
            }
            com.kwad.sdk.core.h.a aVar = this.yF.yd;
            if (aVar != null) {
                aVar.a(this);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.yJ = true;
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            com.kwad.sdk.core.h.a aVar = this.yF.yd;
            if (aVar != null) {
                aVar.b(this);
            }
        }
    }
}
