package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSRatingBar;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class n extends d implements View.OnClickListener {
    public KsLogoView bq;
    public TextView eQ;
    public TextView iu;
    public AdTemplate mAdTemplate;
    public DetailVideoView mj;
    public ImageView nC;
    public com.kwad.components.ad.reward.k nM;
    public ViewGroup pV;
    public int qC = Integer.MIN_VALUE;
    public ViewGroup vM;
    public KSRatingBar vN;
    public TextView vO;
    public KsStyledTextButton vP;
    public TextView vQ;
    public ViewStub vk;

    /* loaded from: classes10.dex */
    public static class a {
        public String kY;
        public String np;
        public String title;
        public float vS;
        public String vT;

        public static a m(AdInfo adInfo) {
            if (adInfo == null) {
                return null;
            }
            a aVar = new a();
            aVar.title = com.kwad.sdk.core.response.a.a.bl(adInfo);
            aVar.np = com.kwad.sdk.core.response.a.a.ad(adInfo);
            aVar.kY = com.kwad.sdk.core.response.a.a.bn(adInfo);
            aVar.vS = com.kwad.sdk.core.response.a.a.aj(adInfo);
            aVar.vT = com.kwad.sdk.core.response.a.a.ah(adInfo);
            return aVar;
        }

        public final String eL() {
            return this.kY;
        }

        public final String fO() {
            return this.np;
        }

        public final float getRating() {
            return this.vS;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String ja() {
            return this.vT;
        }
    }

    public n(AdTemplate adTemplate, com.kwad.components.ad.reward.k kVar, ViewGroup viewGroup, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.pV = viewGroup;
        this.nM = kVar;
        this.mj = detailVideoView;
    }

    public n(AdTemplate adTemplate, com.kwad.components.ad.reward.k kVar, ViewStub viewStub, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.vk = viewStub;
        this.nM = kVar;
        this.mj = detailVideoView;
    }

    private void iZ() {
        ViewGroup viewGroup = this.vM;
        if (viewGroup == null) {
            return;
        }
        boolean cB = ag.cB(viewGroup.getContext());
        if (this.vM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.vM.getLayoutParams();
            if (cB) {
                int dimensionPixelSize = this.vM.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e4);
                layoutParams.width = -1;
                layoutParams.height = dimensionPixelSize;
            } else {
                layoutParams.width = com.kwad.sdk.b.kwai.a.getScreenWidth(this.vM.getContext()) / 2;
                layoutParams.height = -1;
            }
            this.vM.setLayoutParams(layoutParams);
        }
    }

    private void initView() {
        this.vM = (ViewGroup) this.pV.findViewById(R.id.obfuscated_res_0x7f09131d);
        this.bq = (KsLogoView) this.pV.findViewById(R.id.obfuscated_res_0x7f091321);
        this.nC = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091320);
        this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091324);
        this.vN = (KSRatingBar) this.pV.findViewById(R.id.obfuscated_res_0x7f091323);
        this.vO = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09131e);
        this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09131f);
        this.vP = (KsStyledTextButton) this.pV.findViewById(R.id.obfuscated_res_0x7f09131c);
        this.vQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09131b);
        this.vM.setOnClickListener(this);
        this.vQ.setOnClickListener(this);
        this.vP.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(View view2) {
        if (view2 == null || view2.getWidth() == 0) {
            return;
        }
        if (ag.cB(view2.getContext())) {
            view2.setVisibility(0);
            Animator a2 = r.a(this.mAdTemplate, this.vM, this.mj);
            if (a2 != null) {
                a2.start();
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = -view2.getWidth();
            this.vM.setLayoutParams(marginLayoutParams);
            Animator a3 = r.a(this.mAdTemplate, this.mj, view2);
            view2.setVisibility(0);
            if (a3 != null) {
                a3.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        AdTemplate adTemplate = uVar.getAdTemplate();
        this.bq.T(adTemplate);
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        a m = a.m(bQ);
        this.eQ.setText(m.getTitle());
        this.vO.setText(m.ja());
        this.iu.setText(m.fO());
        this.vP.setText(com.kwad.sdk.core.response.a.a.al(bQ));
        boolean am = com.kwad.sdk.core.response.a.a.am(bQ);
        boolean cB = ag.cB(this.vM.getContext());
        Resources resources = this.vM.getResources();
        ViewGroup.LayoutParams layoutParams = this.nC.getLayoutParams();
        int i = 18;
        if (layoutParams != null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e5);
            if (!cB) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e7);
                i = 14;
            } else if (am) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e6);
                i = 24;
            }
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.nC.setLayoutParams(layoutParams);
        }
        KSImageLoader.loadAppIcon(this.nC, m.eL(), adTemplate, i);
        if (cB && am) {
            if (m.getRating() < 0.0f) {
                this.vN.setVisibility(8);
            } else {
                this.vN.setVisibility(0);
                this.vN.setStar(m.getRating());
            }
            if (m.ja() == null) {
                this.vO.setVisibility(8);
            } else {
                this.vO.setVisibility(0);
                this.vO.setText(m.ja());
            }
        }
        if (am) {
            return;
        }
        this.vO.setVisibility(8);
        this.vN.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void aa(boolean z) {
        Resources resources = this.vM.getResources();
        ViewGroup.LayoutParams layoutParams = this.vM.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (z) {
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = fR().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e1);
            }
            this.vM.setBackgroundColor(-1);
            this.eQ.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06079b));
            this.iu.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060792));
            this.qC = com.kwad.sdk.b.kwai.a.A(this.mj);
            com.kwad.sdk.b.kwai.a.i(this.mj, 49);
        } else {
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = 0;
            }
            this.eQ.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06079c));
            this.iu.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060793));
            this.vM.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060799));
        }
        if (marginLayoutParams != null) {
            this.vM.setLayoutParams(marginLayoutParams);
        }
    }

    public final void bt() {
        int i;
        DetailVideoView detailVideoView = this.mj;
        if (detailVideoView == null || (i = this.qC) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.b.kwai.a.i(detailVideoView, i);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.pV;
    }

    public final void hide() {
        ViewGroup viewGroup = this.pV;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.vQ)) {
            this.nM.fu();
            com.kwad.sdk.core.report.a.r(this.mAdTemplate, 164);
        } else if (view2.equals(this.vM)) {
            this.nM.a(view2.getContext(), 2, 2);
        } else if (view2.equals(this.vP)) {
            this.nM.a(view2.getContext(), 2, 1);
        }
    }

    public final void show() {
        ViewStub viewStub;
        if (this.pV == null && (viewStub = this.vk) != null) {
            this.pV = (ViewGroup) viewStub.inflate();
            initView();
        }
        if (this.bq == null) {
            initView();
        }
        if (this.pV != null) {
            iZ();
            this.pV.setVisibility(0);
            this.pV.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    n nVar = n.this;
                    nVar.p(nVar.vM);
                }
            });
            u.b bVar = new u.b();
            bVar.aca = 205;
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 164, bVar, (JSONObject) null);
        }
    }
}
