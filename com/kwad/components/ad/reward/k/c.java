package com.kwad.components.ad.reward.k;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;
/* loaded from: classes9.dex */
public final class c extends com.kwad.sdk.core.download.kwai.a implements com.kwad.sdk.widget.c {
    public ImageView ll;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public View um;
    public View un;
    public Button uo;
    public Button up;
    public TextView uq;
    public TextView ur;
    public TextView us;
    public KSRatingBar ut;
    public KsAppTagsView uu;
    public a uv;
    public volatile boolean uw = false;
    public com.kwad.components.ad.g.a ux;
    public Runnable uy;

    /* loaded from: classes9.dex */
    public interface a {
        void c(boolean z, int i);
    }

    /* loaded from: classes9.dex */
    public static class b {
        public String appName;
        public String kY;
        public String np;
        public float uA;
        public List<String> uB;
        public int uC = 15;
        public String uD;

        public static b B(AdTemplate adTemplate) {
            String str;
            if (adTemplate == null) {
                return null;
            }
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            b bVar = new b();
            bVar.appName = com.kwad.sdk.core.response.a.d.p(adTemplate) ? com.kwad.sdk.core.response.a.a.af(bQ) : com.kwad.sdk.core.response.a.a.ae(bQ);
            bVar.uA = com.kwad.sdk.core.response.a.a.aj(bQ);
            bVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
            bVar.kY = com.kwad.sdk.core.response.a.d.p(adTemplate) ? com.kwad.sdk.core.response.a.a.bI(bQ) : com.kwad.sdk.core.response.a.a.bn(bQ);
            if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                bVar.uC = com.kwad.components.ad.reward.kwai.b.fX();
                str = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.uC = com.kwad.sdk.core.config.d.sf();
                str = "浏览详情页%s秒，领取奖励";
            }
            bVar.uD = str;
            bVar.uB = com.kwad.sdk.core.response.a.c.bH(adTemplate);
            return bVar;
        }

        public final String iQ() {
            return String.format(this.uD, Integer.valueOf(this.uC));
        }
    }

    public c(View view2) {
        this.um = view2;
        initView();
        this.ux = new com.kwad.components.ad.g.a(view2);
    }

    private void c(View view2, boolean z) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091327 || id == R.id.obfuscated_res_0x7f091326 || id == R.id.obfuscated_res_0x7f091328) {
            com.kwad.sdk.core.e.b.d("ApkInfoCardViewHelper", "onClick install");
            this.uw = true;
            a aVar = this.uv;
            if (aVar != null) {
                aVar.c(z, 1);
            }
        }
    }

    private void initView() {
        this.uo = (Button) this.um.findViewById(R.id.obfuscated_res_0x7f091326);
        this.up = (Button) this.um.findViewById(R.id.obfuscated_res_0x7f091328);
        this.un = this.um.findViewById(R.id.obfuscated_res_0x7f091327);
        this.ll = (ImageView) this.um.findViewById(R.id.obfuscated_res_0x7f091325);
        this.uq = (TextView) this.um.findViewById(R.id.obfuscated_res_0x7f091329);
        this.ur = (TextView) this.um.findViewById(R.id.obfuscated_res_0x7f091323);
        this.ut = (KSRatingBar) this.um.findViewById(R.id.obfuscated_res_0x7f09132a);
        this.uu = (KsAppTagsView) this.um.findViewById(R.id.obfuscated_res_0x7f09132c);
    }

    public final void a(a aVar) {
        this.uv = aVar;
    }

    public final void a(com.kwad.components.core.c.a.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        b B = b.B(adTemplate);
        if (B == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.ll, B.kY, adTemplate, 12);
        this.uq.setText(B.appName);
        this.ur.setText(B.np);
        this.ut.setStar(B.uA);
        if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
            this.up.setText(com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
            this.ut.setVisibility(0);
        } else {
            this.up.setText("查看详情");
            this.ut.setVisibility(8);
        }
        this.uo.setText(B.iQ());
        this.uo.setClickable(true);
        this.up.setClickable(true);
        this.un.setClickable(true);
        new com.kwad.sdk.widget.f(this.uo, this);
        new com.kwad.sdk.widget.f(this.up, this);
        new com.kwad.sdk.widget.f(this.un, this);
        List<String> list = B.uB;
        if (z && list.size() == 0) {
            this.ur.setVisibility(8);
            TextView textView = (TextView) this.um.findViewById(R.id.obfuscated_res_0x7f091324);
            this.us = textView;
            textView.setVisibility(0);
            this.us.setText(B.np);
        }
        if (list.size() == 0) {
            this.uu.setVisibility(8);
        }
        this.uu.setAppTags(list);
        if (this.uy == null) {
            this.uy = new Runnable() { // from class: com.kwad.components.ad.reward.k.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    int height = c.this.un.getHeight();
                    com.kwad.sdk.core.e.b.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                    if (c.this.uw) {
                        return;
                    }
                    c.this.ux.kL();
                }
            };
        }
        this.un.postDelayed(this.uy, 1600L);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        c(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            c(view2, false);
        }
    }

    public final void i(String str, int i) {
        Button button = this.up;
        if (button == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    public final void iO() {
        Runnable runnable;
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.g.a aVar = this.ux;
        if (aVar != null) {
            aVar.iO();
        }
        View view2 = this.un;
        if (view2 == null || (runnable = this.uy) == null) {
            return;
        }
        view2.removeCallbacks(runnable);
        this.uy = null;
    }

    public final void iP() {
        this.ux.kN();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.up.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.up.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aJ(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.up.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.up.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.ux.kN();
            this.up.setText(com.kwad.sdk.core.response.a.a.aX(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.ux.kN();
            this.up.setText(com.kwad.sdk.core.response.a.a.aW(i));
        }
    }
}
