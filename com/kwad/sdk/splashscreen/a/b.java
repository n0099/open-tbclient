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
    public com.kwad.sdk.splashscreen.c f33993a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f33994b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33995c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33996d;

    /* renamed from: e  reason: collision with root package name */
    public int f33997e;

    /* renamed from: f  reason: collision with root package name */
    public int f33998f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33999g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f34000h;

    /* renamed from: i  reason: collision with root package name */
    public long f34001i;

    @SuppressLint({"SetTextI18n"})
    private void m() {
        this.f33997e = this.f33998f - (((int) (SystemClock.elapsedRealtime() - this.f34001i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f33993a = cVar;
        this.f33995c = (TextView) cVar.f34059d.findViewById(R.id.ksad_splash_preload_tips);
        this.f33996d = (TextView) this.f33993a.f34059d.findViewById(R.id.ksad_splash_skip_time);
        this.f33994b = new Handler(Looper.getMainLooper());
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33993a.f34058c);
        if (!this.f33993a.f34058c.adInfoList.isEmpty()) {
            this.f34000h = g2.adPreloadInfo;
            int i2 = g2.adSplashInfo.skipSecond;
            this.f33998f = i2;
            this.f33997e = i2;
        }
        this.f33995c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f34000h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f33995c.setVisibility(8);
        } else {
            this.f33995c.setVisibility(0);
            this.f33995c.setText(this.f34000h.preloadTips);
        }
        this.f34001i = SystemClock.elapsedRealtime();
        this.f33997e = this.f33998f;
        this.f33993a.f34063h.a(this);
        m();
        if (TextUtils.isEmpty(g2.adSplashInfo.skipTips)) {
            this.f33996d.setText("跳过");
        } else {
            this.f33996d.setText(g2.adSplashInfo.skipTips);
        }
        this.f33996d.setVisibility(4);
        this.f33996d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f33999g && (splashScreenAdInteractionListener = b.this.f33993a.f34056a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f33993a.f34060e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.a());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f33993a.f34058c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f33994b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.g(this.f33993a.f34058c).adSplashInfo.skipSecond == -1) {
            this.f33996d.setVisibility(8);
        } else if (this.f33997e < 0 || this.f33999g) {
        } else {
            this.f33994b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f33996d.setVisibility(0);
                    b.this.f33996d.setAlpha(0.0f);
                    b.this.f33996d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f33997e = 0;
                    b.this.f33999g = true;
                }
            }, this.f33997e * 1000);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33993a.f34063h.b(this);
        Handler handler = this.f33994b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
    }
}
