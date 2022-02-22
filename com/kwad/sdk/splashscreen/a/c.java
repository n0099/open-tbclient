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
/* loaded from: classes4.dex */
public class c extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f57978b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57979c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f57980d;

    /* renamed from: e  reason: collision with root package name */
    public int f57981e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57982f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f57983g;

    /* renamed from: h  reason: collision with root package name */
    public long f57984h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f57985i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57986j = false;
    public View k;
    public ViewTreeObserver.OnGlobalLayoutListener l;

    private void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(i() ? false : com.kwad.sdk.core.response.a.a.aw(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (a(this.f57985i)) {
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
        if (gVar.a == null || gVar.f58085b) {
            str = null;
        } else {
            str = gVar.d();
            if (str != null) {
                this.a.a.onSkippedAd();
                com.kwad.sdk.splashscreen.g gVar2 = this.a;
                gVar2.f58085b = true;
                gVar2.f58087d.mMiniWindowId = str;
            }
            com.kwad.sdk.splashscreen.b.a aVar = this.a.f58089f;
            com.kwad.sdk.core.report.a.a(this.a.f58087d, 114, com.kwad.sdk.core.config.b.ao(), aVar != null ? (int) (aVar.c() / 1000) : 0);
        }
        if (str == null && this.f57982f && (splashScreenAdInteractionListener = this.a.a) != null) {
            splashScreenAdInteractionListener.onSkippedAd();
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f58089f;
            if (aVar2 != null) {
                try {
                    jSONObject.put("duration", aVar2.c());
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            com.kwad.sdk.core.report.a.a(this.a.f58087d, 1, jSONObject);
        }
    }

    private boolean i() {
        com.kwad.sdk.splashscreen.g gVar = this.a;
        return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
    }

    private void r() {
        if (a(this.f57985i)) {
            this.f57980d.getViewTreeObserver().addOnGlobalLayoutListener(s());
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener s() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.splashscreen.a.c.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = c.this.f57980d.getLayoutParams();
                layoutParams.height = com.kwad.sdk.a.kwai.a.a(c.this.f57980d.getContext(), 35.0f);
                int width = c.this.f57980d.getWidth();
                c.this.f57980d.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = c.this.k.getLayoutParams();
                layoutParams2.width = width + com.kwad.sdk.a.kwai.a.a(c.this.f57980d.getContext(), 66.0f);
                c.this.k.setLayoutParams(layoutParams2);
                if (c.this.l != null) {
                    c.this.f57980d.getViewTreeObserver().removeOnGlobalLayoutListener(c.this.l);
                }
            }
        };
        this.l = onGlobalLayoutListener;
        return onGlobalLayoutListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        if (!this.f57986j && this.f57980d != null) {
            if (this.f57980d.f()) {
                com.kwad.sdk.core.report.a.c(this.a.f58087d, 124, null);
                this.f57986j = true;
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
        this.f57979c = (TextView) gVar.f58088e.findViewById(R.id.ksad_splash_preload_tips);
        this.f57980d = (SkipView) this.a.f58088e.findViewById(R.id.ksad_splash_skip_view);
        this.k = this.a.f58088e.findViewById(R.id.ksad_skip_view_area);
        this.f57978b = new Handler(Looper.getMainLooper());
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f58087d);
        this.f57985i = j2;
        int i2 = j2.adSplashInfo.imageDisplaySecond;
        this.f57980d.setTimerPrefixText(com.kwad.sdk.core.config.b.at());
        this.f57980d.setTimerSecond(i2);
        if (!com.kwad.sdk.core.response.a.a.P(this.f57985i)) {
            this.f57980d.a();
        }
        if (!this.a.f58087d.adInfoList.isEmpty()) {
            AdInfo adInfo = this.f57985i;
            this.f57983g = adInfo.adPreloadInfo;
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            int i3 = adSplashInfo.skipSecond;
            this.f57981e = i3;
            if (i3 == 5) {
                this.f57981e = 0;
            }
            if (this.a.b()) {
                adSplashInfo.skipSecond = 0;
                this.f57981e = 0;
            }
        }
        this.f57979c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f57983g;
        if (adPreloadInfo == null || at.a(adPreloadInfo.preloadTips)) {
            this.f57979c.setVisibility(8);
        } else {
            this.f57979c.setVisibility(0);
            this.f57979c.setText(this.f57983g.preloadTips);
        }
        this.f57984h = SystemClock.elapsedRealtime();
        this.a.f58092i.a(this);
        if (!this.a.b() || at.a(com.kwad.sdk.core.config.b.am())) {
            this.f57980d.setSkipText(com.kwad.sdk.core.response.a.a.av(this.f57985i));
        } else {
            SkipView skipView = this.f57980d;
            skipView.setSkipText(com.kwad.sdk.core.config.b.am() + " " + com.kwad.sdk.core.config.b.ao());
        }
        this.f57980d.setVisibility(4);
        if (a(this.f57985i)) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.h();
                }
            });
        }
        this.f57980d.setOnViewListener(new SkipView.a() { // from class: com.kwad.sdk.splashscreen.a.c.2
            @Override // com.kwad.sdk.widget.SkipView.a
            public void a() {
                c.this.h();
            }

            @Override // com.kwad.sdk.widget.SkipView.a
            public void b() {
                c.this.g();
            }
        });
        a(this.f57980d, this.f57985i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.a.f58092i.b(this);
        Handler handler = this.f57978b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f57978b.removeCallbacksAndMessages(null);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f58087d);
        if (j2.adSplashInfo.skipSecond == -1) {
            this.f57980d.e();
            a(false);
        } else if (this.f57981e >= 0 && !this.f57982f) {
            this.f57978b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.3
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    c.this.f57980d.b();
                    c.this.a(true);
                    c.this.t();
                    c.this.f57981e = 0;
                    c.this.f57982f = true;
                }
            }, this.f57981e * 1000);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j2)) {
            this.f57980d.d();
        }
        r();
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageInvisible");
        if (com.kwad.sdk.core.response.a.a.P(this.f57985i)) {
            return;
        }
        this.f57980d.c();
    }

    public void g() {
        this.f57978b.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.kwad.sdk.core.download.kwai.b.a() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                    c.this.f57978b.postDelayed(this, 1000L);
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
