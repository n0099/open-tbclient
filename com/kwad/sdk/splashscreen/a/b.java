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
/* loaded from: classes7.dex */
public class b extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f37353a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f37354b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37355c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37356d;

    /* renamed from: e  reason: collision with root package name */
    public int f37357e;

    /* renamed from: f  reason: collision with root package name */
    public int f37358f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37359g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f37360h;

    /* renamed from: i  reason: collision with root package name */
    public long f37361i;

    @SuppressLint({"SetTextI18n"})
    private void e() {
        this.f37357e = this.f37358f - (((int) (SystemClock.elapsedRealtime() - this.f37361i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f37353a = cVar;
        this.f37355c = (TextView) cVar.f37416d.findViewById(R.id.ksad_splash_preload_tips);
        this.f37356d = (TextView) this.f37353a.f37416d.findViewById(R.id.ksad_splash_skip_time);
        this.f37354b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37353a.f37415c);
        if (!this.f37353a.f37415c.adInfoList.isEmpty()) {
            this.f37360h = j.adPreloadInfo;
            int i2 = j.adSplashInfo.skipSecond;
            this.f37358f = i2;
            this.f37357e = i2;
        }
        this.f37355c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f37360h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f37355c.setVisibility(8);
        } else {
            this.f37355c.setVisibility(0);
            this.f37355c.setText(this.f37360h.preloadTips);
        }
        this.f37361i = SystemClock.elapsedRealtime();
        this.f37357e = this.f37358f;
        this.f37353a.f37420h.a(this);
        e();
        if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
            this.f37356d.setText("跳过");
        } else {
            this.f37356d.setText(j.adSplashInfo.skipTips);
        }
        this.f37356d.setVisibility(4);
        this.f37356d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f37359g && (splashScreenAdInteractionListener = b.this.f37353a.f37413a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f37353a.f37417e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f37353a.f37415c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f37353a.f37420h.b(this);
        Handler handler = this.f37354b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f37354b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.j(this.f37353a.f37415c).adSplashInfo.skipSecond == -1) {
            this.f37356d.setVisibility(8);
        } else if (this.f37357e < 0 || this.f37359g) {
        } else {
            this.f37354b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f37356d.setVisibility(0);
                    b.this.f37356d.setAlpha(0.0f);
                    b.this.f37356d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f37357e = 0;
                    b.this.f37359g = true;
                }
            }, this.f37357e * 1000);
        }
    }
}
