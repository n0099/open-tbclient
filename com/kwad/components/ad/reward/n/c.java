package com.kwad.components.ad.reward.n;

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
/* loaded from: classes10.dex */
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.c {
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public View xY;
    public View xZ;
    public Button ya;
    public Button yb;
    public TextView yc;
    public ImageView yd;
    public TextView ye;
    public TextView yf;
    public KSRatingBar yg;
    public KsAppTagsView yh;
    public a yi;
    public volatile boolean yj = false;
    public com.kwad.components.ad.i.a yk;
    public Runnable yl;

    /* loaded from: classes10.dex */
    public interface a {
        void d(boolean z, int i);
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    /* loaded from: classes10.dex */
    public static class b {
        public String appName;
        public String pZ;
        public String qa;
        public float yn;
        public List<String> yo;
        public int yp = 15;
        public String yq;

        public final String jP() {
            return String.format(this.yq, Integer.valueOf(this.yp));
        }

        public static b P(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.b.e.F(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.b.a.ax(dP);
            } else {
                bVar.appName = com.kwad.sdk.core.response.b.a.av(dP);
            }
            bVar.yn = com.kwad.sdk.core.response.b.a.aC(dP);
            bVar.qa = com.kwad.sdk.core.response.b.a.au(dP);
            if (com.kwad.sdk.core.response.b.e.F(adTemplate)) {
                bVar.pZ = com.kwad.sdk.core.response.b.a.cG(dP);
            } else {
                bVar.pZ = com.kwad.sdk.core.response.b.a.cf(dP);
            }
            if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dP(adTemplate)))) {
                bVar.yp = com.kwad.components.ad.reward.a.b.gp();
                bVar.yq = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.yp = com.kwad.sdk.core.config.d.AW();
                bVar.yq = "浏览详情页%s秒，领取奖励";
            }
            bVar.yo = com.kwad.sdk.core.response.b.d.dG(adTemplate);
            return bVar;
        }
    }

    public c(View view2) {
        this.xY = view2;
        initView();
        this.yk = new com.kwad.components.ad.i.a(view2);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.yk.lV();
            this.yb.setText(com.kwad.sdk.core.response.b.a.cR(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.yk.lV();
            this.yb.setText(com.kwad.sdk.core.response.b.a.cQ(i));
        }
    }

    private void c(View view2, boolean z) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091417 || id == R.id.obfuscated_res_0x7f091416 || id == R.id.obfuscated_res_0x7f091418) {
            com.kwad.sdk.core.e.c.d("ApkInfoCardViewHelper", "onClick install");
            this.yj = true;
            a aVar = this.yi;
            if (aVar != null) {
                aVar.d(z, 1);
            }
        }
    }

    public final void k(String str, int i) {
        Button button = this.yb;
        if (button != null && str != null && i != 0) {
            button.setText(str);
        }
    }

    private void initView() {
        this.ya = (Button) this.xY.findViewById(R.id.obfuscated_res_0x7f091416);
        this.yb = (Button) this.xY.findViewById(R.id.obfuscated_res_0x7f091418);
        this.xZ = this.xY.findViewById(R.id.obfuscated_res_0x7f091417);
        this.yd = (ImageView) this.xY.findViewById(R.id.obfuscated_res_0x7f091415);
        this.yc = (TextView) this.xY.findViewById(R.id.obfuscated_res_0x7f091419);
        this.ye = (TextView) this.xY.findViewById(R.id.obfuscated_res_0x7f091413);
        this.yg = (KSRatingBar) this.xY.findViewById(R.id.obfuscated_res_0x7f09141a);
        this.yh = (KsAppTagsView) this.xY.findViewById(R.id.obfuscated_res_0x7f09141c);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        c(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            c(view2, false);
        }
    }

    public final void a(a aVar) {
        this.yi = aVar;
    }

    public final void a(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        b P = b.P(adTemplate);
        if (P == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.yd, P.pZ, adTemplate, 12);
        this.yc.setText(P.appName);
        this.ye.setText(P.qa);
        this.yg.setStar(P.yn);
        if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dP(adTemplate)))) {
            this.yb.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
            this.yg.setVisibility(0);
        } else {
            this.yb.setText("查看详情");
            this.yg.setVisibility(8);
        }
        this.ya.setText(P.jP());
        this.ya.setClickable(true);
        this.yb.setClickable(true);
        this.xZ.setClickable(true);
        new com.kwad.sdk.widget.f(this.ya, this);
        new com.kwad.sdk.widget.f(this.yb, this);
        new com.kwad.sdk.widget.f(this.xZ, this);
        List<String> list = P.yo;
        if (z && list.size() == 0) {
            this.ye.setVisibility(8);
            TextView textView = (TextView) this.xY.findViewById(R.id.obfuscated_res_0x7f091414);
            this.yf = textView;
            textView.setVisibility(0);
            this.yf.setText(P.qa);
        }
        if (list.size() == 0) {
            this.yh.setVisibility(8);
        }
        this.yh.setAppTags(list);
        if (this.yl == null) {
            this.yl = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    int height = c.this.xZ.getHeight();
                    com.kwad.sdk.core.e.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                    if (!c.this.yj) {
                        c.this.yk.hR();
                    }
                }
            };
        }
        this.xZ.postDelayed(this.yl, 1600L);
    }

    public final void jN() {
        Runnable runnable;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.i.a aVar = this.yk;
        if (aVar != null) {
            aVar.jN();
        }
        View view2 = this.xZ;
        if (view2 != null && (runnable = this.yl) != null) {
            view2.removeCallbacks(runnable);
            this.yl = null;
        }
    }

    public final void jO() {
        this.yk.lV();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        } else {
            str = "立即下载";
        }
        this.yb.setText(str);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        String bX;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            bX = "";
        } else {
            bX = com.kwad.sdk.core.response.b.a.bX(adTemplate);
        }
        this.yb.setText(bX);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        } else {
            str = "立即下载";
        }
        this.yb.setText(str);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        } else {
            str = "立即打开";
        }
        this.yb.setText(str);
    }
}
