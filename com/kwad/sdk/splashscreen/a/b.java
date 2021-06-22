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
    public com.kwad.sdk.splashscreen.c f37451a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f37452b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37453c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37454d;

    /* renamed from: e  reason: collision with root package name */
    public int f37455e;

    /* renamed from: f  reason: collision with root package name */
    public int f37456f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37457g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f37458h;

    /* renamed from: i  reason: collision with root package name */
    public long f37459i;

    @SuppressLint({"SetTextI18n"})
    private void e() {
        this.f37455e = this.f37456f - (((int) (SystemClock.elapsedRealtime() - this.f37459i)) / 1000);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f37451a = cVar;
        this.f37453c = (TextView) cVar.f37514d.findViewById(R.id.ksad_splash_preload_tips);
        this.f37454d = (TextView) this.f37451a.f37514d.findViewById(R.id.ksad_splash_skip_time);
        this.f37452b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f37451a.f37513c);
        if (!this.f37451a.f37513c.adInfoList.isEmpty()) {
            this.f37458h = j.adPreloadInfo;
            int i2 = j.adSplashInfo.skipSecond;
            this.f37456f = i2;
            this.f37455e = i2;
        }
        this.f37453c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f37458h;
        if (adPreloadInfo == null || ag.a(adPreloadInfo.preloadTips)) {
            this.f37453c.setVisibility(8);
        } else {
            this.f37453c.setVisibility(0);
            this.f37453c.setText(this.f37458h.preloadTips);
        }
        this.f37459i = SystemClock.elapsedRealtime();
        this.f37455e = this.f37456f;
        this.f37451a.f37518h.a(this);
        e();
        if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
            this.f37454d.setText("跳过");
        } else {
            this.f37454d.setText(j.adSplashInfo.skipTips);
        }
        this.f37454d.setVisibility(4);
        this.f37454d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                if (b.this.f37457g && (splashScreenAdInteractionListener = b.this.f37451a.f37511a) != null) {
                    splashScreenAdInteractionListener.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.splashscreen.b.a aVar = b.this.f37451a.f37515e;
                if (aVar != null) {
                    try {
                        jSONObject.put("duration", aVar.c());
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f37451a.f37513c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f37451a.f37518h.b(this);
        Handler handler = this.f37452b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f37452b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.j(this.f37451a.f37513c).adSplashInfo.skipSecond == -1) {
            this.f37454d.setVisibility(8);
        } else if (this.f37455e < 0 || this.f37457g) {
        } else {
            this.f37452b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.f37454d.setVisibility(0);
                    b.this.f37454d.setAlpha(0.0f);
                    b.this.f37454d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.f37455e = 0;
                    b.this.f37457g = true;
                }
            }, this.f37455e * 1000);
        }
    }
}
