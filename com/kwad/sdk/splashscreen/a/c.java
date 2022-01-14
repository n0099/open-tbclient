package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f57766b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57767c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f57768d;

    /* renamed from: e  reason: collision with root package name */
    public int f57769e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57770f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f57771g;

    /* renamed from: h  reason: collision with root package name */
    public long f57772h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f57773i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57774j = false;
    public View k;
    public ViewTreeObserver.OnGlobalLayoutListener l;

    private void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(i() ? false : com.kwad.sdk.core.response.a.a.aw(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (a(this.f57773i)) {
            this.k.setVisibility(z ? 0 : 8);
        }
    }

    public static boolean a(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.splashCloseButtonNewStyleSwitch == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
        com.kwad.sdk.splashscreen.g gVar = this.a;
        if (gVar.a == null || gVar.f57873b) {
            str = null;
        } else {
            str = gVar.d();
            if (str != null) {
                this.a.a.onSkippedAd();
                com.kwad.sdk.splashscreen.g gVar2 = this.a;
                gVar2.f57873b = true;
                gVar2.f57875d.mMiniWindowId = str;
            }
            com.kwad.sdk.splashscreen.b.a aVar = this.a.f57877f;
            com.kwad.sdk.core.report.a.a(this.a.f57875d, 114, com.kwad.sdk.core.config.b.ao(), aVar != null ? (int) (aVar.c() / 1000) : 0);
        }
        if (str == null && this.f57770f && (splashScreenAdInteractionListener = this.a.a) != null) {
            splashScreenAdInteractionListener.onSkippedAd();
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f57877f;
            if (aVar2 != null) {
                try {
                    jSONObject.put("duration", aVar2.c());
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            com.kwad.sdk.core.report.a.a(this.a.f57875d, 1, jSONObject);
        }
    }

    private boolean i() {
        com.kwad.sdk.splashscreen.g gVar = this.a;
        return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
    }

    private void r() {
        if (a(this.f57773i)) {
            this.f57768d.getViewTreeObserver().addOnGlobalLayoutListener(s());
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener s() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.splashscreen.a.c.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = c.this.f57768d.getLayoutParams();
                layoutParams.height = com.kwad.sdk.a.kwai.a.a(c.this.f57768d.getContext(), 35.0f);
                int width = c.this.f57768d.getWidth();
                c.this.f57768d.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = c.this.k.getLayoutParams();
                layoutParams2.width = width + com.kwad.sdk.a.kwai.a.a(c.this.f57768d.getContext(), 66.0f);
                c.this.k.setLayoutParams(layoutParams2);
                if (c.this.l != null) {
                    c.this.f57768d.getViewTreeObserver().removeOnGlobalLayoutListener(c.this.l);
                }
            }
        };
        this.l = onGlobalLayoutListener;
        return onGlobalLayoutListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        if (!this.f57774j && this.f57768d != null) {
            if (this.f57768d.f()) {
                com.kwad.sdk.core.report.a.c(this.a.f57875d, 124, null);
                this.f57774j = true;
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onBind");
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.a = gVar;
        this.f57767c = (TextView) gVar.f57876e.findViewById(R.id.ksad_splash_preload_tips);
        this.f57768d = (SkipView) this.a.f57876e.findViewById(R.id.ksad_splash_skip_view);
        this.k = this.a.f57876e.findViewById(R.id.ksad_skip_view_area);
        this.f57766b = new Handler(Looper.getMainLooper());
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f57875d);
        this.f57773i = j2;
        int i2 = j2.adSplashInfo.imageDisplaySecond;
        this.f57768d.setTimerPrefixText(com.kwad.sdk.core.config.b.at());
        this.f57768d.setTimerSecond(i2);
        if (!com.kwad.sdk.core.response.a.a.P(this.f57773i)) {
            this.f57768d.a();
        }
        if (!this.a.f57875d.adInfoList.isEmpty()) {
            AdInfo adInfo = this.f57773i;
            this.f57771g = adInfo.adPreloadInfo;
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            int i3 = adSplashInfo.skipSecond;
            this.f57769e = i3;
            if (i3 == 5) {
                this.f57769e = 0;
            }
            if (this.a.b()) {
                adSplashInfo.skipSecond = 0;
                this.f57769e = 0;
            }
        }
        this.f57767c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f57771g;
        if (adPreloadInfo == null || at.a(adPreloadInfo.preloadTips)) {
            this.f57767c.setVisibility(8);
        } else {
            this.f57767c.setVisibility(0);
            this.f57767c.setText(this.f57771g.preloadTips);
        }
        this.f57772h = SystemClock.elapsedRealtime();
        this.a.f57880i.a(this);
        if (!this.a.b() || at.a(com.kwad.sdk.core.config.b.am())) {
            this.f57768d.setSkipText(com.kwad.sdk.core.response.a.a.av(this.f57773i));
        } else {
            SkipView skipView = this.f57768d;
            skipView.setSkipText(com.kwad.sdk.core.config.b.am() + " " + com.kwad.sdk.core.config.b.ao());
        }
        this.f57768d.setVisibility(4);
        if (a(this.f57773i)) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.h();
                }
            });
        }
        this.f57768d.setOnViewListener(new SkipView.a() { // from class: com.kwad.sdk.splashscreen.a.c.2
            @Override // com.kwad.sdk.widget.SkipView.a
            public void a() {
                c.this.h();
            }

            @Override // com.kwad.sdk.widget.SkipView.a
            public void b() {
                c.this.g();
            }
        });
        a(this.f57768d, this.f57773i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.a.f57880i.b(this);
        Handler handler = this.f57766b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f57766b.removeCallbacksAndMessages(null);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f57875d);
        if (j2.adSplashInfo.skipSecond == -1) {
            this.f57768d.e();
            a(false);
        } else if (this.f57769e >= 0 && !this.f57770f) {
            this.f57766b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.3
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    c.this.f57768d.b();
                    c.this.a(true);
                    c.this.t();
                    c.this.f57769e = 0;
                    c.this.f57770f = true;
                }
            }, this.f57769e * 1000);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            this.f57768d.d();
        }
        r();
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageInvisible");
        if (com.kwad.sdk.core.response.a.a.P(this.f57773i)) {
            return;
        }
        this.f57768d.c();
    }

    public void g() {
        this.f57766b.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.kwad.sdk.core.download.kwai.b.a() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                    c.this.f57766b.postDelayed(this, 1000L);
                    return;
                }
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = c.this.a.a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowEnd();
                }
            }
        });
    }
}
