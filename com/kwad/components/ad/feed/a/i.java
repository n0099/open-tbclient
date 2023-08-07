package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes10.dex */
public final class i extends a implements View.OnClickListener {
    public KsLogoView bq;
    public TextView de;
    public ImageView df;
    public ImageView dg;

    public i(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091293)).setRatio(0.56f);
        this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f091252);
        this.df = (ImageView) findViewById(R.id.obfuscated_res_0x7f091258);
        this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f091254);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912bf);
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        super.c((i) adTemplate);
        this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        List<String> aA = com.kwad.sdk.core.response.a.a.aA(this.mAdInfo);
        this.bq.T(adTemplate);
        if (aA.size() > 0) {
            KSImageLoader.loadFeeImage(this.df, aA.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.b.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.b.kwai.a.a(this, this.de, this.df, this.dg);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            bf();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d049c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.dg) {
            pX();
            return;
        }
        int i = 35;
        if (view2 == this.de) {
            i = 25;
        } else if (view2 == this.df) {
            i = 100;
        }
        if (com.kwad.components.core.c.a.d.a(new a.C0647a(getContext()).L(this.mAdTemplate), 1) == 1) {
            aq(i);
            return;
        }
        boolean am = com.kwad.sdk.core.response.a.a.am(this.mAdInfo);
        aq(i);
        if (am) {
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.lp);
        } else {
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }
}
