package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class f extends KSFrameLayout implements com.kwad.sdk.widget.c {
    public KsLogoView bq;
    public ImageView cw;
    public KSFrameLayout dN;
    public TextView dh;

    /* renamed from: do  reason: not valid java name */
    public ImageView f10do;
    public KSFrameLayout hn;
    public String iD;
    @Nullable
    public View iE;
    public ImageView iF;
    public TextProgressBar iG;
    public ViewGroup iH;
    public ViewGroup iI;
    public ImageView iJ;
    public View iK;
    public View iL;
    public TextView iM;
    public ImageView iN;
    public TextView iO;
    public TextView iP;
    public TextView iQ;
    public TextProgressBar iR;
    public TextView iS;
    public i iT;
    public final a iU;
    public boolean iV;
    public AdTemplate mAdTemplate;

    /* loaded from: classes10.dex */
    public static class a {
        public boolean iX = false;
        public boolean iY = false;
        public int iZ = 0;
        public boolean ja = true;

        public final void E(int i) {
            this.iZ = i;
        }

        public final int ee() {
            return this.iZ;
        }

        public final boolean ef() {
            return this.ja;
        }

        public final void v(boolean z) {
            this.iX = z;
        }

        public final void w(boolean z) {
            this.iY = z;
        }

        public final void x(boolean z) {
            this.ja = z;
        }
    }

    public f(@NonNull Context context, a aVar) {
        super(context);
        this.iD = "%s秒后进入试玩页";
        this.iV = false;
        this.iU = aVar;
        FrameLayout.inflate(context, aVar.ef() ? R.layout.obfuscated_res_0x7f0d04b4 : R.layout.obfuscated_res_0x7f0d04b3, this);
        s(this.iU.iX);
    }

    private void a(View view2, int i) {
        com.kwad.sdk.b.kwai.a.b(view2, 0, com.kwad.sdk.b.kwai.a.a(getContext(), i), 0, 0);
    }

    private void a(View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = com.kwad.sdk.b.kwai.a.a(getContext(), i);
        layoutParams.height = com.kwad.sdk.b.kwai.a.a(getContext(), i2);
        view2.setLayoutParams(layoutParams);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new com.kwad.sdk.widget.f(kSFrameLayout, this);
        this.dN.setWidthBasedRatio(!z);
    }

    private void b(View view2, boolean z) {
        i iVar;
        i iVar2;
        i iVar3 = this.iT;
        if (iVar3 != null) {
            iVar3.p(z);
            this.iT.a(this.hn);
        }
        if (view2.equals(this)) {
            i iVar4 = this.iT;
            if (iVar4 != null) {
                iVar4.di();
            }
        } else if (view2.equals(this.iK)) {
            if (!(1 == this.iU.ee()) || (iVar2 = this.iT) == null) {
                return;
            }
            iVar2.dh();
        } else if (view2.equals(this.iR)) {
            i iVar5 = this.iT;
            if (iVar5 != null) {
                iVar5.dj();
            }
        } else if (view2.equals(this.iI)) {
            i iVar6 = this.iT;
            if (iVar6 != null) {
                iVar6.du();
            }
        } else if (view2.equals(this.iG)) {
            i iVar7 = this.iT;
            if (iVar7 != null) {
                iVar7.dk();
            }
        } else if (view2.equals(this.iL)) {
            i iVar8 = this.iT;
            if (iVar8 != null) {
                iVar8.dn();
            }
        } else if (view2.equals(this.dN)) {
            i iVar9 = this.iT;
            if (iVar9 != null) {
                iVar9.dl();
            }
        } else if (view2.equals(this.f10do)) {
            i iVar10 = this.iT;
            if (iVar10 != null) {
                iVar10.dm();
            }
        } else if (view2.equals(this.cw)) {
            i iVar11 = this.iT;
            if (iVar11 != null) {
                iVar11.mo172do();
            }
        } else if (view2.equals(this.iO)) {
            i iVar12 = this.iT;
            if (iVar12 != null) {
                iVar12.dp();
            }
        } else if (view2.equals(this.dh)) {
            i iVar13 = this.iT;
            if (iVar13 != null) {
                iVar13.dq();
            }
        } else if (view2.equals(this.iN)) {
            i iVar14 = this.iT;
            if (iVar14 != null) {
                iVar14.dr();
            }
        } else if (view2.equals(this.iP)) {
            i iVar15 = this.iT;
            if (iVar15 != null) {
                iVar15.ds();
            }
        } else if (!view2.equals(this.iQ) || (iVar = this.iT) == null) {
        } else {
            iVar.dt();
        }
    }

    private void dY() {
        a(this.iN, 40, 40);
        a(this.iR, 130, 30);
        this.iP.setTextSize(14.0f);
        a(this.iR, 11);
        a(this.iP, 7);
        a(this.iQ, 7);
    }

    private void s(boolean z) {
        setClickable(true);
        this.hn = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0912f9);
        this.dN = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0912fa);
        this.iE = findViewById(R.id.obfuscated_res_0x7f0912ee);
        this.iF = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912fe);
        this.f10do = (ImageView) findViewById(R.id.obfuscated_res_0x7f091443);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091273);
        this.iH = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912fd);
        this.iI = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912fb);
        this.iG = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f0912ed);
        this.iK = findViewById(R.id.obfuscated_res_0x7f0912ea);
        TextProgressBar textProgressBar = this.iG;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f));
            this.iG.setTextColor(-1);
        }
        this.iJ = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912f6);
        this.iM = (TextView) findViewById(R.id.obfuscated_res_0x7f0912eb);
        this.iN = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912f5);
        this.iP = (TextView) findViewById(R.id.obfuscated_res_0x7f0912f7);
        this.iQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ec);
        this.iR = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091281);
        this.iL = findViewById(R.id.obfuscated_res_0x7f09126c);
        this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091283);
        this.iO = (TextView) findViewById(R.id.obfuscated_res_0x7f091287);
        this.dh = (TextView) findViewById(R.id.obfuscated_res_0x7f09127f);
        new com.kwad.sdk.widget.f(this, this);
        new com.kwad.sdk.widget.f(this.f10do, this);
        new com.kwad.sdk.widget.f(this.iG, this);
        new com.kwad.sdk.widget.f(this.iR, this);
        new com.kwad.sdk.widget.f(this.iK, this);
        new com.kwad.sdk.widget.f(this.iI, this);
        new com.kwad.sdk.widget.f(this.iM, this);
        new com.kwad.sdk.widget.f(this.iL, this);
        new com.kwad.sdk.widget.f(this.cw, this);
        new com.kwad.sdk.widget.f(this.iO, this);
        new com.kwad.sdk.widget.f(this.dh, this);
        new com.kwad.sdk.widget.f(this.iN, this);
        new com.kwad.sdk.widget.f(this.iP, this);
        new com.kwad.sdk.widget.f(this.iQ, this);
        this.iJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.widget.f.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.this.iJ.setSelected(!f.this.iJ.isSelected());
                if (f.this.iT != null) {
                    f.this.iT.o(f.this.iJ.isSelected());
                }
            }
        });
        this.iS = (TextView) findViewById(R.id.obfuscated_res_0x7f0912fc);
        a(this.dN, z);
        if (ag.zL()) {
            return;
        }
        dY();
    }

    public final void B(String str) {
        TextView textView = this.iM;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.iU.iY || this.iV || this.iM.getVisibility() == 0) {
            return;
        }
        this.iM.setVisibility(0);
    }

    public final void a(float f, com.kwad.sdk.core.video.videoview.a aVar) {
        this.dN.setRatio(f);
        this.dN.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String bl;
        TextProgressBar textProgressBar;
        String al;
        this.iN.setImageResource(R.drawable.obfuscated_res_0x7f080e36);
        if (com.kwad.sdk.core.response.a.a.bD(adInfo)) {
            KSImageLoader.loadCircleIcon(this.iN, com.kwad.sdk.core.response.a.a.bI(adInfo), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e36));
            this.iP.setText(com.kwad.sdk.core.response.a.a.bm(adInfo));
            this.iQ.setText(com.kwad.sdk.core.response.a.a.ad(adInfo));
            if (com.kwad.sdk.core.response.a.a.bE(adInfo)) {
                textProgressBar = this.iR;
                al = com.kwad.components.ad.c.b.ah();
            } else {
                textProgressBar = this.iR;
                al = com.kwad.components.ad.c.b.ak();
            }
        } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
            KSImageLoader.loadWithRadius(this.iN, bN.icon, adTemplate, 4);
            this.iP.setText(bN.name);
            this.iQ.setVisibility(8);
            textProgressBar = this.iR;
            al = com.kwad.components.ad.c.b.ai();
        } else {
            if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
                KSImageLoader.loadWithRadius(this.iN, com.kwad.sdk.core.response.a.a.bn(adInfo), adTemplate, 4);
                textView = this.iP;
                bl = com.kwad.sdk.core.response.a.a.ae(adInfo);
            } else {
                KSImageLoader.loadWithRadius(this.iN, com.kwad.sdk.core.response.a.d.bU(adTemplate), adTemplate, 4);
                textView = this.iP;
                bl = com.kwad.sdk.core.response.a.a.bl(adInfo);
            }
            textView.setText(bl);
            this.iQ.setText(com.kwad.sdk.core.response.a.a.ad(adInfo));
            textProgressBar = this.iR;
            al = com.kwad.sdk.core.response.a.a.al(adInfo);
        }
        textProgressBar.f(al, 0);
    }

    public final void a(String str, AdTemplate adTemplate) {
        if (ax.dT(str)) {
            return;
        }
        this.f10do.setImageDrawable(null);
        KSImageLoader.loadImage(this.f10do, str, adTemplate);
    }

    public final void b(boolean z, int i) {
        TextView textView = this.iS;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.iS.setText(String.format(this.iD, String.valueOf(i)));
        }
    }

    public final void b(boolean z, boolean z2) {
        if (this.f10do != null) {
            this.f10do.setVisibility(z ? 0 : 8);
            this.f10do.setClickable(z2);
        }
    }

    public final void dZ() {
        TextView textView = this.iM;
        if (textView != null) {
            textView.setVisibility(8);
            this.iV = true;
        }
    }

    public final void ea() {
        View view2 = this.iK;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void eb() {
        t(false);
        this.iI.setVisibility(0);
        this.iF.setVisibility(0);
    }

    public final void ec() {
        this.iI.setVisibility(8);
        this.iF.setVisibility(8);
        t(true);
    }

    public final boolean ed() {
        ViewGroup viewGroup = this.iI;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final void f(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setLayoutParams(marginLayoutParams);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public final void g(String str, int i) {
        TextProgressBar textProgressBar = this.iG;
        if (textProgressBar != null) {
            textProgressBar.f(str, 0);
        }
        TextProgressBar textProgressBar2 = this.iR;
        if (textProgressBar2 != null) {
            textProgressBar2.f(str, 0);
        }
    }

    @Nullable
    public final View getBlurBgView() {
        return this.iE;
    }

    public final ImageView getTailFrameView() {
        return this.iF;
    }

    public final void i(AdTemplate adTemplate) {
        this.bq.T(adTemplate);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(i iVar) {
        this.iT = iVar;
    }

    public final void t(boolean z) {
        if (this.iH != null) {
            this.iH.setVisibility(z ? 0 : 8);
        }
    }

    public final void u(boolean z) {
        ImageView imageView = this.iJ;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }
}
