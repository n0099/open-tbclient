package com.kwad.components.ad.interstitial.e;

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
public final class g extends com.kwad.components.ad.interstitial.e.b {
    public static int kR = 4;
    public c jK;
    public a kP = new a();
    public b kQ = new b();
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    /* loaded from: classes10.dex */
    public static class b {
        public String appIconUrl;
        public String kW;
        public CharSequence kX;
        public String kY;
        public String kZ;
        public String price;

        public final String dA() {
            return this.kZ;
        }

        public final String dx() {
            return this.kW;
        }

        public final CharSequence dy() {
            return this.kX;
        }

        public final String dz() {
            return this.kY;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void a(CharSequence charSequence) {
            this.kX = charSequence;
        }

        public final void r(String str) {
            this.appIconUrl = str;
        }

        public final void s(String str) {
            this.kW = str;
        }

        public final void t(String str) {
            this.kY = str;
        }

        public final void u(String str) {
            this.price = str;
        }

        public final void v(String str) {
            this.kZ = str;
        }
    }

    private void dw() {
        View findViewById = this.jK.jL.findViewById(R.id.obfuscated_res_0x7f0912e1);
        View findViewById2 = this.jK.jL.findViewById(R.id.obfuscated_res_0x7f0914ae);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    /* loaded from: classes10.dex */
    public static class a {
        public ImageView kS;
        public TextView kT;
        public TextView kU;
        public KsPriceView kV;
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.kS;
        if (!TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.b.a.bZ(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e6a));
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080e6a);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, kR);
            }
        } else {
            imageView.setVisibility(8);
        }
        aVar.kT.setText(bVar.dx());
        if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.bZ(adInfo) == 3) {
            aVar.kV.d(bVar.getPrice(), bVar.dz(), true);
            aVar.kV.setVisibility(0);
            aVar.kU.setVisibility(8);
            dw();
        } else {
            aVar.kU.setText(bVar.dy());
        }
        this.jK.jL.g(bVar.dA(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bZ(adInfo) == 2) {
            this.kQ.r(com.kwad.sdk.core.response.b.a.cG(adInfo));
            this.kQ.s(com.kwad.sdk.core.response.b.a.ce(adInfo));
            CharSequence b2 = com.kwad.sdk.core.response.b.a.b(adInfo, com.kwad.components.core.widget.e.acd);
            if (TextUtils.isEmpty(b2)) {
                b2 = com.kwad.sdk.core.response.b.a.cF(adInfo);
            }
            this.kQ.a(b2);
            if (com.kwad.sdk.core.response.b.a.cC(adInfo)) {
                this.kQ.v(com.kwad.components.ad.d.b.X());
            } else {
                this.kQ.v(com.kwad.components.ad.d.b.aa());
            }
        } else if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.bZ(adInfo) == 3) {
            AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(adInfo);
            this.kQ.r(cM.icon);
            this.kQ.s(cM.name);
            this.kQ.t(cM.originPrice);
            this.kQ.u(cM.price);
            this.kQ.v(com.kwad.components.ad.d.b.Y());
        } else if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            this.kQ.r(com.kwad.sdk.core.response.b.a.cf(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.av(adInfo))) {
                this.kQ.s(com.kwad.sdk.core.response.b.a.av(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.kQ.s(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.kQ.s(getContext().getString(R.string.obfuscated_res_0x7f0f0b88));
            }
            this.kQ.a(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.kQ.v(com.kwad.sdk.core.response.b.a.aE(adInfo));
        } else {
            this.kQ.r(com.kwad.sdk.core.response.b.a.cf(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.ax(adInfo))) {
                this.kQ.s(com.kwad.sdk.core.response.b.a.ax(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.kQ.s(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.kQ.s(getContext().getString(R.string.obfuscated_res_0x7f0f0b88));
            }
            this.kQ.a(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.kQ.v(com.kwad.sdk.core.response.b.a.aE(adInfo));
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) HU();
        this.jK = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.kP.kS = (ImageView) this.jK.jL.findViewById(R.id.obfuscated_res_0x7f091307);
        this.kP.kT = (TextView) this.jK.jL.findViewById(R.id.obfuscated_res_0x7f09130b);
        this.kP.kU = (TextView) this.jK.jL.findViewById(R.id.obfuscated_res_0x7f091303);
        this.kP.kV = (KsPriceView) this.jK.jL.findViewById(R.id.obfuscated_res_0x7f09140b);
        d(this.mAdInfo);
        a(this.kP, this.kQ, this.mAdInfo, this.mAdTemplate);
    }
}
