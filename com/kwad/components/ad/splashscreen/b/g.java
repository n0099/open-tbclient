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
import com.kwad.components.ad.splashscreen.preload.SplashPreloadManager;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class g extends e implements com.kwad.sdk.core.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo b;
    public boolean c;
    public ImageView d;
    public ImageView e;
    public Handler f;
    public boolean g;

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
        this.c = false;
        this.f = new Handler(Looper.getMainLooper());
        this.g = false;
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, imageView) == null) {
            ((e) this).a.d.setClipChildren(false);
            imageView.post(new Runnable(this, imageView) { // from class: com.kwad.components.ad.splashscreen.b.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageView a;
                public final /* synthetic */ g b;

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
                    this.b = this;
                    this.a = imageView;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        float width = this.a.getWidth() / 1080.0f;
                        float f = width * 2340.0f;
                        float height = this.a.getHeight();
                        float f2 = (f - height) / 2.0f;
                        float f3 = f - (((width * 880.0f) * 1152.0f) / 880.0f);
                        float f4 = (f3 * 0.5589225f) - f2;
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
                        marginLayoutParams.topMargin = (int) (((f4 - ((0.44107744f * f3) - f2)) / 2.0f) - (height * 0.03f));
                        this.a.setLayoutParams(marginLayoutParams);
                    }
                }
            });
        }
    }

    private void a(String str, int i) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, str, i) == null) {
            if (i == 0) {
                this.d.setVisibility(0);
                imageView = this.d;
                adTemplate = ((e) this).a.c;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.components.ad.splashscreen.b.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g a;

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
                        this.a = this;
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
                            ((e) this.a).a.f();
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || this.a.u() == null || Build.VERSION.SDK_INT < 17) {
                                return;
                            }
                            this.a.e.setVisibility(0);
                            this.a.e.setImageDrawable(new BitmapDrawable(this.a.u().getResources(), KSImageLoader.blur(this.a.u(), bitmap, 20)));
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view2, failReason) == null) || this.a.g) {
                            return;
                        }
                        ((e) this.a).a.a(0, "load image error");
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingStarted(String str2, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str2, view2) == null) {
                        }
                    }
                };
            } else {
                this.e.setVisibility(0);
                if (com.kwad.components.ad.splashscreen.a.b.j()) {
                    a(this.e);
                }
                imageView = this.e;
                adTemplate = ((e) this).a.c;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.components.ad.splashscreen.b.g.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g a;

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
                        this.a = this;
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
                            ((e) this.a).a.f();
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public final void onLoadingFailed(String str2, View view2, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view2, failReason) == null) && this.a.g) {
                            ((e) this.a).a.a(0, "load image error");
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

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.e = (ImageView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911a3);
            this.d = (ImageView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911a6);
            AdInfo i = com.kwad.sdk.core.response.a.d.i(((e) this).a.c);
            this.b = i;
            String str = com.kwad.sdk.core.response.a.a.P(i).materialUrl;
            this.e.setVisibility(0);
            ((e) this).a.h.a(this);
            int i2 = com.kwad.sdk.core.response.a.a.P(this.b).source;
            if (u() != null) {
                SplashPreloadManager.a();
                File a = SplashPreloadManager.a(this.b.adPreloadInfo.preloadId);
                if (a != null && a.exists() && a.length() > 0) {
                    str = Uri.fromFile(a).toString();
                }
                a(str, i2);
            }
            com.kwad.sdk.core.g.a aVar = ((e) this).a.h;
            if (aVar != null) {
                aVar.a(this);
            }
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e_();
            this.g = true;
            this.f.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            com.kwad.sdk.core.g.a aVar = ((e) this).a.h;
            if (aVar != null) {
                aVar.b(this);
            }
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void m_() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.c) {
            return;
        }
        this.c = true;
        com.kwad.components.ad.splashscreen.local.c.a(u());
        com.kwad.components.core.l.c.a().a(((e) this).a.c, null, null);
    }
}
