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
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends Presenter implements com.kwad.sdk.core.j.d {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f41236b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41237c;

    /* renamed from: d  reason: collision with root package name */
    public SkipView f41238d;

    /* renamed from: e  reason: collision with root package name */
    public int f41239e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41240f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo.AdPreloadInfo f41241g;

    /* renamed from: h  reason: collision with root package name */
    public long f41242h;
    public AdInfo i;
    public boolean j = false;
    public View k;
    public ViewTreeObserver.OnGlobalLayoutListener l;

    private void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(i() ? false : com.kwad.sdk.core.response.a.a.aw(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (a(this.i)) {
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
        if (gVar.a == null || gVar.f41328b) {
            str = null;
        } else {
            str = gVar.d();
            if (str != null) {
                this.a.a.onSkippedAd();
                com.kwad.sdk.splashscreen.g gVar2 = this.a;
                gVar2.f41328b = true;
                gVar2.f41330d.mMiniWindowId = str;
            }
            com.kwad.sdk.splashscreen.b.a aVar = this.a.f41332f;
            com.kwad.sdk.core.report.a.a(this.a.f41330d, 114, com.kwad.sdk.core.config.b.ao(), aVar != null ? (int) (aVar.c() / 1000) : 0);
        }
        if (str == null && this.f41240f && (splashScreenAdInteractionListener = this.a.a) != null) {
            splashScreenAdInteractionListener.onSkippedAd();
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f41332f;
            if (aVar2 != null) {
                try {
                    jSONObject.put("duration", aVar2.c());
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            com.kwad.sdk.core.report.a.a(this.a.f41330d, 1, jSONObject);
        }
    }

    private boolean i() {
        com.kwad.sdk.splashscreen.g gVar = this.a;
        return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
    }

    private void r() {
        if (a(this.i)) {
            this.f41238d.getViewTreeObserver().addOnGlobalLayoutListener(s());
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener s() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.splashscreen.a.c.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layoutParams = c.this.f41238d.getLayoutParams();
                layoutParams.height = com.kwad.sdk.a.kwai.a.a(c.this.f41238d.getContext(), 35.0f);
                int width = c.this.f41238d.getWidth();
                c.this.f41238d.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = c.this.k.getLayoutParams();
                layoutParams2.width = width + com.kwad.sdk.a.kwai.a.a(c.this.f41238d.getContext(), 66.0f);
                c.this.k.setLayoutParams(layoutParams2);
                if (c.this.l != null) {
                    c.this.f41238d.getViewTreeObserver().removeOnGlobalLayoutListener(c.this.l);
                }
            }
        };
        this.l = onGlobalLayoutListener;
        return onGlobalLayoutListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        if (!this.j && this.f41238d != null) {
            if (this.f41238d.f()) {
                com.kwad.sdk.core.report.a.c(this.a.f41330d, 124, null);
                this.j = true;
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
        this.f41237c = (TextView) gVar.f41331e.findViewById(R.id.obfuscated_res_0x7f091146);
        this.f41238d = (SkipView) this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f091148);
        this.k = this.a.f41331e.findViewById(R.id.obfuscated_res_0x7f091139);
        this.f41236b = new Handler(Looper.getMainLooper());
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a.f41330d);
        this.i = j;
        int i = j.adSplashInfo.imageDisplaySecond;
        this.f41238d.setTimerPrefixText(com.kwad.sdk.core.config.b.at());
        this.f41238d.setTimerSecond(i);
        if (!com.kwad.sdk.core.response.a.a.P(this.i)) {
            this.f41238d.a();
        }
        if (!this.a.f41330d.adInfoList.isEmpty()) {
            AdInfo adInfo = this.i;
            this.f41241g = adInfo.adPreloadInfo;
            AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
            int i2 = adSplashInfo.skipSecond;
            this.f41239e = i2;
            if (i2 == 5) {
                this.f41239e = 0;
            }
            if (this.a.b()) {
                adSplashInfo.skipSecond = 0;
                this.f41239e = 0;
            }
        }
        this.f41237c.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.f41241g;
        if (adPreloadInfo == null || at.a(adPreloadInfo.preloadTips)) {
            this.f41237c.setVisibility(8);
        } else {
            this.f41237c.setVisibility(0);
            this.f41237c.setText(this.f41241g.preloadTips);
        }
        this.f41242h = SystemClock.elapsedRealtime();
        this.a.i.a(this);
        if (!this.a.b() || at.a(com.kwad.sdk.core.config.b.am())) {
            this.f41238d.setSkipText(com.kwad.sdk.core.response.a.a.av(this.i));
        } else {
            SkipView skipView = this.f41238d;
            skipView.setSkipText(com.kwad.sdk.core.config.b.am() + " " + com.kwad.sdk.core.config.b.ao());
        }
        this.f41238d.setVisibility(4);
        if (a(this.i)) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.splashscreen.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.h();
                }
            });
        }
        this.f41238d.setOnViewListener(new SkipView.a() { // from class: com.kwad.sdk.splashscreen.a.c.2
            @Override // com.kwad.sdk.widget.SkipView.a
            public void a() {
                c.this.h();
            }

            @Override // com.kwad.sdk.widget.SkipView.a
            public void b() {
                c.this.g();
            }
        });
        a(this.f41238d, this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.a.i.b(this);
        Handler handler = this.f41236b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageVisible");
        this.f41236b.removeCallbacksAndMessages(null);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a.f41330d);
        if (j.adSplashInfo.skipSecond == -1) {
            this.f41238d.e();
            a(false);
        } else if (this.f41239e >= 0 && !this.f41240f) {
            this.f41236b.postDelayed(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.3
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public void run() {
                    c.this.f41238d.b();
                    c.this.a(true);
                    c.this.t();
                    c.this.f41239e = 0;
                    c.this.f41240f = true;
                }
            }, this.f41239e * 1000);
        }
        if (!com.kwad.sdk.core.response.a.a.P(j)) {
            this.f41238d.d();
        }
        r();
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.core.d.a.a("SkipAdPresenter", "onPageInvisible");
        if (com.kwad.sdk.core.response.a.a.P(this.i)) {
            return;
        }
        this.f41238d.c();
    }

    public void g() {
        this.f41236b.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.kwad.sdk.core.download.kwai.b.a() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                    c.this.f41236b.postDelayed(this, 1000L);
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
