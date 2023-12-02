package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes10.dex */
public final class l extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    public TextView eB;
    public ImageView eD;
    public DownloadProgressView eI;
    public long ey;
    public RoundAngleImageView fv;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public KsLogoView mLogoView;

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04d1;
    }

    public l(@NonNull Context context) {
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
        } else if (view2 == this.fv) {
            i = 100;
        } else if (view2 == this.eI) {
            i = 1;
        } else {
            i = 35;
        }
        c(view2, i);
    }

    private void be() {
        this.mLogoView.aD(this.mAdTemplate);
        this.eI.ai(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.eI.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bb();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e0);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091377)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f0912ef);
        this.fv = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.d.a.a.a(getContext(), 3.0f));
        this.eD = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912e3);
        this.eI = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091305);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091369);
    }

    private void c(View view2, final int i) {
        int i2;
        if (view2 == this.eD) {
            ta();
            return;
        }
        boolean z = true;
        if (view2 == this.eI) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        a.C0644a an = new a.C0644a(getContext()).aq(this.mAdTemplate).al(5).am(i).b(this.mApkDownloadHelper).an(i2);
        if (view2 != this.eI) {
            z = false;
        }
        com.kwad.components.core.e.d.a.a(an.ao(z).a(new a.b() { // from class: com.kwad.components.ad.feed.b.l.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                l.this.aH(i);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((l) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        List<String> ba = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        if (ba.size() > 0) {
            this.ey = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.fv, ba.get(0), this.mAdTemplate, this.ez);
        } else {
            com.kwad.sdk.core.e.c.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        be();
        com.kwad.sdk.d.a.a.a(this, this.eB, this.fv, this.eI, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.fv, this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
    }
}
