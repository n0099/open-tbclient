package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class o extends s implements View.OnClickListener {
    public TextView lv;
    public com.kwad.components.ad.reward.g qn;
    public KsLogoView zJ;
    public KsLogoView zK;
    public KsAuthorIconView zL;
    public RelativeLayout zM;
    public String zO;
    public TextView zj;
    public TextView zk;
    public boolean zN = false;
    public Runnable zP = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.d.a.a.a(o.this.lv, o.this.zO, KsLogoView.a(o.this.zJ));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                o.this.lv.setText(o.this.zO);
                o.this.lv.setVisibility(0);
            }
        }
    };

    public o(com.kwad.components.ad.reward.g gVar) {
        this.qn = gVar;
    }

    private void b(AdTemplate adTemplate) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.zj.setText(com.kwad.sdk.core.response.b.a.cc(dP));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.zL.setVisibility(0);
        this.zL.b(adTemplate);
        this.zL.a(eVar);
        this.zk.setText(com.kwad.sdk.core.response.b.a.aE(dP));
        if (com.kwad.sdk.core.response.b.a.bf(dP) == 8) {
            this.zK.setVisibility(0);
            this.zK.aD(adTemplate);
            this.lv.setText(com.kwad.sdk.core.response.b.a.au(dP));
            return;
        }
        this.zO = com.kwad.sdk.core.response.b.a.au(dP);
        KsLogoView ksLogoView = new KsLogoView(this.sy.getContext(), false);
        this.zJ = ksLogoView;
        ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
            @Override // com.kwad.components.core.widget.KsLogoView.a
            public final void ka() {
                o.this.lv.post(o.this.zP);
            }
        });
        this.zJ.aD(adTemplate);
        this.zK.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ab(boolean z) {
        super.ab(z);
        Context context = this.sy.getContext();
        if (!ai.Kx()) {
            if (!this.zN) {
                this.sy.findViewById(R.id.obfuscated_res_0x7f09146f).setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.zM.getLayoutParams();
                layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e5);
                this.zM.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.zk.getLayoutParams();
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e5);
                this.zk.setLayoutParams(layoutParams2);
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = this.sy.getLayoutParams();
            layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e5);
            this.sy.setLayoutParams(layoutParams3);
            h(this.sy, 85);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.zk)) {
            this.qn.a(1, view2.getContext(), 29, 1);
        } else if (view2.equals(this.zL)) {
            this.qn.a(1, view2.getContext(), 30, 1);
        } else if (view2.equals(this.lv)) {
            this.qn.a(1, view2.getContext(), 32, 1);
        } else if (view2.equals(this.zj)) {
            this.qn.a(1, view2.getContext(), 31, 1);
        } else if (view2.equals(this.sy)) {
            this.qn.a(1, view2.getContext(), 53, 2);
        }
    }

    public static void h(View view2, int i) {
        if (view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.d.a.a.a(view2.getContext(), 20.0f);
            view2.requestLayout();
        }
    }

    public final void a(ViewGroup viewGroup, int i) {
        if (i == 8) {
            super.a(viewGroup, R.id.obfuscated_res_0x7f091474, R.id.obfuscated_res_0x7f091473);
            this.zN = true;
        } else {
            super.a(viewGroup, R.id.obfuscated_res_0x7f091470, R.id.obfuscated_res_0x7f091473);
            this.zN = false;
        }
        initView();
    }

    private void initView() {
        ViewGroup viewGroup = this.sy;
        if (viewGroup == null) {
            return;
        }
        this.zL = (KsAuthorIconView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913af);
        this.zj = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091523);
        this.lv = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091522);
        this.zk = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913ae);
        this.zK = (KsLogoView) this.sy.findViewById(R.id.obfuscated_res_0x7f091449);
        if (!this.zN) {
            this.zM = (RelativeLayout) this.sy.findViewById(R.id.obfuscated_res_0x7f091472);
        }
        this.sy.setOnClickListener(this);
        this.zk.setOnClickListener(this);
        this.zL.setOnClickListener(this);
        this.lv.setOnClickListener(this);
        this.zj.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        b(rVar.getAdTemplate());
    }
}
