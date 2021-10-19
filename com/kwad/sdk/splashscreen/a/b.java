package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f74133a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f74134b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74135c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f74136d;

    /* renamed from: e  reason: collision with root package name */
    public int f74137e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f74138f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f74139g;

    /* renamed from: h  reason: collision with root package name */
    public long f74140h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f74141i;

    public b() {
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
        this.f74141i = false;
    }

    private void a(SkipView skipView, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, skipView, adInfo) == null) {
            skipView.setTimerBtnVisible(n() ? false : com.kwad.sdk.core.response.b.a.aj(adInfo));
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f74133a;
            return dVar != null && dVar.b() && com.kwad.sdk.core.config.c.ai() > 0 && !an.a(com.kwad.sdk.core.config.c.ah());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this) {
                if (!this.f74141i && this.f74136d != null) {
                    if (this.f74136d.d()) {
                        com.kwad.sdk.core.report.a.c(this.f74133a.f74220d, 124, null);
                        this.f74141i = true;
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
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f74133a = dVar;
            this.f74135c = (TextView) dVar.f74221e.findViewById(R.id.ksad_splash_preload_tips);
            this.f74136d = (SkipView) this.f74133a.f74221e.findViewById(R.id.ksad_splash_skip_view);
            this.f74134b = new Handler(Looper.getMainLooper());
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f74133a.f74220d);
            int i3 = i2.adSplashInfo.imageDisplaySecond;
            this.f74136d.setTimerPrefixText(com.kwad.sdk.core.config.c.al());
            this.f74136d.setTimerSecond(i3);
            if (!com.kwad.sdk.core.response.b.a.F(i2)) {
                this.f74136d.a();
            }
            if (!this.f74133a.f74220d.adInfoList.isEmpty()) {
                this.f74139g = i2.adPreloadInfo;
                int i4 = i2.adSplashInfo.skipSecond;
                this.f74137e = i4;
                if (i4 == 5) {
                    this.f74137e = 0;
                }
            }
            this.f74135c.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.f74139g;
            if (adPreloadInfo == null || an.a(adPreloadInfo.preloadTips)) {
                this.f74135c.setVisibility(8);
            } else {
                this.f74135c.setVisibility(0);
                this.f74135c.setText(this.f74139g.preloadTips);
            }
            this.f74140h = SystemClock.elapsedRealtime();
            this.f74133a.f74225i.a(this);
            if (!this.f74133a.b() || an.a(com.kwad.sdk.core.config.c.ah())) {
                this.f74136d.setSkipText(com.kwad.sdk.core.response.b.a.ai(i2));
            } else {
                SkipView skipView = this.f74136d;
                skipView.setSkipText(com.kwad.sdk.core.config.c.ah() + " " + com.kwad.sdk.core.config.c.ai());
            }
            this.f74136d.setVisibility(4);
            this.f74136d.setOnViewListener(new SkipView.a(this) { // from class: com.kwad.sdk.splashscreen.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f74142a;

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
                    this.f74142a = this;
                }

                @Override // com.kwad.sdk.widget.SkipView.a
                public void a() {
                    String str;
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.splashscreen.d dVar2 = this.f74142a.f74133a;
                        if (dVar2.f74217a == null || dVar2.f74218b) {
                            str = null;
                        } else {
                            str = dVar2.d();
                            if (str != null) {
                                this.f74142a.f74133a.f74217a.onSkippedAd();
                                com.kwad.sdk.splashscreen.d dVar3 = this.f74142a.f74133a;
                                dVar3.f74218b = true;
                                dVar3.f74220d.mMiniWindowId = str;
                            }
                            com.kwad.sdk.splashscreen.b.a aVar = this.f74142a.f74133a.f74222f;
                            com.kwad.sdk.core.report.a.a(this.f74142a.f74133a.f74220d, 114, com.kwad.sdk.core.config.c.ai(), aVar != null ? (int) (aVar.c() / 1000) : 0);
                        }
                        if (str == null && this.f74142a.f74138f && (splashScreenAdInteractionListener = this.f74142a.f74133a.f74217a) != null) {
                            splashScreenAdInteractionListener.onSkippedAd();
                            JSONObject jSONObject = new JSONObject();
                            com.kwad.sdk.splashscreen.b.a aVar2 = this.f74142a.f74133a.f74222f;
                            if (aVar2 != null) {
                                try {
                                    jSONObject.put("duration", aVar2.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                            com.kwad.sdk.core.report.a.a(this.f74142a.f74133a.f74220d, 1, jSONObject);
                        }
                    }
                }

                @Override // com.kwad.sdk.widget.SkipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(this.f74142a.m(), this.f74142a.f74133a.f74220d, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.splashscreen.a.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f74143a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f74143a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.report.a.a(this.f74143a.f74142a.f74133a.f74220d, 133, (v.a) null);
                                }
                            }
                        }, this.f74142a.f74133a.f74223g, false);
                    }
                }
            });
            a(this.f74136d, i2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f74133a.f74225i.b(this);
            Handler handler = this.f74134b;
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
            this.f74134b.removeCallbacksAndMessages(null);
            if (com.kwad.sdk.core.response.b.c.i(this.f74133a.f74220d).adSplashInfo.skipSecond == -1) {
                this.f74136d.c();
            } else if (this.f74137e < 0 || this.f74138f) {
            } else {
                this.f74134b.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f74144a;

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
                        this.f74144a = this;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f74144a.f74136d.b();
                            this.f74144a.o();
                            this.f74144a.f74137e = 0;
                            this.f74144a.f74138f = true;
                        }
                    }
                }, this.f74137e * 1000);
            }
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
