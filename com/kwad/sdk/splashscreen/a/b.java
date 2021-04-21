package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f36985a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f36986b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36987c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36988d;

    /* renamed from: e  reason: collision with root package name */
    public int f36989e;

    /* renamed from: f  reason: collision with root package name */
    public int f36990f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36991g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f36992h;
    public long i;

    @SuppressLint({"SetTextI18n"})
    private void e() {
        this.f36989e = this.f36990f - (((int) (SystemClock.elapsedRealtime() - this.i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f36985a = cVar;
        this.f36987c = (TextView) cVar.f37045d.findViewById(R.id.ksad_splash_preload_tips);
        this.f36988d = (TextView) this.f36985a.f37045d.findViewById(R.id.ksad_splash_skip_time);
        this.f36986b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36985a.f37044c);
        if (!this.f36985a.f37044c.adInfoList.isEmpty()) {
            this.f36992h = j.adPreloadInfo;
            int i = j.adSplashInfo.skipSecond;
            this.f36990f = i;
            this.f36989e = i;
        }
        this.f36987c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f36992h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f36987c.setVisibility(8);
        } else {
            this.f36987c.setVisibility(0);
            this.f36987c.setText(this.f36992h.preloadTips);
        }
        this.i = SystemClock.elapsedRealtime();
        this.f36989e = this.f36990f;
        this.f36985a.f37049h.a(this);
        e();
        if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
            this.f36988d.setText("跳过");
        } else {
            this.f36988d.setText(j.adSplashInfo.skipTips);
        }
        this.f36988d.setVisibility(4);
        this.f36988d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f36991g && (splashScreenAdInteractionListener = b.this.f36985a.f37042a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f36985a.f37046e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f36985a.f37044c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36985a.f37049h.b(this);
        Handler handler = this.f36986b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f36986b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.j(this.f36985a.f37044c).adSplashInfo.skipSecond == -1) {
            this.f36988d.setVisibility(8);
        } else if (this.f36989e < 0 || this.f36991g) {
        } else {
            this.f36986b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f36988d.setVisibility(0);
                    b.this.f36988d.setAlpha(0.0f);
                    b.this.f36988d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f36989e = 0;
                    b.this.f36991g = true;
                }
            }, this.f36989e * 1000);
        }
    }
}
