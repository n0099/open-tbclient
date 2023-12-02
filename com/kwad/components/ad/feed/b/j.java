package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes10.dex */
public final class j extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    public TextView eB;
    public ImageView eC;
    public ImageView eD;
    public KsLogoView mLogoView;

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04cf;
    }

    public j(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        onClick(view2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            c(view2, 153);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        int i;
        if (view2 == this.eB) {
            i = 25;
        } else if (view2 == this.eC) {
            i = 100;
        } else {
            i = 35;
        }
        c(view2, i);
    }

    private void c(View view2, int i) {
        if (view2 == this.eD) {
            ta();
        } else if (com.kwad.components.core.e.d.d.a(new a.C0644a(getContext()).aq(this.mAdTemplate), 1) == 1) {
            aH(i);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            aH(i);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.aaZ);
        } else {
            aH(i);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((j) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        List<String> ba = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        this.mLogoView.aD(this.mAdTemplate);
        if (ba.size() > 0) {
            KSImageLoader.loadFeeImage(this.eC, ba.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.c.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.d.a.a.a(this, this.eB, this.eC, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bb();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09133c)).setRatio(0.5600000023841858d);
        this.eB = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e0);
        this.eC = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912ef);
        this.eD = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912e3);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091369);
    }
}
