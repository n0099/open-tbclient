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
    public com.kwad.sdk.splashscreen.c f33922a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f33923b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33924c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33925d;

    /* renamed from: e  reason: collision with root package name */
    public int f33926e;

    /* renamed from: f  reason: collision with root package name */
    public int f33927f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33928g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f33929h;

    /* renamed from: i  reason: collision with root package name */
    public long f33930i;

    @SuppressLint({"SetTextI18n"})
    private void m() {
        this.f33926e = this.f33927f - (((int) (SystemClock.elapsedRealtime() - this.f33930i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f33922a = cVar;
        this.f33924c = (TextView) cVar.f33988d.findViewById(R.id.ksad_splash_preload_tips);
        this.f33925d = (TextView) this.f33922a.f33988d.findViewById(R.id.ksad_splash_skip_time);
        this.f33923b = new Handler(Looper.getMainLooper());
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33922a.f33987c);
        if (!this.f33922a.f33987c.adInfoList.isEmpty()) {
            this.f33929h = g2.adPreloadInfo;
            int i2 = g2.adSplashInfo.skipSecond;
            this.f33927f = i2;
            this.f33926e = i2;
        }
        this.f33924c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f33929h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f33924c.setVisibility(8);
        } else {
            this.f33924c.setVisibility(0);
            this.f33924c.setText(this.f33929h.preloadTips);
        }
        this.f33930i = SystemClock.elapsedRealtime();
        this.f33926e = this.f33927f;
        this.f33922a.f33992h.a(this);
        m();
        if (TextUtils.isEmpty(g2.adSplashInfo.skipTips)) {
            this.f33925d.setText("跳过");
        } else {
            this.f33925d.setText(g2.adSplashInfo.skipTips);
        }
        this.f33925d.setVisibility(4);
        this.f33925d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f33928g && (splashScreenAdInteractionListener = b.this.f33922a.f33985a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f33922a.f33989e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.a());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f33922a.f33987c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f33923b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.g(this.f33922a.f33987c).adSplashInfo.skipSecond == -1) {
            this.f33925d.setVisibility(8);
        } else if (this.f33926e < 0 || this.f33928g) {
        } else {
            this.f33923b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f33925d.setVisibility(0);
                    b.this.f33925d.setAlpha(0.0f);
                    b.this.f33925d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f33926e = 0;
                    b.this.f33928g = true;
                }
            }, this.f33926e * 1000);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33922a.f33992h.b(this);
        Handler handler = this.f33923b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
    }
}
