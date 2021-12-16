package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f60043b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60044c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f60045d;

    /* renamed from: e  reason: collision with root package name */
    public int f60046e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60047f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f60048g;

    /* renamed from: h  reason: collision with root package name */
    public long f60049h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f60050i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f60051j;

    /* renamed from: k  reason: collision with root package name */
    public View f60052k;
    public ViewTreeObserver.OnGlobalLayoutListener l;

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
        this.f60051j = false;
    }

    private void a(SkipView skipView, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, skipView, adInfo) == null) {
            skipView.setTimerBtnVisible(i() ? false : com.kwad.sdk.core.response.a.a.aw(adInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65541, this, z) == null) && a(this.f60050i)) {
            this.f60052k.setVisibility(z ? 0 : 8);
        }
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adInfo)) == null) {
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            return adSplashInfo != null && adSplashInfo.splashCloseButtonNewStyleSwitch == 1;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwad.sdk.splashscreen.g gVar = this.a;
            if (gVar.a == null || gVar.f60156b) {
                str = null;
            } else {
                str = gVar.d();
                if (str != null) {
                    this.a.a.onSkippedAd();
                    com.kwad.sdk.splashscreen.g gVar2 = this.a;
                    gVar2.f60156b = true;
                    gVar2.f60158d.mMiniWindowId = str;
                }
                com.kwad.sdk.splashscreen.b.a aVar = this.a.f60160f;
                com.kwad.sdk.core.report.a.a(this.a.f60158d, 114, com.kwad.sdk.core.config.b.ao(), aVar != null ? (int) (aVar.c() / 1000) : 0);
            }
            if (str == null && this.f60047f && (splashScreenAdInteractionListener = this.a.a) != null) {
                splashScreenAdInteractionListener.onSkippedAd();
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f60160f;
                if (aVar2 != null) {
                    try {
                        jSONObject.put("duration", aVar2.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.a.a(this.a.f60158d, 1, jSONObject);
            }
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.g gVar = this.a;
            return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
        }
        return invokeV.booleanValue;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && a(this.f60050i)) {
            this.f60045d.getViewTreeObserver().addOnGlobalLayoutListener(s());
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ViewGroup.LayoutParams layoutParams = this.a.f60045d.getLayoutParams();
                        layoutParams.height = com.kwad.sdk.a.kwai.a.a(this.a.f60045d.getContext(), 35.0f);
                        int width = this.a.f60045d.getWidth();
                        this.a.f60045d.setLayoutParams(layoutParams);
                        ViewGroup.LayoutParams layoutParams2 = this.a.f60052k.getLayoutParams();
                        layoutParams2.width = width + com.kwad.sdk.a.kwai.a.a(this.a.f60045d.getContext(), 66.0f);
                        this.a.f60052k.setLayoutParams(layoutParams2);
                        if (this.a.l != null) {
                            this.a.f60045d.getViewTreeObserver().removeOnGlobalLayoutListener(this.a.l);
                        }
                    }
                }
            };
            this.l = onGlobalLayoutListener;
            return onGlobalLayoutListener;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            synchronized (this) {
                if (!this.f60051j && this.f60045d != null) {
                    if (this.f60045d.f()) {
                        com.kwad.sdk.core.report.a.c(this.a.f60158d, 124, null);
                        this.f60051j = true;
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
            com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
            this.a = gVar;
            this.f60044c = (TextView) gVar.f60159e.findViewById(R.id.ksad_splash_preload_tips);
            this.f60045d = (SkipView) this.a.f60159e.findViewById(R.id.ksad_splash_skip_view);
            this.f60052k = this.a.f60159e.findViewById(R.id.ksad_skip_view_area);
            this.f60043b = new Handler(Looper.getMainLooper());
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f60158d);
            this.f60050i = j2;
            int i2 = j2.adSplashInfo.imageDisplaySecond;
            this.f60045d.setTimerPrefixText(com.kwad.sdk.core.config.b.at());
            this.f60045d.setTimerSecond(i2);
            if (!com.kwad.sdk.core.response.a.a.P(this.f60050i)) {
                this.f60045d.a();
            }
            if (!this.a.f60158d.adInfoList.isEmpty()) {
                AdInfo adInfo = this.f60050i;
                this.f60048g = adInfo.adPreloadInfo;
                AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
                int i3 = adSplashInfo.skipSecond;
                this.f60046e = i3;
                if (i3 == 5) {
                    this.f60046e = 0;
                }
                if (this.a.b()) {
                    adSplashInfo.skipSecond = 0;
                    this.f60046e = 0;
                }
            }
            this.f60044c.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.f60048g;
            if (adPreloadInfo == null || at.a(adPreloadInfo.preloadTips)) {
                this.f60044c.setVisibility(8);
            } else {
                this.f60044c.setVisibility(0);
                this.f60044c.setText(this.f60048g.preloadTips);
            }
            this.f60049h = SystemClock.elapsedRealtime();
            this.a.f60163i.a(this);
            if (!this.a.b() || at.a(com.kwad.sdk.core.config.b.am())) {
                this.f60045d.setSkipText(com.kwad.sdk.core.response.a.a.av(this.f60050i));
            } else {
                SkipView skipView = this.f60045d;
                skipView.setSkipText(com.kwad.sdk.core.config.b.am() + " " + com.kwad.sdk.core.config.b.ao());
            }
            this.f60045d.setVisibility(4);
            if (a(this.f60050i)) {
                this.f60052k.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.h();
                        }
                    }
                });
            }
            this.f60045d.setOnViewListener(new SkipView.a(this) { // from class: com.kwad.sdk.splashscreen.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.widget.SkipView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.h();
                    }
                }

                @Override // com.kwad.sdk.widget.SkipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.a.g();
                    }
                }
            });
            a(this.f60045d, this.f60050i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.a.f60163i.b(this);
            Handler handler = this.f60043b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
            this.f60043b.removeCallbacksAndMessages(null);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f60158d);
            if (j2.adSplashInfo.skipSecond == -1) {
                this.f60045d.e();
                a(false);
            } else if (this.f60046e >= 0 && !this.f60047f) {
                this.f60043b.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f60045d.b();
                            this.a.a(true);
                            this.a.t();
                            this.a.f60046e = 0;
                            this.a.f60047f = true;
                        }
                    }
                }, this.f60046e * 1000);
            }
            if (!com.kwad.sdk.core.response.a.a.P(j2)) {
                this.f60045d.d();
            }
            r();
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageInvisible");
            if (com.kwad.sdk.core.response.a.a.P(this.f60050i)) {
                return;
            }
            this.f60045d.c();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f60043b.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.kwad.sdk.core.download.kwai.b.a() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                            this.a.f60043b.postDelayed(this, 1000L);
                            return;
                        }
                        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.a.a.a;
                        if (splashScreenAdInteractionListener != null) {
                            splashScreenAdInteractionListener.onAdShowEnd();
                        }
                    }
                }
            });
        }
    }
}
