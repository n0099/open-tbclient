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
    public com.kwad.sdk.splashscreen.d f73779a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f73780b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73781c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f73782d;

    /* renamed from: e  reason: collision with root package name */
    public int f73783e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73784f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f73785g;

    /* renamed from: h  reason: collision with root package name */
    public long f73786h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73787i;

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
        this.f73787i = false;
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
            com.kwad.sdk.splashscreen.d dVar = this.f73779a;
            return dVar != null && dVar.b() && com.kwad.sdk.core.config.c.ai() > 0 && !an.a(com.kwad.sdk.core.config.c.ah());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this) {
                if (!this.f73787i && this.f73782d != null) {
                    if (this.f73782d.d()) {
                        com.kwad.sdk.core.report.a.c(this.f73779a.f73866d, 124, null);
                        this.f73787i = true;
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
            this.f73779a = dVar;
            this.f73781c = (TextView) dVar.f73867e.findViewById(R.id.ksad_splash_preload_tips);
            this.f73782d = (SkipView) this.f73779a.f73867e.findViewById(R.id.ksad_splash_skip_view);
            this.f73780b = new Handler(Looper.getMainLooper());
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f73779a.f73866d);
            int i3 = i2.adSplashInfo.imageDisplaySecond;
            this.f73782d.setTimerPrefixText(com.kwad.sdk.core.config.c.al());
            this.f73782d.setTimerSecond(i3);
            if (!com.kwad.sdk.core.response.b.a.F(i2)) {
                this.f73782d.a();
            }
            if (!this.f73779a.f73866d.adInfoList.isEmpty()) {
                this.f73785g = i2.adPreloadInfo;
                int i4 = i2.adSplashInfo.skipSecond;
                this.f73783e = i4;
                if (i4 == 5) {
                    this.f73783e = 0;
                }
            }
            this.f73781c.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.f73785g;
            if (adPreloadInfo == null || an.a(adPreloadInfo.preloadTips)) {
                this.f73781c.setVisibility(8);
            } else {
                this.f73781c.setVisibility(0);
                this.f73781c.setText(this.f73785g.preloadTips);
            }
            this.f73786h = SystemClock.elapsedRealtime();
            this.f73779a.f73871i.a(this);
            if (!this.f73779a.b() || an.a(com.kwad.sdk.core.config.c.ah())) {
                this.f73782d.setSkipText(com.kwad.sdk.core.response.b.a.ai(i2));
            } else {
                SkipView skipView = this.f73782d;
                skipView.setSkipText(com.kwad.sdk.core.config.c.ah() + " " + com.kwad.sdk.core.config.c.ai());
            }
            this.f73782d.setVisibility(4);
            this.f73782d.setOnViewListener(new SkipView.a(this) { // from class: com.kwad.sdk.splashscreen.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f73788a;

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
                    this.f73788a = this;
                }

                @Override // com.kwad.sdk.widget.SkipView.a
                public void a() {
                    String str;
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.splashscreen.d dVar2 = this.f73788a.f73779a;
                        if (dVar2.f73863a == null || dVar2.f73864b) {
                            str = null;
                        } else {
                            str = dVar2.d();
                            if (str != null) {
                                this.f73788a.f73779a.f73863a.onSkippedAd();
                                com.kwad.sdk.splashscreen.d dVar3 = this.f73788a.f73779a;
                                dVar3.f73864b = true;
                                dVar3.f73866d.mMiniWindowId = str;
                            }
                            com.kwad.sdk.splashscreen.b.a aVar = this.f73788a.f73779a.f73868f;
                            com.kwad.sdk.core.report.a.a(this.f73788a.f73779a.f73866d, 114, com.kwad.sdk.core.config.c.ai(), aVar != null ? (int) (aVar.c() / 1000) : 0);
                        }
                        if (str == null && this.f73788a.f73784f && (splashScreenAdInteractionListener = this.f73788a.f73779a.f73863a) != null) {
                            splashScreenAdInteractionListener.onSkippedAd();
                            JSONObject jSONObject = new JSONObject();
                            com.kwad.sdk.splashscreen.b.a aVar2 = this.f73788a.f73779a.f73868f;
                            if (aVar2 != null) {
                                try {
                                    jSONObject.put("duration", aVar2.c());
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                            com.kwad.sdk.core.report.a.a(this.f73788a.f73779a.f73866d, 1, jSONObject);
                        }
                    }
                }

                @Override // com.kwad.sdk.widget.SkipView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(this.f73788a.m(), this.f73788a.f73779a.f73866d, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.splashscreen.a.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f73789a;

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
                                this.f73789a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    com.kwad.sdk.core.report.a.a(this.f73789a.f73788a.f73779a.f73866d, 133, (v.a) null);
                                }
                            }
                        }, this.f73788a.f73779a.f73869g, false);
                    }
                }
            });
            a(this.f73782d, i2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f73779a.f73871i.b(this);
            Handler handler = this.f73780b;
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
            this.f73780b.removeCallbacksAndMessages(null);
            if (com.kwad.sdk.core.response.b.c.i(this.f73779a.f73866d).adSplashInfo.skipSecond == -1) {
                this.f73782d.c();
            } else if (this.f73783e < 0 || this.f73784f) {
            } else {
                this.f73780b.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f73790a;

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
                        this.f73790a = this;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f73790a.f73782d.b();
                            this.f73790a.o();
                            this.f73790a.f73783e = 0;
                            this.f73790a.f73784f = true;
                        }
                    }
                }, this.f73783e * 1000);
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
