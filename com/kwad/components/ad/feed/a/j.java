package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes10.dex */
public final class j extends a implements View.OnClickListener {
    public KsLogoView bq;
    public RoundAngleImageView dI;
    public TextView de;
    public ImageView dg;
    public DownloadProgressView dk;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    public j(@NonNull Context context) {
        super(context);
    }

    private void bi() {
        this.bq.T(this.mAdTemplate);
        this.dk.F(this.mAdTemplate);
        com.kwad.sdk.b.kwai.a.a(this, this.de, this.dI, this.dk);
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, this.dk.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.dk.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bf();
            g(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f091268);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0912df)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f09126e);
        this.dI = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.b.kwai.a.a(getContext(), 3.0f));
        this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f09126a);
        this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091281);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912d5);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bj() {
        super.bj();
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.dk.getAppDownloadListener());
        }
        g(false);
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        super.c((j) adTemplate);
        this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        List<String> aA = com.kwad.sdk.core.response.a.a.aA(this.mAdInfo);
        if (aA.size() > 0) {
            KSImageLoader.loadFeeImage(this.dI, aA.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.b.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        bi();
        this.dg.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.feed.a.a
    public final com.kwad.components.core.c.a.c getApkDownloadHelper() {
        return this.mApkDownloadHelper;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04a4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.dg) {
            pX();
            return;
        }
        final int i = 35;
        if (view2 == this.de) {
            i = 25;
        } else if (view2 == this.dI) {
            i = 100;
        } else if (view2 == this.dk) {
            i = 1;
        }
        g(false);
        com.kwad.components.core.c.a.a.a(new a.C0648a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.dk ? 1 : 2).aj(view2 == this.dk).a(new a.b() { // from class: com.kwad.components.ad.feed.a.j.1
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                j.this.aq(i);
            }
        }));
    }

    @Override // com.kwad.components.ad.feed.a.a
    public final void setPaddingToShowAnim(View view2) {
        if (view2.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            viewGroup.setPadding(com.kwad.sdk.b.kwai.a.a(this.mContext, 4.0f), 0, 0, com.kwad.sdk.b.kwai.a.a(this.mContext, 2.0f));
            viewGroup.setClipToPadding(false);
        }
    }
}
