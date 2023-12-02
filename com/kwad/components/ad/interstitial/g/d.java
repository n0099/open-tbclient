package com.kwad.components.ad.interstitial.g;

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
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public final class d extends KSFrameLayout implements com.kwad.sdk.widget.c {
    public ImageView dE;
    public TextView eF;
    public ImageView eM;
    public KSFrameLayout kK;
    public KSFrameLayout kq;
    public String lE;
    @Nullable
    public View lF;
    public ImageView lG;
    public TextProgressBar lH;
    public ViewGroup lI;
    public ViewGroup lJ;
    public ImageView lK;
    public View lL;
    public View lM;
    public TextView lN;
    public ImageView lO;
    public TextView lP;
    public TextView lQ;
    public TextView lR;
    public TextProgressBar lS;
    public TextView lT;
    public e lU;
    public final a lV;
    public boolean lW;
    public AdTemplate mAdTemplate;
    public KsLogoView mLogoView;

    /* loaded from: classes10.dex */
    public static class a {
        public boolean lY = false;
        public boolean lZ = false;
        public int ma = 0;
        public boolean mb = true;

        public final int ei() {
            return this.ma;
        }

        public final boolean ej() {
            return this.mb;
        }

        public final void F(int i) {
            this.ma = i;
        }

        public final void v(boolean z) {
            this.lY = z;
        }

        public final void w(boolean z) {
            this.lZ = z;
        }

        public final void x(boolean z) {
            this.mb = z;
        }
    }

    public d(@NonNull Context context, a aVar) {
        super(context);
        int i;
        this.lE = "%s秒后进入试玩页";
        this.lW = false;
        this.lV = aVar;
        if (aVar.ej()) {
            i = R.layout.obfuscated_res_0x7f0d04e4;
        } else {
            i = R.layout.obfuscated_res_0x7f0d04e3;
        }
        l.inflate(context, i, this);
        s(this.lV.lY);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new f(kSFrameLayout, this);
        this.kK.setWidthBasedRatio(!z);
    }

    private void d(View view2, int i) {
        com.kwad.sdk.d.a.a.b(view2, 0, com.kwad.sdk.d.a.a.a(getContext(), i), 0, 0);
    }

    public final void b(boolean z, int i) {
        TextView textView = this.lT;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.lT.setText(String.format(this.lE, String.valueOf(i)));
        }
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (!bg.isNullString(str)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, str, adTemplate);
        }
    }

    public final void g(String str, int i) {
        TextProgressBar textProgressBar = this.lH;
        if (textProgressBar != null) {
            textProgressBar.e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.lS;
        if (textProgressBar2 != null) {
            textProgressBar2.e(str, 0);
        }
    }

    public final void h(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setLayoutParams(marginLayoutParams);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(e eVar) {
        this.lU = eVar;
    }

    public final void t(boolean z) {
        int i;
        if (this.lI != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            this.lI.setVisibility(i);
        }
    }

    public final void u(boolean z) {
        ImageView imageView = this.lK;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    public final void w(String str) {
        TextView textView = this.lN;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (this.lV.lZ && !this.lW && this.lN.getVisibility() != 0) {
            this.lN.setVisibility(0);
        }
    }

    public final void y(AdTemplate adTemplate) {
        this.mLogoView.aD(adTemplate);
    }

    private void a(View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = com.kwad.sdk.d.a.a.a(getContext(), i);
        layoutParams.height = com.kwad.sdk.d.a.a.a(getContext(), i2);
        view2.setLayoutParams(layoutParams);
    }

    private void b(View view2, boolean z) {
        e eVar;
        e eVar2;
        e eVar3 = this.lU;
        if (eVar3 != null) {
            eVar3.p(z);
            this.lU.a(this.kq);
        }
        if (view2.equals(this)) {
            e eVar4 = this.lU;
            if (eVar4 != null) {
                eVar4.dg();
            }
        } else if (view2.equals(this.lL)) {
            boolean z2 = true;
            if (1 != this.lV.ei()) {
                z2 = false;
            }
            if (z2 && (eVar2 = this.lU) != null) {
                eVar2.df();
            }
        } else if (view2.equals(this.lS)) {
            e eVar5 = this.lU;
            if (eVar5 != null) {
                eVar5.dh();
            }
        } else if (view2.equals(this.lJ)) {
            e eVar6 = this.lU;
            if (eVar6 != null) {
                eVar6.ds();
            }
        } else if (view2.equals(this.lH)) {
            e eVar7 = this.lU;
            if (eVar7 != null) {
                eVar7.di();
            }
        } else if (view2.equals(this.lM)) {
            e eVar8 = this.lU;
            if (eVar8 != null) {
                eVar8.dl();
            }
        } else if (view2.equals(this.kK)) {
            e eVar9 = this.lU;
            if (eVar9 != null) {
                eVar9.dj();
            }
        } else if (view2.equals(this.eM)) {
            e eVar10 = this.lU;
            if (eVar10 != null) {
                eVar10.dk();
            }
        } else if (view2.equals(this.dE)) {
            e eVar11 = this.lU;
            if (eVar11 != null) {
                eVar11.dm();
            }
        } else if (view2.equals(this.lP)) {
            e eVar12 = this.lU;
            if (eVar12 != null) {
                eVar12.dn();
            }
        } else if (view2.equals(this.eF)) {
            e eVar13 = this.lU;
            if (eVar13 != null) {
                eVar13.mo179do();
            }
        } else if (view2.equals(this.lO)) {
            e eVar14 = this.lU;
            if (eVar14 != null) {
                eVar14.dp();
            }
        } else if (view2.equals(this.lQ)) {
            e eVar15 = this.lU;
            if (eVar15 != null) {
                eVar15.dq();
            }
        } else if (view2.equals(this.lR) && (eVar = this.lU) != null) {
            eVar.dr();
        }
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        this.lO.setImageResource(R.drawable.obfuscated_res_0x7f080e6a);
        if (com.kwad.sdk.core.response.b.a.ca(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.lO, com.kwad.sdk.core.response.b.a.cG(adInfo), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e6a));
            this.lQ.setText(com.kwad.sdk.core.response.b.a.ce(adInfo));
            this.lR.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            if (com.kwad.sdk.core.response.b.a.cC(adInfo)) {
                this.lS.e(com.kwad.components.ad.d.b.X(), 0);
            } else {
                this.lS.e(com.kwad.components.ad.d.b.aa(), 0);
            }
        } else if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.ca(adInfo) == 3) {
            AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(adInfo);
            KSImageLoader.loadWithRadius(this.lO, cM.icon, adTemplate, 4);
            this.lQ.setText(cM.name);
            this.lR.setVisibility(8);
            this.lS.e(com.kwad.components.ad.d.b.Y(), 0);
        } else if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            KSImageLoader.loadWithRadius(this.lO, com.kwad.sdk.core.response.b.a.cf(adInfo), adTemplate, 4);
            this.lQ.setText(com.kwad.sdk.core.response.b.a.av(adInfo));
            this.lR.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.lS.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
        } else {
            KSImageLoader.loadWithRadius(this.lO, com.kwad.sdk.core.response.b.e.dU(adTemplate), adTemplate, 4);
            this.lQ.setText(com.kwad.sdk.core.response.b.a.cc(adInfo));
            this.lR.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.lS.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
        }
    }

    private void ec() {
        a(this.lO, 40, 40);
        a(this.lS, 130, 30);
        this.lQ.setTextSize(14.0f);
        d(this.lS, 11);
        d(this.lQ, 7);
        d(this.lR, 7);
    }

    public final void ed() {
        TextView textView = this.lN;
        if (textView != null) {
            textView.setVisibility(8);
            this.lW = true;
        }
    }

    public final void ee() {
        View view2 = this.lL;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void ef() {
        t(false);
        this.lJ.setVisibility(0);
        this.lG.setVisibility(0);
    }

    public final void eg() {
        this.lJ.setVisibility(8);
        this.lG.setVisibility(8);
        t(true);
    }

    public final boolean eh() {
        ViewGroup viewGroup = this.lJ;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public final View getBlurBgView() {
        return this.lF;
    }

    public final ImageView getTailFrameView() {
        return this.lG;
    }

    private void s(boolean z) {
        setClickable(true);
        this.kq = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091393);
        this.kK = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091394);
        this.lF = findViewById(R.id.obfuscated_res_0x7f091388);
        this.lG = (ImageView) findViewById(R.id.obfuscated_res_0x7f091398);
        this.eM = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f8);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912f4);
        this.lI = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091397);
        this.lJ = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091395);
        this.lH = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091387);
        this.lL = findViewById(R.id.obfuscated_res_0x7f091384);
        TextProgressBar textProgressBar = this.lH;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 10.0f));
            this.lH.setTextColor(-1);
        }
        this.lK = (ImageView) findViewById(R.id.obfuscated_res_0x7f091390);
        this.lN = (TextView) findViewById(R.id.obfuscated_res_0x7f091385);
        this.lO = (ImageView) findViewById(R.id.obfuscated_res_0x7f09138f);
        this.lQ = (TextView) findViewById(R.id.obfuscated_res_0x7f091391);
        this.lR = (TextView) findViewById(R.id.obfuscated_res_0x7f091386);
        this.lS = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091305);
        this.lM = findViewById(R.id.obfuscated_res_0x7f0912e5);
        this.dE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091307);
        this.lP = (TextView) findViewById(R.id.obfuscated_res_0x7f09130b);
        this.eF = (TextView) findViewById(R.id.obfuscated_res_0x7f091303);
        new f(this, this);
        new f(this.eM, this);
        new f(this.lH, this);
        new f(this.lS, this);
        new f(this.lL, this);
        new f(this.lJ, this);
        new f(this.lN, this);
        new f(this.lM, this);
        new f(this.dE, this);
        new f(this.lP, this);
        new f(this.eF, this);
        new f(this.lO, this);
        new f(this.lQ, this);
        new f(this.lR, this);
        this.lK.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.g.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.lK.setSelected(!d.this.lK.isSelected());
                if (d.this.lU != null) {
                    d.this.lU.o(d.this.lK.isSelected());
                }
            }
        });
        this.lT = (TextView) findViewById(R.id.obfuscated_res_0x7f091396);
        a(this.kK, z);
        if (!ai.isOrientationPortrait()) {
            ec();
        }
    }

    public final void a(float f, com.kwad.sdk.core.video.videoview.a aVar) {
        this.kK.setRatio(f);
        this.kK.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    public final void c(boolean z, boolean z2) {
        int i;
        if (this.eM != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            this.eM.setVisibility(i);
            this.eM.setClickable(z2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            b(view2, false);
        }
    }
}
