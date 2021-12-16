package com.kwad.sdk.splashscreen.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f60056b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60057c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60058d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60059e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f60060f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60061g;

    public f() {
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
        this.f60057c = false;
        this.f60060f = new Handler(Looper.getMainLooper());
        this.f60061g = false;
    }

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, str, i2) == null) {
            if (i2 == 0) {
                this.f60058d.setVisibility(0);
                imageView = this.f60058d;
                adTemplate = this.a.f60158d;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                            return false;
                        }
                        return invokeLLL.booleanValue;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingCancelled(String str2, View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, view, decodedResult) == null) {
                            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.a.a.a;
                            if (splashScreenAdInteractionListener != null) {
                                splashScreenAdInteractionListener.onAdShowStart();
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || this.a.q() == null || Build.VERSION.SDK_INT < 17) {
                                return;
                            }
                            this.a.f60059e.setVisibility(0);
                            this.a.f60059e.setImageDrawable(new BitmapDrawable(this.a.q().getResources(), KSImageLoader.blur(this.a.q(), bitmap, 20)));
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view, failReason) == null) {
                            f fVar = this.a;
                            if (fVar.a.a == null || fVar.f60061g) {
                                return;
                            }
                            this.a.a.a.onAdShowError(0, "load image error");
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingStarted(String str2, View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str2, view) == null) {
                        }
                    }
                };
            } else {
                this.f60059e.setVisibility(0);
                imageView = this.f60059e;
                adTemplate = this.a.f60158d;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.sdk.splashscreen.a.f.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, str2, inputStream, decodedResult)) == null) {
                            return false;
                        }
                        return invokeLLL.booleanValue;
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingCancelled(String str2, View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, view) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, view, decodedResult) == null) || (splashScreenAdInteractionListener = this.a.a.a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowStart();
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view, failReason) == null) {
                            f fVar = this.a;
                            if (fVar.a.a == null || !fVar.f60061g) {
                                return;
                            }
                            this.a.a.a.onAdShowError(0, "load image error");
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingStarted(String str2, View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048580, this, str2, view) == null) {
                        }
                    }
                };
            }
            KSImageLoader.loadImage(imageView, str, adTemplate, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
            this.a = gVar;
            this.f60059e = (ImageView) gVar.f60159e.findViewById(R.id.ksad_splash_background);
            this.f60058d = (ImageView) this.a.f60159e.findViewById(R.id.ksad_splash_foreground);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f60158d);
            this.f60056b = j2;
            String str = com.kwad.sdk.core.response.a.a.I(j2).materialUrl;
            this.f60059e.setVisibility(0);
            this.a.f60163i.a(this);
            AdInfo adInfo = this.f60056b;
            int i2 = adInfo.adSplashInfo.imageDisplaySecond;
            int i3 = com.kwad.sdk.core.response.a.a.I(adInfo).source;
            if (q() != null) {
                File a = SplashPreloadManager.b().a(this.f60056b.adPreloadInfo.preloadId);
                if (a != null && a.exists() && a.length() > 0) {
                    str = Uri.fromFile(a).toString();
                }
                a(str, i3);
            }
            com.kwad.sdk.core.j.c cVar = this.a.f60163i;
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            com.kwad.sdk.core.j.c cVar = this.a.f60163i;
            if (cVar != null) {
                cVar.b(this);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d_();
            this.f60061g = true;
            this.f60060f.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f60057c) {
            return;
        }
        this.f60057c = true;
        com.kwad.sdk.core.report.a.a(this.a.f60158d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
