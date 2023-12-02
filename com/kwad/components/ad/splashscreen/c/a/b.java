package com.kwad.components.ad.splashscreen.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.baidu.tieba.R;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.splashscreen.c.e implements View.OnClickListener {
    public TextView Eu;
    public TextView Ev;
    public TextView Ew;
    public TextView Ex;
    public TextView Ey;
    public AdInfo.DownloadSafeInfo Ez;

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Ez = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate).downloadSafeInfo;
        lu();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    private void initView() {
        this.Eu = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e8);
        this.Ev = (TextView) findViewById(R.id.obfuscated_res_0x7f0912fe);
        this.Ew = (TextView) findViewById(R.id.obfuscated_res_0x7f0912f5);
        this.Ex = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ff);
        this.Ey = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e2);
    }

    private void lu() {
        if (!com.kwad.sdk.core.response.b.a.aP(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate))) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str = this.Ez.appVersion;
        if (bg.gh(str)) {
            sb.append("版本号 ");
            sb.append(str);
        }
        if (bg.gh(sb.toString())) {
            this.Eu.setText(sb);
        }
        String str2 = this.Ez.introductionInfoUrl;
        if (bg.gh(str2)) {
            this.Ew.setText("功能");
            this.Ew.setOnClickListener(this);
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = this.Ez;
        String str3 = downloadSafeInfo.appPermissionInfoUrl;
        String str4 = downloadSafeInfo.appPrivacyUrl;
        if (bg.gh(str3)) {
            StringBuilder sb2 = new StringBuilder();
            if (bg.gh(str2)) {
                sb2.append(" | ");
            }
            sb2.append("权限");
            this.Ev.setText(sb2);
            this.Ev.setOnClickListener(this);
        }
        if (bg.gh(str4)) {
            StringBuilder sb3 = new StringBuilder();
            if (bg.gh(str3) || bg.gh(str2)) {
                sb3.append(" | ");
            }
            sb3.append("隐私");
            this.Ex.setText(sb3);
            this.Ex.setOnClickListener(this);
        }
        StringBuilder sb4 = new StringBuilder();
        String str5 = this.Ez.appName;
        if (bg.gh(str5)) {
            sb4.append(str5);
        }
        String str6 = this.Ez.corporationName;
        if (bg.gh(str6)) {
            if (bg.gh(str5)) {
                sb4.append(" ");
            }
            sb4.append(str6);
        }
        if (bg.gh(sb4.toString())) {
            this.Ey.setText(sb4);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.Ex) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0655a().al(AgreementView.l).am(this.Ez.appPrivacyUrl).aB(true).as(this.Df.mAdTemplate).pa());
        } else if (view2 == this.Ev) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0655a().al("权限信息").aB(true).am(this.Ez.appPermissionInfoUrl).as(this.Df.mAdTemplate).pa());
        } else if (view2 == this.Ew) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0655a().al("功能介绍").aB(true).am(this.Ez.introductionInfoUrl).as(this.Df.mAdTemplate).pa());
        }
    }
}
