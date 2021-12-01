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
/* loaded from: classes2.dex */
public class c extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f59462b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59463c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f59464d;

    /* renamed from: e  reason: collision with root package name */
    public int f59465e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59466f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f59467g;

    /* renamed from: h  reason: collision with root package name */
    public long f59468h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f59469i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59470j;

    /* renamed from: k  reason: collision with root package name */
    public View f59471k;
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
        this.f59470j = false;
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
        if ((interceptable == null || interceptable.invokeZ(65541, this, z) == null) && a(this.f59469i)) {
            this.f59471k.setVisibility(z ? 0 : 8);
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
            if (gVar.a == null || gVar.f59575b) {
                str = null;
            } else {
                str = gVar.d();
                if (str != null) {
                    this.a.a.onSkippedAd();
                    com.kwad.sdk.splashscreen.g gVar2 = this.a;
                    gVar2.f59575b = true;
                    gVar2.f59577d.mMiniWindowId = str;
                }
                com.kwad.sdk.splashscreen.b.a aVar = this.a.f59579f;
                com.kwad.sdk.core.report.a.a(this.a.f59577d, 114, com.kwad.sdk.core.config.b.ao(), aVar != null ? (int) (aVar.c() / 1000) : 0);
            }
            if (str == null && this.f59466f && (splashScreenAdInteractionListener = this.a.a) != null) {
                splashScreenAdInteractionListener.onSkippedAd();
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f59579f;
                if (aVar2 != null) {
                    try {
                        jSONObject.put("duration", aVar2.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.a.a(this.a.f59577d, 1, jSONObject);
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
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && a(this.f59469i)) {
            this.f59464d.getViewTreeObserver().addOnGlobalLayoutListener(s());
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
                        ViewGroup.LayoutParams layoutParams = this.a.f59464d.getLayoutParams();
                        layoutParams.height = com.kwad.sdk.a.kwai.a.a(this.a.f59464d.getContext(), 35.0f);
                        int width = this.a.f59464d.getWidth();
                        this.a.f59464d.setLayoutParams(layoutParams);
                        ViewGroup.LayoutParams layoutParams2 = this.a.f59471k.getLayoutParams();
                        layoutParams2.width = width + com.kwad.sdk.a.kwai.a.a(this.a.f59464d.getContext(), 66.0f);
                        this.a.f59471k.setLayoutParams(layoutParams2);
                        if (this.a.l != null) {
                            this.a.f59464d.getViewTreeObserver().removeOnGlobalLayoutListener(this.a.l);
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
                if (!this.f59470j && this.f59464d != null) {
                    if (this.f59464d.f()) {
                        com.kwad.sdk.core.report.a.c(this.a.f59577d, 124, null);
                        this.f59470j = true;
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
            this.f59463c = (TextView) gVar.f59578e.findViewById(R.id.ksad_splash_preload_tips);
            this.f59464d = (SkipView) this.a.f59578e.findViewById(R.id.ksad_splash_skip_view);
            this.f59471k = this.a.f59578e.findViewById(R.id.ksad_skip_view_area);
            this.f59462b = new Handler(Looper.getMainLooper());
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f59577d);
            this.f59469i = j2;
            int i2 = j2.adSplashInfo.imageDisplaySecond;
            this.f59464d.setTimerPrefixText(com.kwad.sdk.core.config.b.at());
            this.f59464d.setTimerSecond(i2);
            if (!com.kwad.sdk.core.response.a.a.P(this.f59469i)) {
                this.f59464d.a();
            }
            if (!this.a.f59577d.adInfoList.isEmpty()) {
                AdInfo adInfo = this.f59469i;
                this.f59467g = adInfo.adPreloadInfo;
                AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
                int i3 = adSplashInfo.skipSecond;
                this.f59465e = i3;
                if (i3 == 5) {
                    this.f59465e = 0;
                }
                if (this.a.b()) {
                    adSplashInfo.skipSecond = 0;
                    this.f59465e = 0;
                }
            }
            this.f59463c.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.f59467g;
            if (adPreloadInfo == null || at.a(adPreloadInfo.preloadTips)) {
                this.f59463c.setVisibility(8);
            } else {
                this.f59463c.setVisibility(0);
                this.f59463c.setText(this.f59467g.preloadTips);
            }
            this.f59468h = SystemClock.elapsedRealtime();
            this.a.f59582i.a(this);
            if (!this.a.b() || at.a(com.kwad.sdk.core.config.b.am())) {
                this.f59464d.setSkipText(com.kwad.sdk.core.response.a.a.av(this.f59469i));
            } else {
                SkipView skipView = this.f59464d;
                skipView.setSkipText(com.kwad.sdk.core.config.b.am() + " " + com.kwad.sdk.core.config.b.ao());
            }
            this.f59464d.setVisibility(4);
            if (a(this.f59469i)) {
                this.f59471k.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.c.1
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
            this.f59464d.setOnViewListener(new SkipView.a(this) { // from class: com.kwad.sdk.splashscreen.a.c.2
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
            a(this.f59464d, this.f59469i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.a.f59582i.b(this);
            Handler handler = this.f59462b;
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
            this.f59462b.removeCallbacksAndMessages(null);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f59577d);
            if (j2.adSplashInfo.skipSecond == -1) {
                this.f59464d.e();
                a(false);
            } else if (this.f59465e >= 0 && !this.f59466f) {
                this.f59462b.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.c.3
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
                            this.a.f59464d.b();
                            this.a.a(true);
                            this.a.t();
                            this.a.f59465e = 0;
                            this.a.f59466f = true;
                        }
                    }
                }, this.f59465e * 1000);
            }
            if (!com.kwad.sdk.core.response.a.a.P(j2)) {
                this.f59464d.d();
            }
            r();
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageInvisible");
            if (com.kwad.sdk.core.response.a.a.P(this.f59469i)) {
                return;
            }
            this.f59464d.c();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59462b.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.c.5
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
                            this.a.f59462b.postDelayed(this, 1000L);
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
