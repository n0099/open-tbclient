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
/* loaded from: classes7.dex */
public class c extends Presenter implements com.kwad.sdk.core.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f39225a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f39226b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39227c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f39228d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f39229e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f39230f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39231g;

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
        this.f39227c = false;
        this.f39230f = new Handler(Looper.getMainLooper());
        this.f39231g = false;
    }

    private void a(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener imageLoadingListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, str, i2) == null) {
            if (i2 == 0) {
                this.f39228d.setVisibility(0);
                imageView = this.f39228d;
                adTemplate = this.f39225a.f39276c;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f39233a;

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
                        this.f39233a = this;
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
                            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f39233a.f39225a.f39274a;
                            if (splashScreenAdInteractionListener != null) {
                                splashScreenAdInteractionListener.onAdShowStart();
                            }
                            Bitmap bitmap = decodedResult.mBitmap;
                            if (bitmap == null || this.f39233a.o() == null) {
                                return;
                            }
                            Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.f39233a.f39229e.setVisibility(0);
                                this.f39233a.f39229e.setImageDrawable(new BitmapDrawable(this.f39233a.o().getResources(), KSImageLoader.blur(this.f39233a.o(), copy, 20)));
                            }
                        }
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view, failReason) == null) {
                            c cVar = this.f39233a;
                            if (cVar.f39225a.f39274a == null || cVar.f39231g) {
                                return;
                            }
                            this.f39233a.f39225a.f39274a.onAdShowError(0, "load image error");
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
                this.f39229e.setVisibility(0);
                imageView = this.f39229e;
                adTemplate = this.f39225a.f39276c;
                imageLoadingListener = new ImageLoadingListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f39234a;

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
                        this.f39234a = this;
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
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, view, decodedResult) == null) || (splashScreenAdInteractionListener = this.f39234a.f39225a.f39274a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowStart();
                    }

                    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str2, View view, FailReason failReason) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, str2, view, failReason) == null) {
                            c cVar = this.f39234a;
                            if (cVar.f39225a.f39274a == null || !cVar.f39231g) {
                                return;
                            }
                            this.f39234a.f39225a.f39274a.onAdShowError(0, "load image error");
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
            com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
            this.f39225a = cVar;
            this.f39229e = (ImageView) cVar.f39277d.findViewById(R.id.ksad_splash_background);
            this.f39228d = (ImageView) this.f39225a.f39277d.findViewById(R.id.ksad_splash_foreground);
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f39225a.f39276c);
            this.f39226b = j;
            String str = com.kwad.sdk.core.response.b.a.D(j).materialUrl;
            this.f39229e.setVisibility(0);
            this.f39225a.f39281h.a(this);
            AdInfo adInfo = this.f39226b;
            int i2 = adInfo.adSplashInfo.imageDisplaySecond;
            int i3 = com.kwad.sdk.core.response.b.a.D(adInfo).source;
            if (o() != null) {
                File a2 = SplashPreloadManager.b().a(this.f39226b.adPreloadInfo.preloadId);
                if (a2 != null && a2.exists() && a2.length() > 0) {
                    str = Uri.fromFile(a2).toString();
                }
                a(str, i3);
            }
            com.kwad.sdk.core.i.b bVar = this.f39225a.f39281h;
            if (bVar != null) {
                bVar.a(this);
            }
            this.f39230f.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f39232a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39232a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (splashScreenAdInteractionListener = this.f39232a.f39225a.f39274a) == null) {
                        return;
                    }
                    splashScreenAdInteractionListener.onAdShowEnd();
                }
            }, i2 * 1000);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            com.kwad.sdk.core.i.b bVar = this.f39225a.f39281h;
            if (bVar != null) {
                bVar.b(this);
            }
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f39227c) {
            return;
        }
        this.f39227c = true;
        com.kwad.sdk.core.report.b.a(this.f39225a.f39276c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            this.f39231g = true;
            this.f39230f.removeCallbacksAndMessages(null);
        }
    }
}
