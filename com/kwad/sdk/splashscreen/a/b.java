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
    public com.kwad.sdk.splashscreen.c f36601a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f36602b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36603c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36604d;

    /* renamed from: e  reason: collision with root package name */
    public int f36605e;

    /* renamed from: f  reason: collision with root package name */
    public int f36606f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36607g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f36608h;
    public long i;

    @SuppressLint({"SetTextI18n"})
    private void e() {
        this.f36605e = this.f36606f - (((int) (SystemClock.elapsedRealtime() - this.i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f36601a = cVar;
        this.f36603c = (TextView) cVar.f36661d.findViewById(R.id.ksad_splash_preload_tips);
        this.f36604d = (TextView) this.f36601a.f36661d.findViewById(R.id.ksad_splash_skip_time);
        this.f36602b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36601a.f36660c);
        if (!this.f36601a.f36660c.adInfoList.isEmpty()) {
            this.f36608h = j.adPreloadInfo;
            int i = j.adSplashInfo.skipSecond;
            this.f36606f = i;
            this.f36605e = i;
        }
        this.f36603c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f36608h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f36603c.setVisibility(8);
        } else {
            this.f36603c.setVisibility(0);
            this.f36603c.setText(this.f36608h.preloadTips);
        }
        this.i = SystemClock.elapsedRealtime();
        this.f36605e = this.f36606f;
        this.f36601a.f36665h.a(this);
        e();
        if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
            this.f36604d.setText("跳过");
        } else {
            this.f36604d.setText(j.adSplashInfo.skipTips);
        }
        this.f36604d.setVisibility(4);
        this.f36604d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f36607g && (splashScreenAdInteractionListener = b.this.f36601a.f36658a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f36601a.f36662e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f36601a.f36660c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36601a.f36665h.b(this);
        Handler handler = this.f36602b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f36602b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.j(this.f36601a.f36660c).adSplashInfo.skipSecond == -1) {
            this.f36604d.setVisibility(8);
        } else if (this.f36605e < 0 || this.f36607g) {
        } else {
            this.f36602b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f36604d.setVisibility(0);
                    b.this.f36604d.setAlpha(0.0f);
                    b.this.f36604d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f36605e = 0;
                    b.this.f36607g = true;
                }
            }, this.f36605e * 1000);
        }
    }
}
