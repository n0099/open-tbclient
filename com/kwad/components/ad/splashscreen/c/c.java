package com.kwad.components.ad.splashscreen.c;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bm;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends e implements com.kwad.sdk.core.h.c {
    public TextView CX;
    public com.kwad.components.ad.splashscreen.widget.a CY;
    public AdInfo.AdPreloadInfo CZ;
    public boolean Da = false;
    public View Db;
    public AdInfo sc;

    private SplashSkipViewModel kP() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        int i = this.sc.adSplashInfo.imageDisplaySecond;
        if (i <= 0) {
            i = 5;
        }
        AdInfo adInfo = this.sc;
        int min = Math.min(adInfo.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.L(adInfo));
        if (com.kwad.sdk.core.response.b.a.bc(this.sc)) {
            i = min;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    private synchronized void kS() {
        if (!this.Da && this.CY != null) {
            if (com.kwad.sdk.core.response.b.a.cv(this.sc) && com.kwad.sdk.core.response.b.a.cw(this.sc)) {
                com.kwad.sdk.core.report.a.b(this.Df.mAdTemplate, 124, (JSONObject) null);
                this.Da = true;
            }
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onPageVisible");
        this.CY.B(this.sc);
        kS();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onPageInvisible");
        this.CY.A(this.sc);
    }

    public final void kR() {
        this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.e.c.b.nj()) {
                    c.this.Df.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Df.kF();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Df.Cr.b(this);
        this.CY.bf();
    }

    private void t(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.f.c.z(adInfo)) {
            i = R.id.obfuscated_res_0x7f0914c8;
        } else {
            i = R.id.obfuscated_res_0x7f0914c4;
        }
        findViewById(i).setVisibility(0);
    }

    public static boolean u(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.ct(adInfo)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ() {
        com.kwad.components.ad.splashscreen.monitor.a.kM().l(this.Df.mAdTemplate);
        this.Df.kH();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.e.a aVar = this.Df.Cp;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        y.a aVar2 = new y.a();
        bm bmVar = this.Df.mTimerHelper;
        if (bmVar != null) {
            aVar2.duration = bmVar.getTime();
        }
        com.kwad.sdk.core.report.a.b(this.Df.mAdTemplate, new com.kwad.sdk.core.report.j().cB(1).cJ(22).a(aVar2), jSONObject);
    }

    private void v(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.f.c.z(adInfo)) {
            i = R.id.obfuscated_res_0x7f0914c7;
        } else {
            i = R.id.obfuscated_res_0x7f0914c6;
        }
        this.CX = (TextView) findViewById(i);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.CZ = adPreloadInfo;
        if (adPreloadInfo != null && !bg.isNullString(adPreloadInfo.preloadTips)) {
            this.CX.setVisibility(0);
            this.CX.setText(this.CZ.preloadTips);
            return;
        }
        this.CX.setVisibility(8);
    }

    private void w(AdInfo adInfo) {
        this.Db = findViewById(R.id.obfuscated_res_0x7f0914a9);
        if (com.kwad.sdk.core.response.b.a.cu(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.Db.setVisibility(0);
            this.Db.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.this.kQ();
                }
            });
            this.Db.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    ((View) c.this.CY).post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            int aa = c.this.CY.aa(35);
                            ViewGroup.LayoutParams layoutParams = c.this.Db.getLayoutParams();
                            layoutParams.width = aa + com.kwad.sdk.d.a.a.a(c.this.Df.mRootContainer.getContext(), 66.0f);
                            c.this.Db.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.Db.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aj() {
        int i;
        int i2;
        super.aj();
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onBind");
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        this.sc = dP;
        t(dP);
        v(this.sc);
        if (u(this.sc)) {
            if (com.kwad.components.ad.splashscreen.f.c.z(this.sc)) {
                i2 = R.id.obfuscated_res_0x7f0914cb;
            } else {
                i2 = R.id.obfuscated_res_0x7f0914ca;
            }
            this.CY = (com.kwad.components.ad.splashscreen.widget.a) findViewById(i2);
        } else {
            if (com.kwad.components.ad.splashscreen.f.c.z(this.sc)) {
                i = R.id.obfuscated_res_0x7f0914b6;
            } else {
                i = R.id.obfuscated_res_0x7f0914b5;
            }
            this.CY = (com.kwad.components.ad.splashscreen.widget.a) findViewById(i);
        }
        this.CY.a(kP(), this.sc);
        this.CY.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.c.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void Y(int i3) {
                c.this.Df.X(i3);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kT() {
                c.this.kQ();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kU() {
                c.this.kR();
            }
        });
        w(this.sc);
        this.Df.Cr.a(this);
    }
}
