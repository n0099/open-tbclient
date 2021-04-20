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
    public com.kwad.sdk.splashscreen.c f36890a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f36891b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36892c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36893d;

    /* renamed from: e  reason: collision with root package name */
    public int f36894e;

    /* renamed from: f  reason: collision with root package name */
    public int f36895f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36896g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f36897h;
    public long i;

    @SuppressLint({"SetTextI18n"})
    private void e() {
        this.f36894e = this.f36895f - (((int) (SystemClock.elapsedRealtime() - this.i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f36890a = cVar;
        this.f36892c = (TextView) cVar.f36950d.findViewById(R.id.ksad_splash_preload_tips);
        this.f36893d = (TextView) this.f36890a.f36950d.findViewById(R.id.ksad_splash_skip_time);
        this.f36891b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36890a.f36949c);
        if (!this.f36890a.f36949c.adInfoList.isEmpty()) {
            this.f36897h = j.adPreloadInfo;
            int i = j.adSplashInfo.skipSecond;
            this.f36895f = i;
            this.f36894e = i;
        }
        this.f36892c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f36897h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f36892c.setVisibility(8);
        } else {
            this.f36892c.setVisibility(0);
            this.f36892c.setText(this.f36897h.preloadTips);
        }
        this.i = SystemClock.elapsedRealtime();
        this.f36894e = this.f36895f;
        this.f36890a.f36954h.a(this);
        e();
        if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
            this.f36893d.setText("跳过");
        } else {
            this.f36893d.setText(j.adSplashInfo.skipTips);
        }
        this.f36893d.setVisibility(4);
        this.f36893d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f36896g && (splashScreenAdInteractionListener = b.this.f36890a.f36947a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f36890a.f36951e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f36890a.f36949c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36890a.f36954h.b(this);
        Handler handler = this.f36891b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f36891b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.j(this.f36890a.f36949c).adSplashInfo.skipSecond == -1) {
            this.f36893d.setVisibility(8);
        } else if (this.f36894e < 0 || this.f36896g) {
        } else {
            this.f36891b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f36893d.setVisibility(0);
                    b.this.f36893d.setAlpha(0.0f);
                    b.this.f36893d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f36894e = 0;
                    b.this.f36896g = true;
                }
            }, this.f36894e * 1000);
        }
    }
}
