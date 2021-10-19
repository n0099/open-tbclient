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
import com.kwad.sdk.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f74145a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f74146b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74147c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f74148d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f74149e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f74150f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74151g;

    public c() {
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
        this.f74147c = false;
        this.f74150f = new Handler(Looper.getMainLooper());
        this.f74151g = false;
    }

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, str, i2) == null) {
            if (i2 == 0) {
                this.f74148d.setVisibility(0);
                imageView = this.f74148d;
                adTemplate = this.f74145a.f74220d;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f74153a;

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
                        this.f74153a = this;
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
                            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f74153a.f74145a.f74217a;
                            if (splashScreenAdInteractionListener != null) {
                                splashScreenAdInteractionListener.onAdShowStart();
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || this.f74153a.m() == null) {
                                return;
                            }
                            Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.f74153a.f74149e.setVisibility(0);
                                this.f74153a.f74149e.setImageDrawable(new BitmapDrawable(this.f74153a.m().getResources(), KSImageLoader.blur(this.f74153a.m(), copy, 20)));
                            }
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view, failReason) == null) {
                            c cVar = this.f74153a;
                            if (cVar.f74145a.f74217a == null || cVar.f74151g) {
                                return;
                            }
                            this.f74153a.f74145a.f74217a.onAdShowError(0, "load image error");
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
                this.f74149e.setVisibility(0);
                imageView = this.f74149e;
                adTemplate = this.f74145a.f74220d;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f74154a;

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
                        this.f74154a = this;
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
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, view, decodedResult) == null) || (splashScreenAdInteractionListener = this.f74154a.f74145a.f74217a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowStart();
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view, failReason) == null) {
                            c cVar = this.f74154a;
                            if (cVar.f74145a.f74217a == null || !cVar.f74151g) {
                                return;
                            }
                            this.f74154a.f74145a.f74217a.onAdShowError(0, "load image error");
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
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f74145a = dVar;
            this.f74149e = (ImageView) dVar.f74221e.findViewById(R.id.ksad_splash_background);
            this.f74148d = (ImageView) this.f74145a.f74221e.findViewById(R.id.ksad_splash_foreground);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f74145a.f74220d);
            this.f74146b = i2;
            String str = com.kwad.sdk.core.response.b.a.B(i2).materialUrl;
            this.f74149e.setVisibility(0);
            this.f74145a.f74225i.a(this);
            AdInfo adInfo = this.f74146b;
            int i3 = adInfo.adSplashInfo.imageDisplaySecond;
            int i4 = com.kwad.sdk.core.response.b.a.B(adInfo).source;
            if (m() != null) {
                File a2 = SplashPreloadManager.b().a(this.f74146b.adPreloadInfo.preloadId);
                if (a2 != null && a2.exists() && a2.length() > 0) {
                    str = Uri.fromFile(a2).toString();
                }
                a(str, i4);
            }
            com.kwad.sdk.core.j.c cVar = this.f74145a.f74225i;
            if (cVar != null) {
                cVar.a(this);
            }
            this.f74150f.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f74152a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f74152a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.sdk.core.download.a.b.a() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                            this.f74152a.f74150f.postDelayed(this, 1000L);
                            return;
                        }
                        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f74152a.f74145a.f74217a;
                        if (splashScreenAdInteractionListener != null) {
                            splashScreenAdInteractionListener.onAdShowEnd();
                        }
                    }
                }
            }, i3 * 1000);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            com.kwad.sdk.core.j.c cVar = this.f74145a.f74225i;
            if (cVar != null) {
                cVar.b(this);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f74151g = true;
            this.f74150f.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f74147c) {
            return;
        }
        this.f74147c = true;
        com.kwad.sdk.core.report.a.a(this.f74145a.f74220d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
