package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends Presenter implements com.kwad.sdk.core.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f39214a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f39215b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f39216c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f39217d;

    /* renamed from: e  reason: collision with root package name */
    public int f39218e;

    /* renamed from: f  reason: collision with root package name */
    public int f39219f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39220g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f39221h;

    /* renamed from: i  reason: collision with root package name */
    public long f39222i;

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
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f39218e = this.f39219f - (((int) (SystemClock.elapsedRealtime() - this.f39222i)) / 1000);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
            com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
            this.f39214a = cVar;
            this.f39216c = (TextView) cVar.f39277d.findViewById(R.id.ksad_splash_preload_tips);
            this.f39217d = (TextView) this.f39214a.f39277d.findViewById(R.id.ksad_splash_skip_time);
            this.f39215b = new Handler(Looper.getMainLooper());
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f39214a.f39276c);
            if (!this.f39214a.f39276c.adInfoList.isEmpty()) {
                this.f39221h = j.adPreloadInfo;
                int i2 = j.adSplashInfo.skipSecond;
                this.f39219f = i2;
                this.f39218e = i2;
            }
            this.f39216c.setVisibility(8);
            AdInfo.AdPreloadInfo adPreloadInfo = this.f39221h;
            if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
                this.f39216c.setVisibility(8);
            } else {
                this.f39216c.setVisibility(0);
                this.f39216c.setText(this.f39221h.preloadTips);
            }
            this.f39222i = SystemClock.elapsedRealtime();
            this.f39218e = this.f39219f;
            this.f39214a.f39281h.a(this);
            e();
            if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
                this.f39217d.setText("跳过");
            } else {
                this.f39217d.setText(j.adSplashInfo.skipTips);
            }
            this.f39217d.setVisibility(4);
            this.f39217d.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f39223a;

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
                    this.f39223a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f39223a.f39220g && (splashScreenAdInteractionListener = this.f39223a.f39214a.f39274a) != null) {
                            splashScreenAdInteractionListener.onSkippedAd();
                        }
                        JSONObject jSONObject = new JSONObject();
                        com.kwad.sdk.splashscreen.b.a aVar = this.f39223a.f39214a.f39278e;
                        if (aVar != null) {
                            try {
                                jSONObject.put("duration", aVar.c());
                            } catch (JSONException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                            }
                        }
                        com.kwad.sdk.core.report.b.a(this.f39223a.f39214a.f39276c, 1, jSONObject);
                    }
                }
            });
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
            this.f39214a.f39281h.b(this);
            Handler handler = this.f39215b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
            this.f39215b.removeCallbacksAndMessages(null);
            if (com.kwad.sdk.core.response.b.c.j(this.f39214a.f39276c).adSplashInfo.skipSecond == -1) {
                this.f39217d.setVisibility(8);
            } else if (this.f39218e < 0 || this.f39220g) {
            } else {
                this.f39215b.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f39224a;

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
                        this.f39224a = this;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f39224a.f39217d.setVisibility(0);
                            this.f39224a.f39217d.setAlpha(0.0f);
                            this.f39224a.f39217d.animate().alpha(1.0f).setDuration(500L).start();
                            this.f39224a.f39218e = 0;
                            this.f39224a.f39220g = true;
                        }
                    }
                }, this.f39218e * 1000);
            }
        }
    }
}
