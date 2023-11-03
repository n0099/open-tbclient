package com.kwad.components.ad.interstitial.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class i extends com.kwad.components.ad.interstitial.b.b {
    public static int hE = 4;
    public c gh;
    public a hC = new a();
    public b hD = new b();
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    /* loaded from: classes10.dex */
    public static class a {
        public ImageView hF;
        public TextView hG;
        public TextView hH;
        public KsPriceView hI;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public String appIconUrl;
        public String hJ;
        public CharSequence hK;
        public String hL;
        public String hM;
        public String price;

        public final void A(String str) {
            this.hM = str;
        }

        public final void a(CharSequence charSequence) {
            this.hK = charSequence;
        }

        public final CharSequence dA() {
            return this.hK;
        }

        public final String dB() {
            return this.hL;
        }

        public final String dC() {
            return this.hM;
        }

        public final String dz() {
            return this.hJ;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void w(String str) {
            this.appIconUrl = str;
        }

        public final void x(String str) {
            this.hJ = str;
        }

        public final void y(String str) {
            this.hL = str;
        }

        public final void z(String str) {
            this.price = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.hF;
        if (TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.a.a.bD(adInfo)) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e5f));
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080e5f);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, hE);
            }
        }
        aVar.hG.setText(bVar.dz());
        if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            aVar.hI.d(bVar.getPrice(), bVar.dB(), true);
            aVar.hI.setVisibility(0);
            aVar.hH.setVisibility(8);
            dy();
        } else {
            aVar.hH.setText(bVar.dA());
        }
        this.gh.gj.g(bVar.dC(), 0);
    }

    private void dy() {
        View findViewById = this.gh.gj.findViewById(R.id.obfuscated_res_0x7f0912b6);
        View findViewById2 = this.gh.gj.findViewById(R.id.obfuscated_res_0x7f091459);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    private void e(AdInfo adInfo) {
        b bVar;
        String string;
        b bVar2;
        String string2;
        if (com.kwad.sdk.core.response.a.a.bD(adInfo)) {
            this.hD.w(com.kwad.sdk.core.response.a.a.bI(adInfo));
            this.hD.x(com.kwad.sdk.core.response.a.a.bm(adInfo));
            CharSequence e = com.kwad.sdk.core.response.a.a.e(adInfo, com.kwad.components.core.widget.f.PD);
            if (TextUtils.isEmpty(e)) {
                e = com.kwad.sdk.core.response.a.a.bH(adInfo);
            }
            this.hD.a(e);
            if (com.kwad.sdk.core.response.a.a.bE(adInfo)) {
                this.hD.A(com.kwad.components.ad.c.b.ah());
            } else {
                this.hD.A(com.kwad.components.ad.c.b.ak());
            }
        } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
            this.hD.w(bN.icon);
            this.hD.x(bN.name);
            this.hD.y(bN.originPrice);
            this.hD.z(bN.price);
            this.hD.A(com.kwad.components.ad.c.b.ai());
        } else if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
            this.hD.w(com.kwad.sdk.core.response.a.a.bn(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ae(adInfo))) {
                bVar2 = this.hD;
                string2 = com.kwad.sdk.core.response.a.a.ae(adInfo);
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                bVar2 = this.hD;
                string2 = getContext().getString(R.string.obfuscated_res_0x7f0f0b7b);
            } else {
                bVar2 = this.hD;
                string2 = adInfo.advertiserInfo.adAuthorText;
            }
            bVar2.x(string2);
            this.hD.a(com.kwad.sdk.core.response.a.a.ad(adInfo));
            this.hD.A(com.kwad.sdk.core.response.a.a.al(adInfo));
        } else {
            this.hD.w(com.kwad.sdk.core.response.a.a.bn(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.af(adInfo))) {
                bVar = this.hD;
                string = com.kwad.sdk.core.response.a.a.af(adInfo);
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                bVar = this.hD;
                string = getContext().getString(R.string.obfuscated_res_0x7f0f0b7b);
            } else {
                bVar = this.hD;
                string = adInfo.advertiserInfo.adAuthorText;
            }
            bVar.x(string);
            this.hD.a(com.kwad.sdk.core.response.a.a.ad(adInfo));
            this.hD.A(com.kwad.sdk.core.response.a.a.al(adInfo));
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        c cVar = (c) xR();
        this.gh = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.hC.hF = (ImageView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f0912d0);
        this.hC.hG = (TextView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f0912d4);
        this.hC.hH = (TextView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f0912cc);
        this.hC.hI = (KsPriceView) this.gh.gj.findViewById(R.id.obfuscated_res_0x7f0913a7);
        e(this.mAdInfo);
        a(this.hC, this.hD, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
