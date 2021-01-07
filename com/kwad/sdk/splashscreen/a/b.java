package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends Presenter implements com.kwad.sdk.core.i.c {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f11020a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f11021b;
    private TextView c;
    private TextView d;
    private int e;
    private int f;
    private boolean g;
    private AdInfo.AdPreloadInfo h;
    private long i;

    @SuppressLint({"SetTextI18n"})
    private void e() {
        this.e = this.f - (((int) (SystemClock.elapsedRealtime() - this.i)) / 1000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        this.f11020a = (com.kwad.sdk.splashscreen.c) n();
        this.c = (TextView) this.f11020a.d.findViewById(R.id.ksad_splash_preload_tips);
        this.d = (TextView) this.f11020a.d.findViewById(R.id.ksad_splash_skip_time);
        this.f11021b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f11020a.c);
        if (!this.f11020a.c.adInfoList.isEmpty()) {
            this.h = j.adPreloadInfo;
            this.f = j.adSplashInfo.skipSecond;
            this.e = this.f;
        }
        this.c.setVisibility(8);
        if (this.h == null || ag.a(this.h.preloadTips)) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setText(this.h.preloadTips);
        }
        this.i = SystemClock.elapsedRealtime();
        this.e = this.f;
        this.f11020a.h.a(this);
        e();
        if (TextUtils.isEmpty(j.adSplashInfo.skipTips)) {
            this.d.setText("跳过");
        } else {
            this.d.setText(j.adSplashInfo.skipTips);
        }
        this.d.setVisibility(4);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.g && b.this.f11020a.f11047a != null) {
                    b.this.f11020a.f11047a.onSkippedAd();
                }
                JSONObject jSONObject = new JSONObject();
                if (b.this.f11020a.e != null) {
                    try {
                        jSONObject.put("duration", b.this.f11020a.e.c());
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
                com.kwad.sdk.core.report.b.a(b.this.f11020a.c, 1, jSONObject);
            }
        });
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f11020a.h.b(this);
        if (this.f11021b != null) {
            this.f11021b.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f11021b.removeCallbacksAndMessages(null);
        if (com.kwad.sdk.core.response.b.c.j(this.f11020a.c).adSplashInfo.skipSecond == -1) {
            this.d.setVisibility(8);
        } else if (this.e < 0 || this.g) {
        } else {
            this.f11021b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.b.2
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    b.this.d.setVisibility(0);
                    b.this.d.setAlpha(0.0f);
                    b.this.d.animate().alpha(1.0f).setDuration(500L).start();
                    b.this.e = 0;
                    b.this.g = true;
                }
            }, this.e * 1000);
        }
    }
}
