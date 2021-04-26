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
    public com.kwad.sdk.splashscreen.c f34748a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f34749b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34750c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34751d;

    /* renamed from: e  reason: collision with root package name */
    public int f34752e;

    /* renamed from: f  reason: collision with root package name */
    public int f34753f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34754g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f34755h;

    /* renamed from: i  reason: collision with root package name */
    public long f34756i;

    @SuppressLint({"SetTextI18n"})
    private void m() {
        this.f34752e = this.f34753f - (((int) (SystemClock.elapsedRealtime() - this.f34756i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f34748a = cVar;
        this.f34750c = (TextView) cVar.f34814d.findViewById(R.id.ksad_splash_preload_tips);
        this.f34751d = (TextView) this.f34748a.f34814d.findViewById(R.id.ksad_splash_skip_time);
        this.f34749b = new Handler(Looper.getMainLooper());
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f34748a.f34813c);
        if (!this.f34748a.f34813c.adInfoList.isEmpty()) {
            this.f34755h = g2.adPreloadInfo;
            int i2 = g2.adSplashInfo.skipSecond;
            this.f34753f = i2;
            this.f34752e = i2;
        }
        this.f34750c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f34755h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f34750c.setVisibility(8);
        } else {
            this.f34750c.setVisibility(0);
            this.f34750c.setText(this.f34755h.preloadTips);
        }
        this.f34756i = SystemClock.elapsedRealtime();
        this.f34752e = this.f34753f;
        this.f34748a.f34818h.a(this);
        m();
        if (TextUtils.isEmpty(g2.adSplashInfo.skipTips)) {
            this.f34751d.setText("跳过");
        } else {
            this.f34751d.setText(g2.adSplashInfo.skipTips);
        }
        this.f34751d.setVisibility(4);
        this.f34751d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f34754g && (splashScreenAdInteractionListener = b.this.f34748a.f34811a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f34748a.f34815e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.a());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f34748a.f34813c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f34749b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.g(this.f34748a.f34813c).adSplashInfo.skipSecond == -1) {
            this.f34751d.setVisibility(8);
        } else if (this.f34752e < 0 || this.f34754g) {
        } else {
            this.f34749b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f34751d.setVisibility(0);
                    b.this.f34751d.setAlpha(0.0f);
                    b.this.f34751d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f34752e = 0;
                    b.this.f34754g = true;
                }
            }, this.f34752e * 1000);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34748a.f34818h.b(this);
        Handler handler = this.f34749b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
    }
}
