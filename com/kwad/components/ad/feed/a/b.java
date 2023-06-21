package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class b extends a implements View.OnClickListener {
    public KsLogoView bq;
    public TextView cE;
    public ImageView cw;
    public TextView cx;
    public TextView de;
    public ImageView df;
    public ImageView dg;
    public TextView dh;
    public TextView di;
    public View dj;
    public DownloadProgressView dk;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    public b(@NonNull Context context) {
        super(context);
    }

    private void bh() {
        findViewById(R.id.obfuscated_res_0x7f091220).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f09121f).setVisibility(8);
        this.di = (TextView) findViewById(R.id.obfuscated_res_0x7f09128d);
        this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f09128f);
        this.dj = findViewById(R.id.obfuscated_res_0x7f091290);
        this.di.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        this.cE.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
        this.dj.setOnClickListener(this);
        this.di.setOnClickListener(this);
        this.cE.setOnClickListener(this);
    }

    private void bi() {
        findViewById(R.id.obfuscated_res_0x7f09121f).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f091220).setVisibility(8);
        this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091236);
        this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f09123a);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091232);
        this.dh = textView;
        com.kwad.sdk.b.kwai.a.a(this, this.cw, this.cx, textView);
        this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
        this.cw.setImageResource(R.drawable.obfuscated_res_0x7f080dfe);
        KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 8);
        this.dh.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        bf();
        this.dk.F(this.mAdTemplate);
        this.dk.setOnClickListener(this);
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, this.dk.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.dk.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        g(true);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f09121b);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091292)).setRatio(0.56f);
        this.df = (ImageView) findViewById(R.id.obfuscated_res_0x7f091221);
        this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f09121d);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09121e);
        this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091234);
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
        super.c((b) adTemplate);
        this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
        this.bq.T(adTemplate);
        List<String> aA = com.kwad.sdk.core.response.a.a.aA(this.mAdInfo);
        if (aA.size() > 0) {
            KSImageLoader.loadFeeImage(this.df, aA.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.b.e("BaseFeedTextImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            bi();
        } else {
            bh();
        }
        com.kwad.sdk.b.kwai.a.a(this, this.de, this.df, this.dg);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.feed.a.a
    public com.kwad.components.core.c.a.c getApkDownloadHelper() {
        return this.mApkDownloadHelper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dg) {
            pX();
            return;
        }
        final int i = 35;
        if (view2 == this.de) {
            i = 25;
        } else if (view2 == this.df) {
            i = 100;
        } else if (view2 == this.dk || view2 == this.cE || view2 == this.dj) {
            i = 1;
        } else if (view2 == this.cw) {
            i = 13;
        } else if (view2 == this.cx) {
            i = 14;
        } else if (view2 == this.dh || view2 == this.di) {
            i = 101;
        }
        g(false);
        com.kwad.components.core.c.a.a.a(new a.C0631a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.dk ? 1 : 2).aj(view2 == this.dk).a(new a.b() { // from class: com.kwad.components.ad.feed.a.b.1
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                b.this.aq(i);
            }
        }));
    }
}
