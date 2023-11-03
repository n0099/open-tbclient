package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ax;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends e implements com.kwad.sdk.core.h.b {
    public AdInfo py;
    public boolean yA = false;
    public View yB;
    public TextView yx;
    public com.kwad.components.ad.splashscreen.widget.a yy;
    public AdInfo.AdPreloadInfo yz;

    private SplashSkipViewModel jW() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        splashSkipViewModel.needShowMiniWindow = this.yF.jz();
        int i = this.py.adSplashInfo.imageDisplaySecond;
        if (i <= 0) {
            i = 5;
        }
        AdInfo adInfo = this.py;
        int min = Math.min(adInfo.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.a.a.B(adInfo));
        if (com.kwad.sdk.core.response.a.a.aB(this.py)) {
            i = min;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    private boolean jX() {
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        return hVar != null && hVar.jz() && com.kwad.components.ad.splashscreen.a.b.jP() > 0 && !ax.dT(com.kwad.components.ad.splashscreen.a.b.jL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY() {
        String str;
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar.yb) {
            str = null;
        } else {
            str = hVar.jC();
            if (str != null) {
                this.yF.jG();
                com.kwad.components.ad.splashscreen.h hVar2 = this.yF;
                hVar2.yb = true;
                hVar2.mAdTemplate.mMiniWindowId = str;
            }
            com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
            com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 114, com.kwad.components.ad.splashscreen.a.b.jP(), aVar != null ? (int) (aVar.getCurrentPosition() / 1000) : 0);
        }
        if (str == null) {
            this.yF.jG();
            JSONObject jSONObject = new JSONObject();
            com.kwad.components.ad.splashscreen.c.a aVar2 = this.yF.yc;
            if (aVar2 != null) {
                try {
                    jSONObject.put("duration", aVar2.getCurrentPosition());
                } catch (JSONException e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
            }
            com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 1, jSONObject);
        }
    }

    private synchronized void ka() {
        if (!this.yA && this.yy != null) {
            if (com.kwad.sdk.core.response.a.a.bz(this.py) && com.kwad.sdk.core.response.a.a.bA(this.py)) {
                com.kwad.sdk.core.report.a.c(this.yF.mAdTemplate, 124, (JSONObject) null);
                this.yA = true;
            }
        }
    }

    private boolean p(AdInfo adInfo) {
        return jX() || !com.kwad.sdk.core.response.a.a.bx(adInfo);
    }

    private void q(AdInfo adInfo) {
        TextView textView = (TextView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091465);
        this.yx = textView;
        this.yz = adInfo.adPreloadInfo;
        textView.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.yz;
        if (adPreloadInfo == null || ax.dT(adPreloadInfo.preloadTips)) {
            this.yx.setVisibility(8);
            return;
        }
        this.yx.setVisibility(0);
        this.yx.setText(this.yz.preloadTips);
    }

    private void r(AdInfo adInfo) {
        this.yB = this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091454);
        if (!com.kwad.sdk.core.response.a.a.by(adInfo)) {
            this.yB.setVisibility(8);
            return;
        }
        this.yB.setVisibility(0);
        this.yB.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.this.jY();
            }
        });
        this.yB.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ((View) c.this.yy).post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int Y = c.this.yy.Y(35);
                        ViewGroup.LayoutParams layoutParams = c.this.yB.getLayoutParams();
                        layoutParams.width = Y + com.kwad.sdk.b.kwai.a.a(c.this.yF.mRootContainer.getContext(), 66.0f);
                        c.this.yB.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        com.kwad.sdk.core.e.b.d("SkipAdPresenter", "onPageVisible");
        this.yy.t(this.py);
        ka();
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        com.kwad.sdk.core.e.b.d("SkipAdPresenter", "onPageInvisible");
        this.yy.s(this.py);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aq() {
        AdBaseFrameLayout adBaseFrameLayout;
        int i;
        super.aq();
        com.kwad.sdk.core.e.b.d("SkipAdPresenter", "onBind");
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
        this.py = bQ;
        q(bQ);
        if (p(this.py)) {
            adBaseFrameLayout = this.yF.mRootContainer;
            i = R.id.obfuscated_res_0x7f091467;
        } else {
            adBaseFrameLayout = this.yF.mRootContainer;
            i = R.id.obfuscated_res_0x7f091460;
        }
        this.yy = (com.kwad.components.ad.splashscreen.widget.a) adBaseFrameLayout.findViewById(i);
        this.yy.a(jW(), this.py);
        this.yy.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.b.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kb() {
                c.this.jY();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kc() {
                c.this.jZ();
            }
        });
        r(this.py);
        this.yF.yd.a(this);
    }

    public final void jZ() {
        this.yF.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.c.kwai.b.mq() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                    c.this.yF.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.yF.jF();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.yF.yd.b(this);
        this.yy.bj();
    }
}
