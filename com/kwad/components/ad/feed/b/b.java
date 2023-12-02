package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    public ImageView dE;
    public TextView dF;
    public TextView dM;
    public TextView eB;
    public ImageView eC;
    public ImageView eD;
    public RatioFrameLayout eE;
    public TextView eF;
    public TextView eG;
    public View eH;
    public DownloadProgressView eI;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public KsLogoView mLogoView;

    public b(@NonNull Context context) {
        super(context);
    }

    private void a(View view2, final int i) {
        int i2;
        if (view2 == this.eD) {
            ta();
            return;
        }
        ba();
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
        com.kwad.components.core.e.d.a.a(an.ao(z).a(new a.b() { // from class: com.kwad.components.ad.feed.b.b.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                b.this.aH(i);
            }
        }));
    }

    private void bd() {
        findViewById(R.id.obfuscated_res_0x7f0912ee).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f0912e5).setVisibility(8);
        this.eG = (TextView) findViewById(R.id.obfuscated_res_0x7f091370);
        this.dM = (TextView) findViewById(R.id.obfuscated_res_0x7f091372);
        this.eH = findViewById(R.id.obfuscated_res_0x7f091373);
        this.eG.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.eH.setOnClickListener(this);
        this.eG.setOnClickListener(this);
        this.dM.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.dM, this);
    }

    private void be() {
        findViewById(R.id.obfuscated_res_0x7f0912e5).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f0912ee).setVisibility(8);
        this.dE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091307);
        this.dF = (TextView) findViewById(R.id.obfuscated_res_0x7f09130b);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091303);
        this.eF = textView;
        com.kwad.sdk.d.a.a.a(this, this.dE, this.dF, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.dE.setImageResource(R.drawable.obfuscated_res_0x7f080e6a);
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 8);
        this.eF.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        bb();
        this.eI.ai(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        onClick(view2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            a(view2, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((b) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.mLogoView.aD(this.mAdTemplate);
        this.eC.post(new Runnable() { // from class: com.kwad.components.ad.feed.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(b.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.aU(dP).height > com.kwad.sdk.core.response.b.a.aU(dP).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.eE.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.eE.setRatio(1.7857142686843872d);
                    b.this.eE.setLayoutParams(layoutParams);
                }
                List<String> ba = com.kwad.sdk.core.response.b.a.ba(b.this.mAdInfo);
                if (ba.size() > 0) {
                    KSImageLoader.loadFeeImage(b.this.eC, ba.get(0), b.this.mAdTemplate, b.this.ez);
                } else {
                    com.kwad.sdk.core.e.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            be();
        } else {
            bd();
        }
        com.kwad.sdk.d.a.a.a(this, this.eB, this.eC, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e0);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091377);
        this.eE = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eC = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912ef);
        this.eD = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912e3);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912e4);
        this.eI = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091305);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        if (view2 == this.eB) {
            i = 25;
        } else if (view2 == this.eC) {
            i = 100;
        } else if (view2 != this.eI && view2 != this.dM && view2 != this.eH) {
            if (view2 == this.dE) {
                i = 13;
            } else if (view2 == this.dF) {
                i = 14;
            } else if (view2 != this.eF && view2 != this.eG) {
                i = 35;
            } else {
                i = 101;
            }
        } else {
            i = 1;
        }
        a(view2, i);
    }
}
